package dev.apotheosis_material_things;

import dev.apotheosis_material_things.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * Main entrypoint for Apotheosis Material Things.
 */
@Mod(ApotheosisMaterialThings.MOD_ID)
public class ApotheosisMaterialThings {
    public static final String MOD_ID = "apotheosis_material_things";

    public ApotheosisMaterialThings(FMLJavaModLoadingContext context) {
        context.registerConfig(Type.COMMON, ModConfig.COMMON_SPEC);
    }
}
