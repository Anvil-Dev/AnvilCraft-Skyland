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
        provider.add("skyland.rolling_gate.rule.tall_flowers_from_wandering_trader", "Tall Flowers From Wandering Trader");
        provider.add("skyland.rolling_gate.rule.tall_flowers_from_wandering_trader.desc", "Tall Flowers From Wandering Trader");
        provider.add("skyland.rolling_gate.rule.lava_from_wandering_trader", "Lava From Wandering Trader");
        provider.add("skyland.rolling_gate.rule.lava_from_wandering_trader.desc", "Lava From Wandering Trader");
        provider.add("skyland.rolling_gate.rule.lightning_electrifies_vines", "Lightning Electrifies Vines");
        provider.add("skyland.rolling_gate.rule.lightning_electrifies_vines.desc", "The Lightning can also strike a Lightning Rod on the Glowstone.");
        provider.add("skyland.rolling_gate.rule.renewable_amethysts", "Renewable Amethysts");
        provider.add("skyland.rolling_gate.rule.renewable_amethysts.desc", "Renewable Amethysts");
        provider.add("skyland.rolling_gate.rule.gateways_spawn_chorus", "Gateways Spawn Chorus");
        provider.add("skyland.rolling_gate.rule.gateways_spawn_chorus.desc", "Gateways Spawn Chorus");
        provider.add("skyland.rolling_gate.rule.renewable_hearts_of_the_sea", "Renewable Hearts Of The Sea");
        provider.add("skyland.rolling_gate.rule.renewable_hearts_of_the_sea.desc", "Renewable Hearts Of The Sea");
        provider.add("skyland.rolling_gate.rule.renewable_dragon_heads", "Renewable Dragon Heads");
        provider.add("skyland.rolling_gate.rule.renewable_dragon_heads.desc", "Renewable Dragon Heads");
        provider.add("skyland.rolling_gate.rule.renewable_diamonds", "Renewable Diamonds");
        provider.add("skyland.rolling_gate.rule.renewable_diamonds.desc", "Renewable Diamonds");
        provider.add("skyland.rolling_gate.rule.ramming_wastes", "Ramming Wastes");
        provider.add("skyland.rolling_gate.rule.ramming_wastes.desc", "Ramming Wastes");
        provider.add("skyland.rolling_gate.rule.foxes_spawn_with_sweet_berries_chance", "Foxes Spawn With Sweet Berries Chance");
        provider.add("skyland.rolling_gate.rule.foxes_spawn_with_sweet_berries_chance.desc", "Foxes Spawn With Sweet Berries Chance");
        provider.add("skyland.rolling_gate.rule.poisonous_potatoes_convert_spiders", "Poisonous Potatoes Convert Spiders");
        provider.add("skyland.rolling_gate.rule.poisonous_potatoes_convert_spiders.desc", "Poisonous Potatoes Convert Spiders");
        provider.add("skyland.rolling_gate.rule.saplings_die_on_sand", "Saplings Die On Sand");
        provider.add("skyland.rolling_gate.rule.saplings_die_on_sand.desc", "Saplings Die On Sand");
        provider.add("skyland.rolling_gate.rule.renewable_echo_shards", "Renewable Echo Shards");
        provider.add("skyland.rolling_gate.rule.renewable_echo_shards.desc", "Renewable Echo Shards");
        provider.add("skyland.rolling_gate.rule.allayable_vexes", "Allayable Vexes");
        provider.add("skyland.rolling_gate.rule.allayable_vexes.desc", "Allayable Vexes");
        provider.add("skyland.rolling_gate.rule.coral_erosion", "Coral Erosion");
        provider.add("skyland.rolling_gate.rule.coral_erosion.desc", "Coral Erosion");
        provider.add("skyland.rolling_gate.rule.huge_mushrooms_spread_mycelium", "Huge Mushrooms Spread Mycelium");
        provider.add("skyland.rolling_gate.rule.huge_mushrooms_spread_mycelium.desc", "Huge Mushrooms Spread Mycelium");
        provider.add("skyland.rolling_gate.rule.renewable_netherrack", "Renewable Netherrack");
        provider.add("skyland.rolling_gate.rule.renewable_netherrack.desc", "What generates depends on the biome, with Nyliums generating in their respective forests and Netherrack elsewhere");
        provider.add("skyland.rolling_gate.rule.renewable_deepslate", "Renewable Deepslate");
        provider.add("skyland.rolling_gate.rule.renewable_deepslate.desc", "With no_splash: splash potion conversion is disabled.");
        provider.add("skyland.rolling_gate.rule.renewable_swift_sneak", "Renewable Swift Sneak");
        provider.add("skyland.rolling_gate.rule.renewable_swift_sneak.desc", "Renewable Swift Sneak");
        provider.add("skyland.rolling_gate.rule.sniffers_from_drowneds", "Sniffers From Drowneds");
        provider.add("skyland.rolling_gate.rule.sniffers_from_drowneds.desc", "When they stomp Turtle Eggs, they replace them with the Sniffer Egg.");
        provider.add("skyland.rolling_gate.rule.suspicious_sniffers", "Suspicious Sniffers");
        provider.add("skyland.rolling_gate.rule.suspicious_sniffers.desc", "When Sniffers dig Sand or Gravel in a structure where Suspicious Sand or Gravel generates, it will be converted.With no_iron: No Iron Nugget is dropped when Sniffers dig");
        provider.add("skyland.rolling_gate.rule.spreading_small_dripleaves", "Spreading Small Dripleaves");
        provider.add("skyland.rolling_gate.rule.spreading_small_dripleaves.desc", "Requires them to be on Clay, half-submerged, with the top at light level 5");
        provider.add("skyland.rolling_gate.rule.spreading_coral", "Spreading Coral");
        provider.add("skyland.rolling_gate.rule.spreading_coral.desc", "Rate varies depending on location");
        provider.add("skyland.rolling_gate.rule.max_wandering_trader_spawn_chance", "Max Wandering Trader Spawn Chance");
        provider.add("skyland.rolling_gate.rule.max_wandering_trader_spawn_chance.desc", "This starts at 0.025 and increases by 0.025 each time a trader spawn fails until the max chance is reached.");
    }
}
