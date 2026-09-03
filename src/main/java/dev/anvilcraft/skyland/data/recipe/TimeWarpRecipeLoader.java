package dev.anvilcraft.skyland.data.recipe;

import dev.anvilcraft.lib.v2.registrum.providers.RegistrumRecipeProvider;
import dev.anvilcraft.skyland.Skyland;
import dev.dubhe.anvilcraft.init.item.ModItems;
import dev.dubhe.anvilcraft.recipe.anvil.wrap.TimeWarpRecipe;
import net.minecraft.world.item.Items;

/**
 * 时移配方生成器，仿照 AnvilCraft 的 TimeWarpRecipeLoader
 */
public class TimeWarpRecipeLoader {
    public static void init(RegistrumRecipeProvider provider) {
        TimeWarpRecipe.builder()
            .requires(Items.BONE, 4)
            .requires(Items.PHANTOM_MEMBRANE, 8)
            .requires(Items.EGG)
            .requires(Items.SLIME_BALL)
            .requires(ModItems.LEVITATION_POWDER)
            .result(Items.ELYTRA)
            .save(provider, Skyland.of("time_warp/elytra"));
    }
}