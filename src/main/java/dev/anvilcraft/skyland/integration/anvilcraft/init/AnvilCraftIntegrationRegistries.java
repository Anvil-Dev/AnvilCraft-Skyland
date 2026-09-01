package dev.anvilcraft.skyland.integration.anvilcraft.init;

import dev.anvilcraft.lib.v2.registrum.util.entry.BlockEntry;
import dev.anvilcraft.lib.v2.registrum.util.entry.ItemEntry;
import dev.anvilcraft.lib.v2.registrum.util.entry.RegistryEntry;
import dev.anvilcraft.skyland.integration.anvilcraft.blocks.StoneAnvilBlock;
import dev.dubhe.anvilcraft.init.block.ModBlockTags;
import dev.dubhe.anvilcraft.init.item.ModItemGroups;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

import static dev.anvilcraft.skyland.Skyland.REGISTRUM;

@SuppressWarnings("unused")
public class AnvilCraftIntegrationRegistries {
    @SuppressWarnings("unused")
    public static final RegistryEntry<CreativeModeTab, CreativeModeTab> TAB = REGISTRUM
        .defaultCreativeTab("anvilcraft_skyland", builder -> builder.icon(AnvilCraftIntegrationRegistries.STONE_ANVIL::asStack)
            .displayItems((ctx, entries) -> {
            })
            .withTabsBefore(
                CreativeModeTabs.SPAWN_EGGS,
                ModItemGroups.ANVILCRAFT_ITEMS.getKey()
            ))
        .register();

    public static final BlockEntry<StoneAnvilBlock> STONE_ANVIL = REGISTRUM
        .block("stone_anvil", StoneAnvilBlock::new)
        .tag(BlockTags.ANVIL, ModBlockTags.NON_MAGNETIC)
        .blockstate((c, p) -> {
        })
        .simpleItem()
        .register();

    public static final ItemEntry<Item> MOSS = REGISTRUM
        .item("moss", Item::new)
        .properties(properties -> properties.food(Foods.DRIED_KELP))
        .register();
    public static final ItemEntry<Item> PEBBLE = REGISTRUM
        .item("pebble", Item::new)
        .register();
    public static final ItemEntry<Item> BAMBOO_LEAVES = REGISTRUM
        .item("bamboo_leaves", Item::new)
        .register();

    public static void register() {
    }
}
