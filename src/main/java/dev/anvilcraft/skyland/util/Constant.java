package dev.anvilcraft.skyland.util;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;
import java.util.stream.Collectors;

public class Constant {
    public static final Map<Block, Block> MOSS_BLOCK_MAP = Map.of(
        Blocks.COBBLESTONE, Blocks.MOSSY_COBBLESTONE,
        Blocks.COBBLESTONE_STAIRS, Blocks.MOSSY_COBBLESTONE_STAIRS,
        Blocks.COBBLESTONE_SLAB, Blocks.MOSSY_COBBLESTONE_SLAB,
        Blocks.COBBLESTONE_WALL, Blocks.MOSSY_COBBLESTONE_WALL,
        Blocks.STONE_BRICKS, Blocks.MOSSY_STONE_BRICKS,
        Blocks.STONE_BRICK_STAIRS, Blocks.MOSSY_STONE_BRICK_STAIRS,
        Blocks.STONE_BRICK_SLAB, Blocks.MOSSY_STONE_BRICK_SLAB,
        Blocks.STONE_BRICK_WALL, Blocks.MOSSY_STONE_BRICK_WALL,
        Blocks.INFESTED_STONE_BRICKS, Blocks.INFESTED_MOSSY_STONE_BRICKS
    );

    public static final Map<Block, Block> REMOVE_MOSS = MOSS_BLOCK_MAP.entrySet()
        .stream()
        .map(it -> Map.entry(it.getValue(), it.getKey()))
        .collect(Collectors.toUnmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));
}
