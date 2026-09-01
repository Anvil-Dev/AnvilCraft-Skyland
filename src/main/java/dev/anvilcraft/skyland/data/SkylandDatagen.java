package dev.anvilcraft.skyland.data;

import dev.anvilcraft.lib.v2.registrum.providers.ProviderType;
import dev.anvilcraft.skyland.Skyland;
import dev.anvilcraft.skyland.data.lang.LangHandler;
import dev.anvilcraft.skyland.data.recipe.RecipeHandler;
import dev.anvilcraft.skyland.data.tags.TagsHandler;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.jetbrains.annotations.NotNull;

import static dev.anvilcraft.skyland.Skyland.REGISTRUM;

/**
 * Skyland 数据生成入口，结构仿照 AnvilCraft
 */
@EventBusSubscriber(modid = Skyland.MOD_ID)
public class SkylandDatagen {
    @SubscribeEvent
    public static void gatherData(@NotNull GatherDataEvent event) {
        Skyland.INTEGRATION_MANAGER.compileContent();
        Skyland.INTEGRATION_MANAGER.loadAllDataIntegrations();
    }

    /**
     * 初始化生成器
     */
    public static void init() {
        REGISTRUM.addDataGenerator(ProviderType.ITEM_TAGS, TagsHandler::initItem);
        REGISTRUM.addDataGenerator(ProviderType.BLOCK_TAGS, TagsHandler::initBlock);
        REGISTRUM.addDataGenerator(ProviderType.FLUID_TAGS, TagsHandler::initFluid);
        REGISTRUM.addDataGenerator(ProviderType.ENCHANTMENT_TAGS, TagsHandler::initEnchantment);
        REGISTRUM.addDataGenerator(ProviderType.DAMAGE_TYPE_TAGS, TagsHandler::initDamageType);
        REGISTRUM.addDataGenerator(ProviderType.ENTITY_TAGS, TagsHandler::initEntityType);
        REGISTRUM.addDataGenerator(ProviderType.LANG, LangHandler::init);
        REGISTRUM.addDataGenerator(ProviderType.RECIPE, RecipeHandler::init);
    }
}
