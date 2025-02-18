package dev.anvilcraft.skyland.gen.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

/**
 * from <a href="https://github.com/TreeOfSelf/CarpetSkyAdditions-Reborn/">TreeOfSelf/CarpetSkyAdditions-Reborn</a>
 */
public record SpawnPlatformFeatureConfiguration(
        LocatableStructureFeatureConfiguration platformConfig, boolean spawnRelative) implements FeatureConfiguration {
    public static final Codec<SpawnPlatformFeatureConfiguration> CODEC =
            RecordCodecBuilder.create(instance -> instance.group(
                            LocatableStructureFeatureConfiguration.CODEC
                                    .fieldOf("platform")
                                    .forGetter(config -> config.platformConfig),
                            Codec.BOOL.fieldOf("spawn_relative").forGetter(config -> config.spawnRelative))
                    .apply(instance, SpawnPlatformFeatureConfiguration::new));
}
