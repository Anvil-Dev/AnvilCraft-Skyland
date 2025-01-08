package dev.anvilcraft.skyland.mixin;

import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.FeatureSorter;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * from <a href="https://github.com/TreeOfSelf/CarpetSkyAdditions-Reborn/">TreeOfSelf/CarpetSkyAdditions-Reborn</a>
 */
@Mixin(ChunkGenerator.class)
public interface ChunkGeneratorAccessor {
    @Accessor
    Supplier<List<FeatureSorter.StepFeatureData>> getFeaturesPerStep();

    @Accessor
    Function<Holder<Biome>, BiomeGenerationSettings> getGenerationSettingsGetter();

    @Invoker("getWritableArea")
    static BoundingBox getWritableArea(ChunkAccess chunk) {
        throw new AssertionError();
    }
}
