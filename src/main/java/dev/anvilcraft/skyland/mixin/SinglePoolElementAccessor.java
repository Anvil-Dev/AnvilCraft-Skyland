package dev.anvilcraft.skyland.mixin;

import com.mojang.datafixers.util.Either;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pools.SinglePoolElement;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/**
 * from <a href="https://github.com/TreeOfSelf/CarpetSkyAdditions-Reborn/">TreeOfSelf/CarpetSkyAdditions-Reborn</a>
 */
@Mixin(SinglePoolElement.class)
public interface SinglePoolElementAccessor {
    @Accessor
    Either<ResourceLocation, StructureTemplate> getTemplate();
}
