package dev.anvilcraft.skyland.data.lang;

import com.tterrag.registrate.providers.RegistrateLangProvider;
import org.jetbrains.annotations.NotNull;

public class LangHandler {
    public static void init(@NotNull RegistrateLangProvider provider) {
        // 世界生成
        provider.add("generator.skyland.skyland", "Skyland");
        // 内置数据包
        provider.add("pack.skyland.builtin_pack", "Skyland DataPack");
        provider.add("pack.skyland.skyland.description", "Normal Skyland");
        provider.add("pack.skyland.skyland_acacia.description", "Acacia Skyland");
        provider.add("pack.skyland.skyland_anvilcraft.description", "AnvilCraft Skyland");
        // RollingGate
        provider.add("rolling_gate.category.skyland", "Skyland");
        provider.add("skyland.rolling_gate.rule.generate_end_portals", "Generate End Portals");
        provider.add("skyland.rolling_gate.rule.generate_end_portals.desc", "Generate End Portals");
        provider.add("skyland.rolling_gate.rule.generate_silverfish_spawners", "Generate Silverfish Spawners");
        provider.add("skyland.rolling_gate.rule.generate_silverfish_spawners.desc", "Generate Silverfish Spawners");
        provider.add("skyland.rolling_gate.rule.generate_magma_cube_spawners", "Generate Magma Cube Spawners");
        provider.add("skyland.rolling_gate.rule.generate_magma_cube_spawners.desc", "Generate Magma Cube Spawners");
        provider.add("skyland.rolling_gate.rule.generate_ancient_city_portals", "Generate Ancient City Portals");
        provider.add("skyland.rolling_gate.rule.generate_ancient_city_portals.desc", "Generate Ancient City Portals");
        provider.add("skyland.rolling_gate.rule.generate_trial_chambers", "Generate Trial Chambers");
        provider.add("skyland.rolling_gate.rule.generate_trial_chambers.desc", "Generate Trial Chambers");
        provider.add("skyland.rolling_gate.rule.generate_random_end_gateways", "Generate Random End Gateways");
        provider.add("skyland.rolling_gate.rule.generate_random_end_gateways.desc", "Generate Random End Gateways");
        provider.add("skyland.rolling_gate.rule.shulker_spawns_on_dragon_kill", "Shulker Spawns On Dragon Kill");
        provider.add("skyland.rolling_gate.rule.shulker_spawns_on_dragon_kill.desc", "Shulker Spawns On Dragon Kill");
    }
}
