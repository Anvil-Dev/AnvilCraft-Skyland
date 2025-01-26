package dev.anvilcraft.skyland.mixin.integration.anvilcraft;

import dev.anvilcraft.skyland.util.Constant;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockBehaviour.class)
abstract class BlockBehaviourMixin {
    @Unique
    private boolean skyland$isMossy(@NotNull BlockState state) {
        return Constant.MOSS_BLOCK_MAP.containsKey(state.getBlock());
    }

    @Inject(method = "isRandomlyTicking", at = @At("HEAD"), cancellable = true)
    private void isRandomlyTicking(
        BlockState state,
        CallbackInfoReturnable<Boolean> cir
    ) {
        if (skyland$isMossy(state)) cir.setReturnValue(true);
    }

    @Inject(method = "randomTick", at = @At("HEAD"))
    private void randomTick(
        @NotNull BlockState state,
        @NotNull ServerLevel level,
        @NotNull BlockPos pos,
        @NotNull RandomSource random,
        @NotNull CallbackInfo ci
    ) {
        if (!skyland$isMossy(state)) return;
        if (random.nextInt(20) != 0) return; // 5% chance
        BlockPos above = pos.above();
        if (!level.getBlockState(above).isAir()) return; // no block above
        if (level.getBrightness(LightLayer.SKY, above) > 5) return; // no sky above
        if (level.getBrightness(LightLayer.BLOCK, above) > 7) return; // no light above
        Biome biome = level.getBiome(pos).value();
        if (!biome.hasPrecipitation()) return; // can rain
        if (!biome.warmEnoughToRain(pos)) return; // can rain
        BlockState blockState = Constant.MOSS_BLOCK_MAP.get(state.getBlock()).defaultBlockState();
        for (@SuppressWarnings("rawtypes") Property property : state.getProperties()) {
            //noinspection unchecked
            if (!blockState.hasProperty(property)) continue;
            //noinspection unchecked
            blockState = blockState.setValue(property, state.getValue(property));
        }
        level.setBlockAndUpdate(pos, blockState);
    }
}
