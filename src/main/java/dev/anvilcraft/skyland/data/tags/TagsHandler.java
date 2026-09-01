package dev.anvilcraft.skyland.data.tags;

import dev.anvilcraft.lib.v2.registrum.providers.RegistrumTagsProvider;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

/**
 * 标签生成入口
 */
public class TagsHandler {
    public static void initItem(RegistrumTagsProvider<Item> provider) {
    }

    public static void initBlock(RegistrumTagsProvider<Block> provider) {
        BlockTagLoader.init(provider);
    }

    public static void initFluid(RegistrumTagsProvider<Fluid> provider) {
    }

    public static void initEnchantment(RegistrumTagsProvider<Enchantment> provider) {
    }

    public static void initDamageType(RegistrumTagsProvider<DamageType> provider) {
    }

    public static void initEntityType(RegistrumTagsProvider<EntityType<?>> provider) {
    }
}
