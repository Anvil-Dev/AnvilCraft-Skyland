package dev.anvilcraft.skyland.data.recipe;

import dev.anvilcraft.lib.v2.registrum.providers.RegistrumRecipeProvider;

/**
 * 配方生成入口
 */
public class RecipeHandler {
    public static void init(RegistrumRecipeProvider provider) {
        AnvilCraftRecipeLoader.init(provider);
        TimeWarpRecipeLoader.init(provider);
        ItemCrushRecipeLoader.init(provider);
    }
}
