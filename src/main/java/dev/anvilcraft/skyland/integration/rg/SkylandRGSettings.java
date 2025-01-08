package dev.anvilcraft.skyland.integration.rg;

import dev.anvilcraft.rg.api.Rule;

public class SkylandRGSettings {
    @Rule(
        categories = SkylandRGRuleCategories.SKYLAND,
        allowed = {"true", "false"}
    )
    public static boolean generateEndPortals = false;

    @Rule(
        categories = SkylandRGRuleCategories.SKYLAND,
        allowed = {"true", "false"}
    )
    public static boolean generateSilverfishSpawners = false;

    @Rule(
        categories = SkylandRGRuleCategories.SKYLAND,
        allowed = {"true", "false"}
    )
    public static boolean generateMagmaCubeSpawners = false;

    @Rule(
        categories = SkylandRGRuleCategories.SKYLAND,
        allowed = {"true", "false"}
    )
    public static boolean generateAncientCityPortals = false;

    @Rule(
        categories = SkylandRGRuleCategories.SKYLAND,
        allowed = {"true", "false"}
    )
    public static boolean generateTrialChambers = false;

    @Rule(
        categories = SkylandRGRuleCategories.SKYLAND,
        allowed = {"true", "false"}
    )
    public static boolean generateRandomEndGateways = false;

    @Rule(
        categories = SkylandRGRuleCategories.SKYLAND,
        allowed = {"true", "false"}
    )
    public static boolean shulkerSpawnsOnDragonKill = false;
}
