package dev.anvilcraft.skyland.init;

import dev.anvilcraft.skyland.Skyland;
import dev.anvilcraft.skyland.gen.SkylandChunkGenerator;
import dev.anvilcraft.skyland.gen.feature.SkylandFeatures;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.RegisterEvent;
import org.jetbrains.annotations.NotNull;

@EventBusSubscriber(modid = Skyland.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModRegisters {
    @SubscribeEvent
    public static void register(@NotNull RegisterEvent event) {
        event.register(
            Registries.CHUNK_GENERATOR,
            Skyland.of("skyland"),
            () -> SkylandChunkGenerator.CODEC
        );
        event.register(
            Registries.FEATURE,
            Skyland.of("locatable_structure"),
            () -> SkylandFeatures.LOCATABLE_STRUCTURE
        );
        event.register(
            Registries.FEATURE,
            Skyland.of("spawn_platform"),
            () -> SkylandFeatures.SPAWN_PLATFORM
        );
        event.register(
            Registries.FEATURE,
            Skyland.of("end_gateway_island"),
            () -> SkylandFeatures.GATEWAY_ISLAND
        );
    }
}
