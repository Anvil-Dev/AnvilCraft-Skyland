package dev.anvilcraft.skyland.gen.feature;

import com.mojang.serialization.Codec;
import dev.anvilcraft.skyland.Skyland;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import org.jetbrains.annotations.NotNull;

/**
 * from <a href="https://github.com/TreeOfSelf/CarpetSkyAdditions-Reborn/">TreeOfSelf/CarpetSkyAdditions-Reborn</a>
 */
public class LocatableStructureFeature extends Feature<LocatableStructureFeatureConfiguration> {
    public LocatableStructureFeature(Codec<LocatableStructureFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(@NotNull FeaturePlaceContext<LocatableStructureFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        MinecraftServer server = level.getServer();
        if (server == null) {
            return false;
        }
        LocatableStructureFeatureConfiguration config = context.config();
        StructureTemplate structure =
            server.getStructureManager().get(config.structure()).orElse(null);
        if (structure == null) {
            Skyland.LOGGER.warn("Missing structure {}", config.structure());
            return false;
        }

        return structure.placeInWorld(
            level,
            context.origin().offset(config.pos()),
            null,
            new StructurePlaceSettings(),
            context.random(),
            Block.UPDATE_CLIENTS);
    }
}
