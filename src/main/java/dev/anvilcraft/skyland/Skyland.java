package dev.anvilcraft.skyland;

import com.mojang.logging.LogUtils;
import dev.anvilcraft.lib.v2.integration.IntegrationManager;
import dev.anvilcraft.lib.v2.registrum.Registrum;
import dev.anvilcraft.skyland.data.SkylandDatagen;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

@Mod(Skyland.MOD_ID)
public class Skyland {
    public static final String MOD_ID = "skyland";
    @SuppressWarnings("unused")
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final Registrum REGISTRUM = Registrum.create(MOD_ID).defaultCreativeTab((ResourceKey<CreativeModeTab>) null);
    public static final IntegrationManager INTEGRATION_MANAGER = new IntegrationManager(MOD_ID);

    public Skyland(@SuppressWarnings("unused") IEventBus modEventBus, @SuppressWarnings("unused") ModContainer modContainer) {
        SkylandDatagen.init();
        INTEGRATION_MANAGER.compileContent();
        INTEGRATION_MANAGER.loadAllIntegrations();
    }

    public static @NotNull ResourceLocation of(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}
