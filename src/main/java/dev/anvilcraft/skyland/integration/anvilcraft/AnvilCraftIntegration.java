package dev.anvilcraft.skyland.integration.anvilcraft;

import dev.anvilcraft.lib.v2.integration.Integration;
import dev.anvilcraft.skyland.integration.anvilcraft.event.AnvilEventListener;
import dev.anvilcraft.skyland.integration.anvilcraft.init.AnvilCraftIntegrationRegistries;
import net.neoforged.neoforge.common.NeoForge;

@Integration("anvilcraft")
public class AnvilCraftIntegration {
    public void apply() {
        NeoForge.EVENT_BUS.register(new AnvilEventListener());
        AnvilCraftIntegrationRegistries.register();
    }
}
