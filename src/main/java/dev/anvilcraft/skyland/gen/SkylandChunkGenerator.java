package dev.anvilcraft.skyland.gen;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.anvilcraft.skyland.SkylandSettings;
import dev.anvilcraft.skyland.mixin.ChunkGeneratorAccessor;
import dev.anvilcraft.skyland.mixin.JigsawStructureAccessor;
import dev.anvilcraft.skyland.mixin.SinglePoolElementAccessor;
import it.unimi.dsi.fastutil.ints.IntArraySet;
import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import net.minecraft.CrashReport;
import net.minecraft.ReportedException;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.core.SectionPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.FeatureSorter;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.chunk.LevelChunkSection;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.RandomSupport;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.XoroshiroRandomSource;
import net.minecraft.world.level.levelgen.blending.Blender;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.PoolElementStructurePiece;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraft.world.level.levelgen.structure.pools.SinglePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;
import net.minecraft.world.level.levelgen.structure.structures.StrongholdStructure;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.stream.Collectors;


/**
 * from <a href="https://github.com/TreeOfSelf/CarpetSkyAdditions-Reborn/">TreeOfSelf/CarpetSkyAdditions-Reborn</a>
 */
public class SkylandChunkGenerator extends NoiseBasedChunkGenerator {
    public static final MapCodec<SkylandChunkGenerator> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            BiomeSource.CODEC.fieldOf("biome_source").forGetter(SkylandChunkGenerator::getBiomeSource),
            NoiseGeneratorSettings.CODEC
                .fieldOf("settings")
                .forGetter(SkylandChunkGenerator::generatorSettings))
        .apply(instance, instance.stable(SkylandChunkGenerator::new)));


    public SkylandChunkGenerator(BiomeSource biomeSource, Holder<NoiseGeneratorSettings> settings) {
        super(biomeSource, settings);
    }

    @Override
    protected @NotNull MapCodec<? extends ChunkGenerator> codec() {
        return CODEC;
    }


    @Override
    public void buildSurface(
        @NotNull WorldGenRegion level,
        @NotNull StructureManager structureManager,
        @NotNull RandomState random,
        @NotNull ChunkAccess chunk
    ) {
    }

    @Override
    public @NotNull CompletableFuture<ChunkAccess> fillFromNoise(
        @NotNull Blender blender,
        @NotNull RandomState random,
        @NotNull StructureManager structureManager,
        @NotNull ChunkAccess chunk) {
        return CompletableFuture.completedFuture(chunk);
    }

    @Override
    public void applyCarvers(
        @NotNull WorldGenRegion level,
        long seed,
        @NotNull RandomState random,
        @NotNull BiomeManager biomeManager,
        @NotNull StructureManager structureManager,
        @NotNull ChunkAccess chunk,
        GenerationStep.@NotNull Carving step) {
    }

    @Override
    public void applyBiomeDecoration(WorldGenLevel level, ChunkAccess chunk, @NotNull StructureManager structureManager) {
        ChunkPos chunkPos = chunk.getPos();
        SectionPos sectionPos = SectionPos.of(chunkPos, level.getMinSection());
        BlockPos minChunkPos = sectionPos.origin();

        Registry<Structure> structureRegistry = level.registryAccess().registryOrThrow(Registries.STRUCTURE);
        Map<Integer, List<Structure>> structuresPerStep = structureRegistry.stream()
            .collect(Collectors.groupingBy(
                structureType -> structureType.step().ordinal()));
        List<FeatureSorter.StepFeatureData> featuresPerStep =
            ((ChunkGeneratorAccessor) this).getFeaturesPerStep().get();

        WorldgenRandom random = new WorldgenRandom(new XoroshiroRandomSource(RandomSupport.generateUniqueSeed()));
        long decorationSeed = random.setDecorationSeed(level.getSeed(), minChunkPos.getX(), minChunkPos.getZ());

        // Get all surrounding biomes for biome-based structures
        Set<Holder<Biome>> biomeSet = new ObjectArraySet<>();
        ChunkPos.rangeClosed(sectionPos.chunk(), 1).forEach(curChunkPos -> {
            ChunkAccess curChunk = level.getChunk(curChunkPos.x, curChunkPos.z);
            for (LevelChunkSection chunkSection : curChunk.getSections()) {
                chunkSection.getBiomes().getAll(biomeSet::add);
            }
        });
        biomeSet.retainAll(biomeSource.possibleBiomes());

        int numFeatures = featuresPerStep.size();
        try {
            Registry<PlacedFeature> placedFeatures = level.registryAccess().registryOrThrow(Registries.PLACED_FEATURE);
            int numSteps = Math.max(GenerationStep.Decoration.values().length, numFeatures);
            for (int genStep = 0; genStep < numSteps; ++genStep) {
                int structureInStep = 0;
                if (structureManager.shouldGenerateStructures()) {
                    List<Structure> structuresForStep =
                        structuresPerStep.getOrDefault(genStep, Collections.emptyList());
                    for (Structure structure : structuresForStep) {
                        random.setFeatureSeed(decorationSeed, structureInStep, genStep);
                        Supplier<String> structureNameSupplier = () -> structureRegistry
                            .getResourceKey(structure)
                            .map(Object::toString)
                            .orElseGet(structure::toString);
                        try {
                            // Stronghold
                            if (structure instanceof StrongholdStructure
                                && (SkylandSettings.generateEndPortals
                                || SkylandSettings.generateSilverfishSpawners)) {
                                level.setCurrentlyGenerating(structureNameSupplier);
                                structureManager
                                    .startsForStructure(sectionPos, structure)
                                    .forEach(structureStart -> {
                                        for (StructurePiece piece : structureStart.getPieces()) {
                                            if (piece.isCloseToChunk(chunkPos, 0)
                                                && piece.getType()
                                                == StructurePieceType.STRONGHOLD_PORTAL_ROOM) {
                                                BoundingBox chunkBox =
                                                    ChunkGeneratorAccessor.getWritableArea(chunk);
                                                if (SkylandSettings.generateEndPortals) {
                                                    new SkylandStructures.EndPortalStructure(piece)
                                                        .generate(level, chunkBox, random);
                                                }

                                                if (SkylandSettings.generateSilverfishSpawners) {
                                                    new SkylandStructures.SilverfishSpawnerStructure(piece)
                                                        .generate(level, chunkBox, random);
                                                }
                                            }
                                        }
                                    });
                            } else if (structure instanceof JigsawStructure) {
                                @SuppressWarnings("DataFlowIssue")
                                Holder<StructureTemplatePool> startPool = ((JigsawStructureAccessor) structure).getStartPool();
                                // Bastion Remnants
                                if (SkylandSettings.generateMagmaCubeSpawners
                                    && startPool.is(ResourceLocation.withDefaultNamespace("bastion/starts"))) {
                                    level.setCurrentlyGenerating(structureNameSupplier);
                                    structureManager
                                        .startsForStructure(sectionPos, structure)
                                        .forEach(structureStart -> {
                                            for (StructurePiece piece : structureStart.getPieces()) {
                                                if (piece.isCloseToChunk(chunkPos, 0)
                                                    && piece instanceof PoolElementStructurePiece poolPiece) {
                                                    if (poolPiece.getElement()
                                                        instanceof SinglePoolElement singlePoolElement) {
                                                        ResourceLocation pieceId = ((SinglePoolElementAccessor)
                                                            singlePoolElement)
                                                            .getTemplate()
                                                            .left()
                                                            .orElseThrow(AssertionError::new);
                                                        if (pieceId.equals(ResourceLocation.withDefaultNamespace(
                                                            "bastion/treasure/bases/lava_basin"))) {
                                                            new SkylandStructures.MagmaCubeSpawner(piece)
                                                                .generate(
                                                                    level,
                                                                    ChunkGeneratorAccessor.getWritableArea(
                                                                        chunk),
                                                                    random);
                                                        }
                                                    }
                                                }
                                            }
                                        });
                                    // Ancient Cities
                                } else if (SkylandSettings.generateAncientCityPortals
                                    && startPool.is(ResourceLocation.withDefaultNamespace("ancient_city/city_center"))) {
                                    level.setCurrentlyGenerating(structureNameSupplier);
                                    structureManager
                                        .startsForStructure(sectionPos, structure)
                                        .forEach(structureStart -> {
                                            for (StructurePiece piece : structureStart.getPieces()) {
                                                if (piece.isCloseToChunk(chunkPos, 0)
                                                    && piece instanceof PoolElementStructurePiece poolPiece) {
                                                    if (poolPiece.getElement()
                                                        instanceof SinglePoolElement singlePoolElement) {
                                                        ResourceLocation pieceId = ((SinglePoolElementAccessor)
                                                            singlePoolElement)
                                                            .getTemplate()
                                                            .left()
                                                            .orElseThrow(AssertionError::new);
                                                        if (pieceId.getNamespace()
                                                            .equals("minecraft")
                                                            && pieceId.getPath()
                                                            .startsWith(
                                                                "ancient_city/city_center/city_center")) {
                                                            new SkylandStructures.AncientCityPortalStructure(piece)
                                                                .generate(
                                                                    level,
                                                                    ChunkGeneratorAccessor.getWritableArea(
                                                                        chunk),
                                                                    random);
                                                        }
                                                    }
                                                }
                                            }
                                        });
                                }
                                //Trial Chambers
                                else if (SkylandSettings.generateTrialChambers && startPool.is(ResourceLocation.withDefaultNamespace("trial_chambers/chamber/end"))) {
                                    level.setCurrentlyGenerating(structureNameSupplier);
                                    structureManager
                                        .startsForStructure(sectionPos, structure)
                                        .forEach(structureStart -> {
                                            for (StructurePiece piece : structureStart.getPieces()) {
                                                if (piece.isCloseToChunk(chunkPos, 0)
                                                    && piece instanceof PoolElementStructurePiece poolPiece) {
                                                    if (poolPiece.getElement()
                                                        instanceof SinglePoolElement singlePoolElement) {
                                                        ResourceLocation pieceId = ((SinglePoolElementAccessor)
                                                            singlePoolElement)
                                                            .getTemplate()
                                                            .left()
                                                            .orElseThrow(AssertionError::new);
                                                        if (pieceId.getNamespace()
                                                            .equals("minecraft")
                                                            && pieceId.getPath()
                                                            .startsWith(
                                                                "trial_chambers/corridor/entrance")) {
                                                            new SkylandStructures.TrialChamberEntrance(piece)
                                                                .generate(
                                                                    level,
                                                                    ChunkGeneratorAccessor.getWritableArea(
                                                                        chunk),
                                                                    random);
                                                        } else if (pieceId.getNamespace()
                                                            .equals("minecraft")
                                                            && pieceId.getPath()
                                                            .startsWith(
                                                                "trial_chambers/corridor/atrium")) {
                                                            new SkylandStructures.TrialChamberAtrium(piece)
                                                                .generate(
                                                                    level,
                                                                    ChunkGeneratorAccessor.getWritableArea(
                                                                        chunk),
                                                                    random);
                                                        } else if (pieceId.getNamespace()
                                                            .equals("minecraft")
                                                            && pieceId.getPath()
                                                            .startsWith(
                                                                "trial_chambers")) {
                                                            new SkylandStructures.TrialChamber(piece)
                                                                .generate(
                                                                    level,
                                                                    ChunkGeneratorAccessor.getWritableArea(
                                                                        chunk),
                                                                    random);
                                                        }
                                                    }
                                                }
                                            }
                                        });
                                }

                            }
                        } catch (Exception e) {
                            CrashReport crashReport = CrashReport.forThrowable(e, "Feature placement");
                            crashReport.addCategory("Feature").setDetail("Description", structureNameSupplier::get);
                            throw new ReportedException(crashReport);
                        }
                        ++structureInStep;
                    }
                }
                if (genStep >= numFeatures) continue;
                IntArraySet intSet = new IntArraySet();
                for (Holder<Biome> biome : biomeSet) {
                    List<HolderSet<PlacedFeature>> biomeFeatureStepList = ((ChunkGeneratorAccessor) this)
                        .getGenerationSettingsGetter()
                        .apply(biome)
                        .features();
                    if (genStep < biomeFeatureStepList.size()) {
                        HolderSet<PlacedFeature> biomeFeaturesForStep = biomeFeatureStepList.get(genStep);
                        FeatureSorter.StepFeatureData indexedFeature = featuresPerStep.get(genStep);
                        biomeFeaturesForStep.stream()
                            .map(Holder::value)
                            .forEach(placedFeature ->
                                intSet.add(indexedFeature.indexMapping().applyAsInt(placedFeature)));
                    }
                }
                int n = intSet.size();
                int[] is = intSet.toIntArray();
                Arrays.sort(is);
                FeatureSorter.StepFeatureData indexedFeature = featuresPerStep.get(genStep);
                for (int o = 0; o < n; ++o) {
                    int p = is[o];
                    PlacedFeature placedFeature = indexedFeature.features().get(p);
                    Supplier<String> placedFeatureNameSupplier = () -> placedFeatures
                        .getResourceKey(placedFeature)
                        .map(Object::toString)
                        .orElseGet(placedFeature::toString);
                    random.setFeatureSeed(decorationSeed, p, genStep);
                    try {
                        // Random End Gateways
                        if (SkylandSettings.generateRandomEndGateways
                            && placedFeature.feature().is(ResourceLocation.withDefaultNamespace("end_gateway_return"))) {
                            level.setCurrentlyGenerating(placedFeatureNameSupplier);
                            placedFeature.placeWithBiomeCheck(level, this, random, minChunkPos);
                        }
                    } catch (Exception e) {
                        CrashReport crashReport = CrashReport.forThrowable(e, "Feature placement");
                        crashReport.addCategory("Feature").setDetail("Description", placedFeatureNameSupplier::get);
                        throw new ReportedException(crashReport);
                    }
                }
            }
            level.setCurrentlyGenerating(null);
        } catch (Exception e) {
            CrashReport crashReport = CrashReport.forThrowable(e, "Biome decoration");
            crashReport
                .addCategory("Generation")
                .setDetail("CenterX", chunkPos.x)
                .setDetail("CenterZ", chunkPos.z)
                .setDetail("Seed", decorationSeed);
            throw new ReportedException(crashReport);
        }
    }

    @Override
    public void spawnOriginalMobs(@NotNull WorldGenRegion level) {
    }

    public int getBaseHeightInEquivalentNoiseWorld(int x, int z, Heightmap.Types heightmap, @NotNull WorldGenLevel level) {
        RandomState randomState = RandomState.create(
            generatorSettings().value(),
            level.registryAccess().registryOrThrow(Registries.NOISE).asLookup(),
            level.getSeed());
        return super.getBaseHeight(x, z, heightmap, level, randomState);
    }
}
