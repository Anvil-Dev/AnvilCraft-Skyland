package dev.anvilcraft.skyland.integration.anvilcraft.init;

import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.entry.RegistryEntry;
import dev.anvilcraft.skyland.integration.anvilcraft.blocks.StoneAnvilBlock;
import dev.dubhe.anvilcraft.init.ModBlockTags;
import dev.dubhe.anvilcraft.init.ModItemGroups;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

import static dev.anvilcraft.skyland.Skyland.REGISTRATE;

@SuppressWarnings("unused")
public class AnvilCraftIntegrationRegistries {
    @SuppressWarnings("unused")
    public static final RegistryEntry<CreativeModeTab, CreativeModeTab> TAB = REGISTRATE
        .defaultCreativeTab("anvilcraft_skyland", builder -> builder.icon(AnvilCraftIntegrationRegistries.STONE_ANVIL::asStack)
            .displayItems((ctx, entries) -> {
            })
            .withTabsBefore(
                CreativeModeTabs.SPAWN_EGGS,
                ModItemGroups.ANVILCRAFT_INGREDIENTS.getKey(),
                ModItemGroups.ANVILCRAFT_FUNCTION_BLOCK.getKey(),
                ModItemGroups.ANVILCRAFT_BUILD_BLOCK.getKey(),
                ModItemGroups.ANVILCRAFT_TOOL.getKey()
            ))
        .register();

    public static final BlockEntry<StoneAnvilBlock> STONE_ANVIL = REGISTRATE
        .block("stone_anvil", StoneAnvilBlock::new)
        .tag(BlockTags.ANVIL, ModBlockTags.NON_MAGNETIC)
        .blockstate((c, p) -> {
        })
        .simpleItem()
        .register();

    public static final ItemEntry<Item> MOSS = REGISTRATE
        .item("moss", Item::new)
        .properties(properties -> properties.food(Foods.DRIED_KELP))
        .register();
    public static final ItemEntry<Item> PEBBLE = REGISTRATE
        .item("pebble", Item::new)
        .register();
    public static final ItemEntry<Item> BAMBOO_LEAVES = REGISTRATE
        .item("bamboo_leaves", Item::new)
        .register();

    public static void register() {
    }
}
