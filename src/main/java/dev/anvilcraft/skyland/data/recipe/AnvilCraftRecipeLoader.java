package dev.anvilcraft.skyland.data.recipe;

import dev.anvilcraft.lib.v2.registrum.providers.RegistrumRecipeProvider;
import dev.anvilcraft.skyland.integration.anvilcraft.init.AnvilCraftIntegrationRegistries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

/**
 * AnvilCraft 联动配方
 */
public class AnvilCraftRecipeLoader {
    public static void init(RegistrumRecipeProvider provider) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, AnvilCraftIntegrationRegistries.STONE_ANVIL.get())
            .pattern("AAA")
            .pattern(" B ")
            .pattern("BBB")
            .define('A', Blocks.COBBLESTONE)
            .define('B', AnvilCraftIntegrationRegistries.PEBBLE.get())
            .unlockedBy("has_pebble", SkylandRecipeProvider.has(AnvilCraftIntegrationRegistries.PEBBLE.get()))
            .save(provider);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, Blocks.COBBLESTONE)
            .requires(AnvilCraftIntegrationRegistries.PEBBLE.get(), 9)
            .unlockedBy("has_pebble", SkylandRecipeProvider.has(AnvilCraftIntegrationRegistries.PEBBLE.get()))
            .save(provider, "skyland:pebble_2_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, Blocks.MOSS_BLOCK)
            .requires(AnvilCraftIntegrationRegistries.MOSS.get(), 9)
            .unlockedBy("has_moss", SkylandRecipeProvider.has(AnvilCraftIntegrationRegistries.MOSS.get()))
            .save(provider, "skyland:moss_2_block");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_SLAB)
            .pattern("XX")
            .pattern("XX")
            .define('X', Items.BAMBOO)
            .unlockedBy("has_bamboo", SkylandRecipeProvider.has(Items.BAMBOO))
            .save(provider, "skyland:bamboo_2_slab");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_PLANKS)
            .pattern("XX")
            .define('X', Items.BAMBOO_SLAB)
            .unlockedBy("has_bamboo_slab", SkylandRecipeProvider.has(Items.BAMBOO_SLAB))
            .save(provider, "skyland:bamboo_slab_2_block");
    }
}
