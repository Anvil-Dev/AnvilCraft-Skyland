package dev.anvilcraft.skyland.integration.anvilcraft.data.recipe;

import dev.anvilcraft.lib.v2.registrum.providers.RegistrumRecipeProvider;

/**
 * 配方生成入口
 */
public class AnvilCraftRecipeHandler {
    public static void init(RegistrumRecipeProvider provider) {
        SolidLiquidRecipeLoader.init(provider);
        CoolingRecipeLoader.init(provider);
        AnvilCraftRecipeLoader.init(provider);
        TimeWarpRecipeLoader.init(provider);
        ItemCrushRecipeLoader.init(provider);
    }
}
