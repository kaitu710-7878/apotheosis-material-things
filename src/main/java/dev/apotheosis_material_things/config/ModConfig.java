package dev.apotheosis_material_things.config;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Common configuration for Apotheosis Material Things.
 */
public class ModConfig {
    public static final ForgeConfigSpec COMMON_SPEC;
    public static final CommonConfig COMMON;

    static {
        Pair<CommonConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(CommonConfig::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();
    }

    public static class CommonConfig {
        public final ForgeConfigSpec.BooleanValue enableCommonMaterialDrop;
        public final ForgeConfigSpec.DoubleValue dropChance;
        public final ForgeConfigSpec.DoubleValue lootingBonusPerLevel;
        public final ForgeConfigSpec.BooleanValue requirePlayerKill;

        public CommonConfig(ForgeConfigSpec.Builder builder) {
            builder.push("hostile_mob_drops");

            enableCommonMaterialDrop = builder
                    .comment("Enable common rarity material drops from hostile mobs.")
                    .translation("config.apotheosis_material_things.enable_common_material_drop")
                    .define("enableCommonMaterialDrop", true);

            dropChance = builder
                    .comment("Base drop chance for common rarity material from hostile mobs (0.04 = 4%).")
                    .translation("config.apotheosis_material_things.drop_chance")
                    .defineInRange("dropChance", 0.04D, 0.0D, 1.0D);

            lootingBonusPerLevel = builder
                    .comment("Additional drop chance per level of Looting (0.01 = +1% per level).")
                    .translation("config.apotheosis_material_things.looting_bonus_per_level")
                    .defineInRange("lootingBonusPerLevel", 0.01D, 0.0D, 1.0D);

            requirePlayerKill = builder
                    .comment("If true, common rarity materials only drop when killed by a player.")
                    .translation("config.apotheosis_material_things.require_player_kill")
                    .define("requirePlayerKill", false);

            builder.pop();
        }
    }
}
