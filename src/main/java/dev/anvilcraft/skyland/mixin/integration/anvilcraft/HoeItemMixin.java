package dev.anvilcraft.skyland.mixin.integration.anvilcraft;

import com.llamalad7.mixinextras.sugar.Local;
import dev.anvilcraft.skyland.integration.anvilcraft.init.AnvilCraftIntegrationRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(HoeItem.class)
abstract class HoeItemMixin {
    @Inject(
        method = "useOn",
        at = @At(
            value = "INVOKE",
            target = "Ljava/util/function/Consumer;accept(Ljava/lang/Object;)V"
        )
    )
    private void useOn(
        UseOnContext context,
        CallbackInfoReturnable<InteractionResult> cir,
        @Local @NotNull Level level,
        @Local @NotNull BlockPos pos,
        @Local @NotNull BlockState toolModifiedState
    ) {
        if (!toolModifiedState.is(Blocks.FARMLAND)) return;
        RandomSource random = level.getRandom();
        if (random.nextDouble() > 0.6) return;
        Vec3 position = pos.above().getCenter().add(0.0, -0.3, 0.0);
        ItemEntity itemEntity = new ItemEntity(level, position.x, position.y, position.z, AnvilCraftIntegrationRegistries.PEBBLE.asStack());
        level.addFreshEntity(itemEntity);
    }
}
