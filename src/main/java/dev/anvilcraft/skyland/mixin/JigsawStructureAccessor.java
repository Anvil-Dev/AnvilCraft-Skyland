package dev.anvilcraft.skyland.mixin;

import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/**
 * from <a href="https://github.com/TreeOfSelf/CarpetSkyAdditions-Reborn/">TreeOfSelf/CarpetSkyAdditions-Reborn</a>
 */
@Mixin(JigsawStructure.class)
public interface JigsawStructureAccessor {
    @Accessor
    Holder<StructureTemplatePool> getStartPool();
}
