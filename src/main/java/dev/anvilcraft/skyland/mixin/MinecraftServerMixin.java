package dev.anvilcraft.skyland.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import dev.anvilcraft.skyland.Skyland;
import dev.anvilcraft.skyland.gen.SkylandChunkGenerator;
import dev.anvilcraft.skyland.gen.feature.SkylandConfiguredFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerChunkCache;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.LegacyRandomSource;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.storage.ServerLevelData;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * from <a href="https://github.com/TreeOfSelf/CarpetSkyAdditions-Reborn/">TreeOfSelf/CarpetSkyAdditions-Reborn</a>
 */
@Mixin(value = MinecraftServer.class, priority = 999)
public abstract class MinecraftServerMixin {
    @Inject(
        method = "setInitialSpawn",
        at = @At(
            value = "INVOKE",
            target =
                "Lnet/minecraft/world/level/storage/ServerLevelData;setSpawn(Lnet/minecraft/core/BlockPos;F)V",
            ordinal = 1,
            shift = At.Shift.AFTER
        ),
        cancellable = true
    )
    private static void generateSpawnPlatform(
        @NotNull ServerLevel level,
        ServerLevelData levelData,
        boolean bonusChest,
        boolean debugWorld,
        CallbackInfo ci,
        @Local ChunkPos spawnChunk,
        @Local int spawnHeight
    ) {
        ServerChunkCache chunkManager = level.getChunkSource();
        ChunkGenerator chunkGenerator = chunkManager.getGenerator();
        if (!(chunkGenerator instanceof SkylandChunkGenerator)) return;
        BlockPos worldSpawn = spawnChunk.getMiddleBlockPosition(spawnHeight);

        WorldgenRandom random = new WorldgenRandom(new LegacyRandomSource(0));
        random.setLargeFeatureSeed(level.getSeed(), spawnChunk.x, spawnChunk.z);

        Holder.Reference<ConfiguredFeature<?, ?>> spawnPlatformFeature = level.registryAccess()
            .registryOrThrow(Registries.CONFIGURED_FEATURE)
            .getHolderOrThrow(SkylandConfiguredFeatures.SPAWN_PLATFORM);

        if (!spawnPlatformFeature.value().place(level, chunkGenerator, random, worldSpawn)) {
            Skyland.LOGGER.error("Couldn't generate spawn platform");
        }

        ci.cancel();
    }
}
