package dev.anvilcraft.skyland.gen;

import dev.anvilcraft.skyland.Skyland;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.presets.WorldPreset;
import org.jetbrains.annotations.NotNull;


/**
 * from <a href="https://github.com/TreeOfSelf/CarpetSkyAdditions-Reborn/">TreeOfSelf/CarpetSkyAdditions-Reborn</a>
 */
public class SkylandWorldPresets {
    public static final ResourceKey<WorldPreset> SKYLAND = preset("skyland");

    private static @NotNull ResourceKey<WorldPreset> preset(@SuppressWarnings("SameParameterValue") String path) {
        return ResourceKey.create(Registries.WORLD_PRESET, Skyland.of(path));
    }
}
