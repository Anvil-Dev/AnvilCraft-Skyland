package dev.anvilcraft.skyland.data.recipe;

import dev.anvilcraft.lib.v2.registrum.providers.RegistrumRecipeProvider;
import dev.anvilcraft.skyland.Skyland;
import dev.dubhe.anvilcraft.AnvilCraft;
import dev.dubhe.anvilcraft.init.block.ModFluids;
import dev.dubhe.anvilcraft.init.item.ModComponents;
import dev.dubhe.anvilcraft.init.item.ModItems;
import dev.dubhe.anvilcraft.recipe.anvil.wrap.SolidLiquidRecipe;
import dev.dubhe.anvilcraft.util.FluidStackPredicate;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.fluids.FluidStack;

public class SolidLiquidRecipeLoader {
    public static void init(RegistrumRecipeProvider provider){
        SolidLiquidRecipe.builder()
            .cauldron(ModFluids.POWDER_SNOW.get())
            .consume(1000)
            .requires(ModItems.EMBER_METAL_UPGRADE_SMITHING_TEMPLATE, 1)
            .result(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE,1)
            .save(provider, Skyland.of("solid_liquid/netherite_upgrade_smithing_template"));
    }

    private static void solidLiquid(RegistrumRecipeProvider provider, ItemLike input, ItemLike result, int consume) {
        SolidLiquidRecipe.builder()
            .cauldron(Blocks.WATER_CAULDRON)
            .requires(input)
            .result(result)
            .consume(consume)
            .save(provider);
    }

    private static void solidLiquid(RegistrumRecipeProvider provider, ItemLike input, ItemLike result) {
        solidLiquid(provider, input, result, 0);
    }

    @SuppressWarnings("SameParameterValue")
    private static void solidLiquid(RegistrumRecipeProvider provider, TagKey<Item> input, ItemLike result, int consume) {
        SolidLiquidRecipe.builder()
            .cauldron(Blocks.WATER_CAULDRON)
            .requires(input)
            .result(result)
            .consume(consume)
            .save(provider);
    }

    @SuppressWarnings("SameParameterValue")
    private static void solidLiquid(RegistrumRecipeProvider provider, TagKey<Item> input, ItemLike result) {
        solidLiquid(provider, input, result, 0);
    }

    @SafeVarargs
    @SuppressWarnings("SameParameterValue")
    private static void liquidEnchantment(
        RegistrumRecipeProvider provider,
        ItemLike input,
        int amount,
        ResourceKey<Enchantment>... enchantments
    ) {
        SolidLiquidRecipe.Builder builder = SolidLiquidRecipe.builder()
            .cauldron(
                FluidStackPredicate.builder()
                    .fluid(ModFluids.LIQUID_ENCHANTMENT)
                    .component(b -> b.expectNull(ModComponents.LIQUID_ENCHANTMENT))
                    .build()
            )
            .consume(amount)
            .requires(input);
        int each = amount / enchantments.length;
        StringBuilder idBuilder = new StringBuilder();
        for (ResourceKey<Enchantment> enchantment : enchantments) {
            FluidStack stack = new FluidStack(ModFluids.LIQUID_ENCHANTMENT.get(), each);
            stack.set(ModComponents.LIQUID_ENCHANTMENT, enchantment);
            builder.transform(stack);
            idBuilder.append(enchantment.location().getPath());
            idBuilder.append("_and_");
        }
        String id = idBuilder.substring(0, idBuilder.length() - 5);
        builder.save(provider, Skyland.of("solid_liquid/" + id));
    }
}
