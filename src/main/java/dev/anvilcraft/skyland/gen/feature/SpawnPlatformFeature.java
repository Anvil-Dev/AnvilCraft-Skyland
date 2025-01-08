package dev.anvilcraft.skyland.gen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import org.jetbrains.annotations.NotNull;

/**
 * from <a href="https://github.com/TreeOfSelf/CarpetSkyAdditions-Reborn/">TreeOfSelf/CarpetSkyAdditions-Reborn</a>
 */
public class SpawnPlatformFeature extends Feature<SpawnPlatformFeatureConfiguration> {
    public SpawnPlatformFeature(Codec<SpawnPlatformFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(@NotNull FeaturePlaceContext<SpawnPlatformFeatureConfiguration> context) {
        SpawnPlatformFeatureConfiguration config = context.config();
        // Always absolute with Y
        BlockPos origin = config.spawnRelative() ? context.origin().atY(0) : BlockPos.ZERO;

        return SkylandFeatures.LOCATABLE_STRUCTURE.place(
                config.platformConfig(), context.level(), context.chunkGenerator(), context.random(), origin);
    }
}
