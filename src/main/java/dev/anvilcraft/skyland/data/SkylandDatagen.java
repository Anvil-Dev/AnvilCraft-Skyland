package dev.anvilcraft.skyland.data;

import com.tterrag.registrate.providers.ProviderType;
import dev.anvilcraft.skyland.Skyland;
import dev.anvilcraft.skyland.data.lang.LangHandler;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.jetbrains.annotations.NotNull;

import static dev.anvilcraft.skyland.Skyland.REGISTRATE;


@EventBusSubscriber(modid = Skyland.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class SkylandDatagen {
    @SubscribeEvent
    public static void gatherData(@NotNull GatherDataEvent event) {
    }

    public static void init() {
        REGISTRATE.addDataGenerator(ProviderType.LANG, LangHandler::init);
    }
}
