package dev.anvilcraft.skyland.integration.anvilcraft.event;

import dev.anvilcraft.skyland.integration.anvilcraft.init.AnvilCraftIntegrationRegistries;
import dev.dubhe.anvilcraft.api.event.anvil.AnvilFallOnLandEvent;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.neoforged.bus.api.SubscribeEvent;
import org.jetbrains.annotations.NotNull;

public class AnvilEventListener {
    @SubscribeEvent
    public void onAnvilFallOnLand(@NotNull AnvilFallOnLandEvent event) {
        FallingBlockEntity entity = event.getEntity();
        if (!entity.getBlockState().is(AnvilCraftIntegrationRegistries.STONE_ANVIL)) return;
        //noinspection resource
        event.setAnvilDamage(entity.level().getRandom().nextDouble() < 0.6);
    }
}
