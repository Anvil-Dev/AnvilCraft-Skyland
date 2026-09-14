package dev.anvilcraft.skyland.integration.anvilcraft.data;

import dev.anvilcraft.lib.v2.registrum.providers.ProviderType;
import dev.anvilcraft.skyland.integration.anvilcraft.data.recipe.AnvilCraftRecipeHandler;

import static dev.anvilcraft.skyland.Skyland.REGISTRUM;

public class AnvilCraftSkylandDatagen {
    /**
     * 初始化生成器
     */
    public static void init() {
        REGISTRUM.addDataGenerator(ProviderType.RECIPE, AnvilCraftRecipeHandler::init);
    }
}
