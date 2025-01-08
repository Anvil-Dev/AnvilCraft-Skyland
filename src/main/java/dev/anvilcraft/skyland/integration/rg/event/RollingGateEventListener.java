package dev.anvilcraft.skyland.integration.rg.event;

import dev.anvilcraft.rg.api.event.RGRuleChangeEvent.Server;
import dev.anvilcraft.skyland.SkylandSettings;
import net.neoforged.bus.api.SubscribeEvent;
import org.jetbrains.annotations.NotNull;

public class RollingGateEventListener {
    @SubscribeEvent
    public void onRuleChangeBoolean(@NotNull Server<Boolean> event) {
        String name = event.getRule().name();
        switch (name) {
            case "generateEndPortals" -> SkylandSettings.generateEndPortals = event.getNewValue();
            case "generateSilverfishSpawners" -> SkylandSettings.generateSilverfishSpawners = event.getNewValue();
            case "generateMagmaCubeSpawners" -> SkylandSettings.generateMagmaCubeSpawners = event.getNewValue();
            case "generateAncientCityPortals" -> SkylandSettings.generateAncientCityPortals = event.getNewValue();
            case "generateTrialChambers" -> SkylandSettings.generateTrialChambers = event.getNewValue();
            case "generateRandomEndGateways" -> SkylandSettings.generateRandomEndGateways = event.getNewValue();
            case "shulkerSpawnsOnDragonKill" -> SkylandSettings.shulkerSpawnsOnDragonKill = event.getNewValue();
            case "tallFlowersFromWanderingTrader" -> SkylandSettings.tallFlowersFromWanderingTrader = event.getNewValue();
            case "lavaFromWanderingTrader" -> SkylandSettings.lavaFromWanderingTrader = event.getNewValue();
            case "lightningElectrifiesVines" -> SkylandSettings.lightningElectrifiesVines = event.getNewValue();
            case "renewableBuddingAmethysts" -> SkylandSettings.renewableBuddingAmethysts = event.getNewValue();
            case "gatewaysSpawnChorus" -> SkylandSettings.gatewaysSpawnChorus = event.getNewValue();
            case "renewableHeartsOfTheSea" -> SkylandSettings.renewableHeartsOfTheSea = event.getNewValue();
            case "renewableDragonHeads" -> SkylandSettings.renewableDragonHeads = event.getNewValue();
            case "renewableDiamonds" -> SkylandSettings.renewableDiamonds = event.getNewValue();
            case "rammingWart" -> SkylandSettings.rammingWart = event.getNewValue();
            case "poisonousPotatoesConvertSpiders" -> SkylandSettings.poisonousPotatoesConvertSpiders = event.getNewValue();
            case "saplingsDieOnSand" -> SkylandSettings.saplingsDieOnSand = event.getNewValue();
            case "renewableEchoShards" -> SkylandSettings.renewableEchoShards = event.getNewValue();
            case "allayableVexes" -> SkylandSettings.allayableVexes = event.getNewValue();
            case "coralErosion" -> SkylandSettings.coralErosion = event.getNewValue();
            case "hugeMushroomsSpreadMycelium" -> SkylandSettings.hugeMushroomsSpreadMycelium = event.getNewValue();
            case "renewableNetherrack" -> SkylandSettings.renewableNetherrack = event.getNewValue();
            case "renewableSwiftSneak" -> SkylandSettings.renewableSwiftSneak = event.getNewValue();
            case "sniffersFromDrowneds" -> SkylandSettings.sniffersFromDrowneds = event.getNewValue();
            case "spreadingSmallDripleaves" -> SkylandSettings.spreadingSmallDripleaves = event.getNewValue();
            case "spreadingCoral" -> SkylandSettings.spreadingCoral = event.getNewValue();
        }
    }

    @SubscribeEvent
    public void onRuleChangeFloat(@NotNull Server<Float> event) {
        String name = event.getRule().name();
        switch (name) {
            case "foxesSpawnWithSweetBerriesChance" -> SkylandSettings.foxesSpawnWithSweetBerriesChance = event.getNewValue();
            case "maxWanderingTraderSpawnChance" -> SkylandSettings.maxWanderingTraderSpawnChance = event.getNewValue();
        }
    }

    @SubscribeEvent
    public void onRuleChangeString(@NotNull Server<String> event) {
        String name = event.getRule().name();
        switch (name) {
            case "renewableDeepslate" -> SkylandSettings.renewableDeepslate = event.getNewValue();
            case "suspiciousSniffers" -> SkylandSettings.suspiciousSniffers = event.getNewValue();
        }
    }
}
