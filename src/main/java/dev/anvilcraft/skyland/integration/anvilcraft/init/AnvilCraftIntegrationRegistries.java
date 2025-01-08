package dev.anvilcraft.skyland.integration.anvilcraft.init;

import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.entry.RegistryEntry;
import dev.anvilcraft.skyland.integration.anvilcraft.blocks.StoneAnvilBlock;
import dev.dubhe.anvilcraft.init.ModItemGroups;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import static dev.anvilcraft.skyland.Skyland.REGISTRATE;

public class AnvilCraftIntegrationRegistries {
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

    public static final TagKey<Block> ANVIL = TagKey.create(Registries.BLOCK, ResourceLocation.parse("minecraft:anvil"));

    public static final BlockEntry<StoneAnvilBlock> STONE_ANVIL = REGISTRATE
        .block("stone_anvil", StoneAnvilBlock::new)
        .tag(AnvilCraftIntegrationRegistries.ANVIL)
        .blockstate((c, p) -> {
        })
        .simpleItem()
        .register();

    public static final ItemEntry<Item> MOSS = REGISTRATE
        .item("moss", Item::new)
        .properties(properties -> properties.food(Foods.DRIED_KELP))
        .compostable(0.3f)
        .register();
    public static final ItemEntry<Item> PEBBLE = REGISTRATE
        .item("pebble", Item::new)
        .register();
    public static final ItemEntry<Item> BAMBOO_LEAVES = REGISTRATE
        .item("bamboo_leaves", Item::new)
        .compostable(0.3f)
        .register();

    public static void register() {
    }
}
