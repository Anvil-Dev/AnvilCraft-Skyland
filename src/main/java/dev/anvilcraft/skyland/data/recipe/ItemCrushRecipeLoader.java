package dev.anvilcraft.skyland.data.recipe;

import dev.anvilcraft.lib.v2.registrum.providers.RegistrumRecipeProvider;
import dev.anvilcraft.skyland.Skyland;
import dev.dubhe.anvilcraft.init.item.ModItems;
import dev.dubhe.anvilcraft.recipe.anvil.wrap.ItemCrushRecipe;
import net.minecraft.world.item.Items;

/**
 * 粉碎配方生成器，仿照 AnvilCraft 的 ItemCrushRecipeLoader
 */
public class ItemCrushRecipeLoader {
    public static void init(RegistrumRecipeProvider provider) {
        ItemCrushRecipe.builder()
            .requires(Items.SHULKER_BOX)
            .result(Items.SHULKER_SHELL)
            .save(provider, Skyland.of("item_crush/shulker_shell"));
    }
}