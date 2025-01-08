package dev.anvilcraft.skyland.mixin.integration.anvilcraft;

import com.llamalad7.mixinextras.sugar.Local;
import dev.anvilcraft.skyland.integration.anvilcraft.init.AnvilCraftIntegrationRegistries;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(AxeItem.class)
public class AxeItemMixin {
    @Unique
    private static final Map<Block, Block> REMOVE_MOSS = Map.of(
        Blocks.MOSSY_COBBLESTONE, Blocks.COBBLESTONE,
        Blocks.MOSSY_COBBLESTONE_SLAB, Blocks.COBBLESTONE_SLAB,
        Blocks.MOSSY_COBBLESTONE_STAIRS, Blocks.COBBLESTONE_STAIRS,
        Blocks.MOSSY_COBBLESTONE_WALL, Blocks.COBBLESTONE_WALL,
        Blocks.MOSSY_STONE_BRICKS, Blocks.STONE_BRICKS
    );

    @Inject(
        method = "useOn",
        at = @At(
            value = "RETURN",
            ordinal = 1
        ),
        cancellable = true
    )
    private void useOn(
        @NotNull UseOnContext context,
        CallbackInfoReturnable<InteractionResult> cir,
        @Local Player player,
        @Local @NotNull Level level,
        @Local @NotNull BlockPos blockpos
    ) {
        BlockState state = level.getBlockState(blockpos);
        Block to = REMOVE_MOSS.getOrDefault(state.getBlock(), null);
        if (to == null) return;
        BlockState blockState = to.defaultBlockState();
        for (@SuppressWarnings("rawtypes") Property property : state.getProperties()) {
            //noinspection unchecked
            if (!blockState.hasProperty(property)) continue;
            //noinspection unchecked
            blockState = blockState.setValue(property, state.getValue(property));
        }
        level.setBlockAndUpdate(blockpos, blockState);
        ItemStack itemstack = context.getItemInHand();
        if (player != null) {
            itemstack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(context.getHand()));
            level.playSound(player, blockpos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);
            level.levelEvent(player, 3005, blockpos, 0);
        }
        if (player instanceof ServerPlayer) CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer) player, blockpos, itemstack);
        Direction clickedFace = context.getClickedFace();
        Vec3 position = blockpos.getCenter().add(clickedFace.getStepX() * 0.7, clickedFace.getStepY() * 0.7, clickedFace.getStepZ() * 0.7);
        ItemEntity itemEntity = new ItemEntity(
            level,
            position.x, position.y, position.z,
            AnvilCraftIntegrationRegistries.MOSS.asStack(),
            clickedFace.getStepX() * 0.05, clickedFace.getStepY() * 0.05, clickedFace.getStepZ() * 0.05
        );
        level.addFreshEntity(itemEntity);
        cir.setReturnValue(InteractionResult.sidedSuccess(level.isClientSide));
    }
}
