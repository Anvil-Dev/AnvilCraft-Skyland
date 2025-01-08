package dev.anvilcraft.skyland.integration.rg.event;

import dev.anvilcraft.rg.api.event.RGRuleChangeEvent.Server;
import dev.anvilcraft.skyland.SkylandSettings;
import net.neoforged.bus.api.SubscribeEvent;
import org.jetbrains.annotations.NotNull;

public class RollingGateEventListener {
    @SubscribeEvent
    public void onRuleChange(@NotNull Server<Boolean> event) {
        String name = event.getRule().name();
        switch (name) {
            case "generateEndPortals" -> SkylandSettings.generateEndPortals = event.getNewValue();
            case "generateSilverfishSpawners" -> SkylandSettings.generateSilverfishSpawners = event.getNewValue();
            case "generateMagmaCubeSpawners" -> SkylandSettings.generateMagmaCubeSpawners = event.getNewValue();
            case "generateAncientCityPortals" -> SkylandSettings.generateAncientCityPortals = event.getNewValue();
            case "generateTrialChambers" -> SkylandSettings.generateTrialChambers = event.getNewValue();
            case "generateRandomEndGateways" -> SkylandSettings.generateRandomEndGateways = event.getNewValue();
            case "shulkerSpawnsOnDragonKill" -> SkylandSettings.shulkerSpawnsOnDragonKill = event.getNewValue();
        }
    }
}
