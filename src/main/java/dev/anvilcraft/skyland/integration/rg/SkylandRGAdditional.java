package dev.anvilcraft.skyland.integration.rg;

import dev.anvilcraft.rg.api.RGAdditional;
import dev.anvilcraft.rg.api.server.ServerRGRuleManager;
import org.jetbrains.annotations.NotNull;

public class SkylandRGAdditional implements RGAdditional {
    @Override
    public void loadServerRules(@NotNull ServerRGRuleManager manager) {
        manager.register(SkylandRGSettings.class);
    }
}
