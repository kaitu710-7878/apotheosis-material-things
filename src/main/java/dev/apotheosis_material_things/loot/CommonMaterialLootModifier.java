package dev.apotheosis_material_things.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.apotheosis_material_things.config.ModConfig;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

/**
 * Global loot modifier that adds a configurable chance (affected by Looting)
 * for hostile mobs to drop a common rarity material.
 */
public class CommonMaterialLootModifier extends LootModifier {
    public static final Supplier<Codec<CommonMaterialLootModifier>> CODEC = Suppliers.memoize(() ->
            RecordCodecBuilder.create(inst -> codecStart(inst)
                    .and(ForgeRegistries.ITEMS.getCodec().fieldOf("item").forGetter(m -> m.item))
                    .apply(inst, CommonMaterialLootModifier::new)));

    private final Item item;

    public CommonMaterialLootModifier(LootItemCondition[] conditionsIn, Item item) {
        super(conditionsIn);
        this.item = item;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if (!ModConfig.COMMON.enableCommonMaterialDrop.get() || this.item == Items.AIR) {
            return generatedLoot;
        }
        if (!context.hasParam(LootContextParams.DAMAGE_SOURCE)) {
            return generatedLoot;
        }
        Entity entity = context.getParamOrNull(LootContextParams.THIS_ENTITY);
        if (!isHostileMob(entity)) {
            return generatedLoot;
        }
        if (ModConfig.COMMON.requirePlayerKill.get() && !context.hasParam(LootContextParams.LAST_DAMAGE_PLAYER)) {
            return generatedLoot;
        }

        double baseChance = ModConfig.COMMON.dropChance.get();
        double lootingBonus = ModConfig.COMMON.lootingBonusPerLevel.get();
        int lootingLevel = Math.max(0, context.getLootingModifier());
        double finalChance = Math.min(1.0D, baseChance + (lootingLevel * lootingBonus));

        if (finalChance > 0.0D && context.getRandom().nextDouble() < finalChance) {
            generatedLoot.add(new ItemStack(this.item));
        }

        return generatedLoot;
    }

    private static boolean isHostileMob(Entity entity) {
        if (entity == null) {
            return false;
        }
        return entity instanceof Enemy || entity.getType().getCategory() == MobCategory.MONSTER;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
