package dev.anvilcraft.skyland.init;

import dev.anvilcraft.lib.AnvilLib;
import dev.anvilcraft.skyland.Skyland;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import org.jetbrains.annotations.NotNull;

@EventBusSubscriber(modid = Skyland.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModPacks {
    @SubscribeEvent
    public static void packSetup(@NotNull AddPackFindersEvent event) {
        if (AnvilLib.isLoaded("anvilcraft")) {
            event.addPackFinders(
                Skyland.of("resourcepacks/skyland_anvilcraft"),
                PackType.SERVER_DATA,
                Component.translatable("pack.skyland.builtin_pack"),
                PackSource.FEATURE,
                false,
                Pack.Position.TOP
            );
        }
        event.addPackFinders(
            Skyland.of("resourcepacks/skyland_acacia"),
            PackType.SERVER_DATA,
            Component.translatable("pack.skyland.builtin_pack"),
            PackSource.FEATURE,
            false,
            Pack.Position.TOP
        );
        event.addPackFinders(
            Skyland.of("resourcepacks/skyland"),
            PackType.SERVER_DATA,
            Component.translatable("pack.skyland.builtin_pack"),
            PackSource.FEATURE,
            false,
            Pack.Position.TOP
        );
    }
}
