package dev.anvilcraft.skyland.data.recipe;

import dev.anvilcraft.lib.v2.registrum.providers.RegistrumRecipeProvider;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

/**
 * 配方生成辅助
 */
public class SkylandRecipeProvider {
    public static Criterion<InventoryChangeTrigger.TriggerInstance> has(ItemLike itemLike) {
        return RegistrumRecipeProvider.has(itemLike);
    }

    public static Criterion<InventoryChangeTrigger.TriggerInstance> has(TagKey<Item> tag) {
        return RegistrumRecipeProvider.has(tag);
    }

    public static String hasItem(TagKey<Item> item) {
        return "has_" + item.location().getPath();
    }

    public static String hasItem(ItemLike item) {
        return "has_" + BuiltInRegistries.ITEM.getKey(item.asItem()).getPath();
    }
}
