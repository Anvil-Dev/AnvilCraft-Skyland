package dev.anvilcraft.skyland.gen.feature;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

/**
 * from <a href="https://github.com/TreeOfSelf/CarpetSkyAdditions-Reborn/">TreeOfSelf/CarpetSkyAdditions-Reborn</a>
 */
public abstract class SkylandFeatures {
    public static final Feature<LocatableStructureFeatureConfiguration> LOCATABLE_STRUCTURE =
        new LocatableStructureFeature(LocatableStructureFeatureConfiguration.CODEC);
    public static final Feature<SpawnPlatformFeatureConfiguration> SPAWN_PLATFORM =
        new SpawnPlatformFeature(SpawnPlatformFeatureConfiguration.CODEC);
    public static final Feature<NoneFeatureConfiguration> GATEWAY_ISLAND =
        new EndGatewayIslandFeature(NoneFeatureConfiguration.CODEC);
}
