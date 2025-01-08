package dev.anvilcraft.skyland.mixin;

import dev.anvilcraft.skyland.gen.SkylandChunkGenerator;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.WorldGenerationContext;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * from <a href="https://github.com/TreeOfSelf/CarpetSkyAdditions-Reborn/">TreeOfSelf/CarpetSkyAdditions-Reborn</a>
 */
@Mixin(PlacementContext.class)
abstract class PlacementContextMixin extends WorldGenerationContext {
    @Shadow
    @Final
    private ChunkGenerator generator;

    @Shadow
    @Final
    private WorldGenLevel level;

    public PlacementContextMixin(ChunkGenerator generator, LevelHeightAccessor levelHeightAccessor) {
        super(generator, levelHeightAccessor);
    }

    @Inject(method = "getHeight", cancellable = true, at = @At(value = "HEAD"))
    private void useGenerationHeightmap(Heightmap.Types heightmap, int x, int z, CallbackInfoReturnable<Integer> cir) {
        if (!(generator instanceof SkylandChunkGenerator chunkGenerator)) return;
        cir.setReturnValue(chunkGenerator.getBaseHeightInEquivalentNoiseWorld(x, z, heightmap, level));
        cir.cancel();
    }
}
