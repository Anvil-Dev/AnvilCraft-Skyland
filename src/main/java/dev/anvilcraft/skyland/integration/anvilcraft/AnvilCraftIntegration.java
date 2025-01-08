package dev.anvilcraft.skyland.integration.anvilcraft;

import dev.anvilcraft.lib.integration.Integration;
import dev.anvilcraft.skyland.integration.anvilcraft.init.AnvilCraftIntegrationRegistries;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;

import java.util.Optional;

public class AnvilCraftIntegration implements Integration {
    @Override
    public void apply() {
        Optional<? extends ModContainer> skyland = ModList.get().getModContainerById("skyland");
        if (skyland.isEmpty()) return;
        AnvilCraftIntegrationRegistries.register();
    }
}
