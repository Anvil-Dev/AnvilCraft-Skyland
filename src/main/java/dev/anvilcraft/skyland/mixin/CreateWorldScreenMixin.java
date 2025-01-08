package dev.anvilcraft.skyland.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.anvilcraft.skyland.gen.SkylandWorldPresets;
import net.minecraft.client.gui.screens.worldselection.CreateWorldScreen;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.WorldDimensions;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

/**
 * from <a href="https://github.com/TreeOfSelf/CarpetSkyAdditions-Reborn/">TreeOfSelf/CarpetSkyAdditions-Reborn</a>
 */
@Mixin(CreateWorldScreen.class)
@OnlyIn(value = Dist.CLIENT)
abstract class CreateWorldScreenMixin {

    @WrapOperation(
        method = "lambda$openFresh$1",
        at =
        @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/level/levelgen/presets/WorldPresets;createNormalWorldDimensions(Lnet/minecraft/core/RegistryAccess;)Lnet/minecraft/world/level/levelgen/WorldDimensions;"
        )
    )
    private static @NotNull WorldDimensions setDefaultWorldGenSettings(@NotNull RegistryAccess drm, Operation<WorldDimensions> original) {
        return drm.registryOrThrow(Registries.WORLD_PRESET)
            .getHolderOrThrow(SkylandWorldPresets.SKYLAND)
            .value()
            .createWorldDimensions();
    }
}
