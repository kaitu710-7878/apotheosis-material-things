package dev.apotheosis_material_things.loot;

import dev.apotheosis_material_things.ApotheosisMaterialThings;
import dev.apotheosis_material_things.config.ModConfig;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithLootingCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashSet;
import java.util.Set;

/**
 * Injects a common rarity material drop pool directly into hostile mob loot tables
 * so that loot table viewer mods (e.g., JER, EMI Loot) can inspect and display it.
 */
@Mod.EventBusSubscriber(modid = ApotheosisMaterialThings.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CommonMaterialLootTableHandler {
    private static final ResourceLocation COMMON_MATERIAL_ID = ResourceLocation.tryBuild("apotheosis", "common_material");
    private static final String POOL_NAME = "apotheosis_material_things_common_material";

    private static volatile Set<ResourceLocation> hostileMobLootTables;

    @SubscribeEvent
    public static void onLootTableLoad(LootTableLoadEvent event) {
        if (!ModConfig.COMMON.enableCommonMaterialDrop.get()) {
            return;
        }
        if (!getHostileMobLootTables().contains(event.getName())) {
            return;
        }

        Item commonMaterial = ForgeRegistries.ITEMS.getValue(COMMON_MATERIAL_ID);
        if (commonMaterial == null || commonMaterial == Items.AIR) {
            return;
        }

        float baseChance = ModConfig.COMMON.dropChance.get().floatValue();
        float lootingBonus = ModConfig.COMMON.lootingBonusPerLevel.get().floatValue();
        if (baseChance <= 0.0F && lootingBonus <= 0.0F) {
            return;
        }

        LootPoolSingletonContainer.Builder<?> entryBuilder = LootItem.lootTableItem(commonMaterial)
                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(baseChance, lootingBonus));

        if (ModConfig.COMMON.requirePlayerKill.get()) {
            entryBuilder.when(LootItemKilledByPlayerCondition.killedByPlayer());
        }

        LootPool pool = LootPool.lootPool()
                .name(POOL_NAME)
                .setRolls(ConstantValue.exactly(1.0F))
                .add(entryBuilder)
                .build();

        event.getTable().addPool(pool);
    }

    private static Set<ResourceLocation> getHostileMobLootTables() {
        Set<ResourceLocation> cached = hostileMobLootTables;
        if (cached != null) {
            return cached;
        }

        Set<ResourceLocation> tables = new HashSet<>();
        for (EntityType<?> entityType : ForgeRegistries.ENTITY_TYPES.getValues()) {
            if (entityType.getCategory() == MobCategory.MONSTER) {
                ResourceLocation lootTableId = entityType.getDefaultLootTable();
                if (!BuiltInLootTables.EMPTY.equals(lootTableId)) {
                    tables.add(lootTableId);
                }
            }
        }

        hostileMobLootTables = tables;
        return tables;
    }
}
