package dev.anvilcraft.skyland.gen.feature;

import dev.anvilcraft.skyland.Skyland;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.NotNull;

/**
 * from <a href="https://github.com/TreeOfSelf/CarpetSkyAdditions-Reborn/">TreeOfSelf/CarpetSkyAdditions-Reborn</a>
 */
public abstract class SkylandConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPAWN_PLATFORM = feature("spawn_platform");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKY_ISLAND = feature("sky_island");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GATEWAY_ISLAND = feature("end_gateway_island");

    private static @NotNull ResourceKey<ConfiguredFeature<?, ?>> feature(String path) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Skyland.of(path));
    }
}
