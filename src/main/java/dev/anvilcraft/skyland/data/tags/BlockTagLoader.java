package dev.anvilcraft.skyland.data.tags;

import dev.anvilcraft.lib.v2.registrum.providers.RegistrumTagsProvider;
import net.minecraft.world.level.block.Block;

/**
 * 方块标签生成
 */
public class BlockTagLoader {
    public static void init(RegistrumTagsProvider<Block> provider) {
        // 方块自身属性标签已在注册时通过 builder.tag() 声明
    }
}
