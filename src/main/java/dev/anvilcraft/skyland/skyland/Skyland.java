package dev.anvilcraft.skyland.skyland;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(Skyland.MODID)
public class Skyland {
    public static final String MODID = "skyland";
    @SuppressWarnings("unused")
    private static final Logger LOGGER = LogUtils.getLogger();

    public Skyland(@SuppressWarnings("unused") IEventBus modEventBus, @SuppressWarnings("unused") ModContainer modContainer) {
    }
}
