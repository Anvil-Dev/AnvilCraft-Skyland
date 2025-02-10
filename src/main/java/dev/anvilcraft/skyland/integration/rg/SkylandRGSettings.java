package dev.anvilcraft.skyland.integration.rg;

import dev.anvilcraft.rg.api.RGValidator;
import dev.anvilcraft.rg.api.Rule;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class SkylandRGSettings {
    // 生成末地传送门
    @Rule(
        categories = SkylandRGRuleCategories.SKYLAND,
        allowed = {"true", "false"}
    )
    public static boolean generateEndPortals = true;

    // 生成蠹虫刷怪笼
    @Rule(
        categories = SkylandRGRuleCategories.SKYLAND,
        allowed = {"true", "false"}
    )
    public static boolean generateSilverfishSpawners = true;

    // 生成岩浆怪刷怪笼
    @Rule(
        categories = SkylandRGRuleCategories.SKYLAND,
        allowed = {"true", "false"}
    )
    public static boolean generateMagmaCubeSpawners = false;

    // 生成古城门框
    @Rule(
        categories = SkylandRGRuleCategories.SKYLAND,
        allowed = {"true", "false"}
    )
    public static boolean generateAncientCityPortals = false;

    // 生成试炼房间
    @Rule(
        categories = SkylandRGRuleCategories.SKYLAND,
        allowed = {"true", "false"}
    )
    public static boolean generateTrialChambers = false;

    // 生成随机折跃门
    @Rule(
        categories = SkylandRGRuleCategories.SKYLAND,
        allowed = {"true", "false"}
    )
    public static boolean generateRandomEndGateways = false;

    // 击杀末影龙后生成潜影贝
    @Rule(
        categories = SkylandRGRuleCategories.SKYLAND,
        allowed = {"true", "false"}
    )
    public static boolean shulkerSpawnsOnDragonKill = false;

    // 允许流浪商人售卖大型花
    @Rule(
        categories = SkylandRGRuleCategories.SKYLAND,
        allowed = {"true", "false"}
    )
    public static boolean tallFlowersFromWanderingTrader = false;

    // 允许流浪商人售卖熔岩桶
    @Rule(
        categories = SkylandRGRuleCategories.SKYLAND,
        allowed = {"true", "false"}
    )
    public static boolean lavaFromWanderingTrader = false;

    // 允许闪电击中荧石时将附着于其上的藤蔓转化为发光地衣
    @Rule(
        categories = SkylandRGRuleCategories.SKYLAND,
        allowed = {"true", "false"}
    )
    public static boolean lightningElectrifiesVines = false;

    // 允许被方解石和平滑玄武岩包围的熔岩转化为紫水晶母岩
    @Rule(
        categories = SkylandRGRuleCategories.SKYLAND,
        allowed = {"true", "false"}
    )
    public static boolean renewableBuddingAmethysts = false;

    // 允许被末地折跃门生成的末地小岛上生成紫颂植株
    @Rule(
        categories = SkylandRGRuleCategories.SKYLAND,
        allowed = {"true", "false"}
    )
    public static boolean gatewaysSpawnChorus = false;

    // 允许海豚在被给予鱼时挖掘海洋之心
    @Rule(
        categories = SkylandRGRuleCategories.SKYLAND,
        allowed = {"true", "false"}
    )
    public static boolean renewableHeartsOfTheSea = false;

    // 允许被闪电苦力怕杀死的末影龙掉落龙首
    @Rule(
        categories = SkylandRGRuleCategories.SKYLAND,
        allowed = {"true", "false"}
    )
    public static boolean renewableDragonHeads = false;

    // 允许下落的铁砧将一组煤炭块压成一个钻石
    @Rule(
        categories = SkylandRGRuleCategories.SKYLAND,
        allowed = {"true", "false"}
    )
    public static boolean renewableDiamonds = false;

    // 允许山羊在冲撞时破坏下界疣块掉落下界疣
    @Rule(
        categories = SkylandRGRuleCategories.SKYLAND,
        allowed = {"true", "false"}
    )
    public static boolean rammingWart = false;

    public static class FoxesSpawnWithSweetBerriesChanceValidator extends RGValidator.FloatValidator {
        @Override
        public Map.@NotNull Entry<Float, Float> getRange() {
            return Map.entry(0.0f, 1.0f);
        }
    }

    // 狐狸带着甜浆果生成的概率
    @Rule(
        categories = SkylandRGRuleCategories.SKYLAND,
        allowed = {"0.0", "0.025", "0.075", "0.25", "0.75", "1.0"},
        validator = FoxesSpawnWithSweetBerriesChanceValidator.class
    )
    public static float foxesSpawnWithSweetBerriesChance = 0.0f;

    // 当玩家手持毒马铃薯右键点击蜘蛛时允许将其转化为洞穴蜘蛛
    @Rule(
        categories = SkylandRGRuleCategories.SKYLAND,
        allowed = {"true", "false"}
    )
    public static boolean poisonousPotatoesConvertSpiders = false;

    // 允许树苗种在沙子上，树苗种在沙子上时会很快枯死成枯萎的灌木
    @Rule(
        categories = SkylandRGRuleCategories.SKYLAND,
        allowed = {"true", "false"}
    )
    public static boolean saplingsDieOnSand = false;

    // 允许具有回声定位功能的生物（蝙蝠和海豚）被监守者的音波杀死时掉落回响碎片
    @Rule(
        categories = SkylandRGRuleCategories.SKYLAND,
        allowed = {"true", "false"}
    )
    public static boolean renewableEchoShards = false;

    // 允许恼鬼在音符盒按照正确顺序奏响后转化为悦灵
    @Rule(
        categories = SkylandRGRuleCategories.SKYLAND,
        allowed = {"true", "false"}
    )
    public static boolean allayableVexes = false;

    // 允许失活的珊瑚、珊瑚扇而非珊瑚块为含水方块且附近有流动的水时产生沙子
    @Rule(
        categories = SkylandRGRuleCategories.SKYLAND,
        allowed = {"true", "false"}
    )
    public static boolean coralErosion = false;

    // 允许大型蘑菇像大型云杉传播灰化土一样传播菌丝
    @Rule(
        categories = SkylandRGRuleCategories.SKYLAND,
        allowed = {"true", "false"}
    )
    public static boolean hugeMushroomsSpreadMycelium = false;

    // 允许下界岩或菌岩生成在空中的下界传送门旁边
    @Rule(
        categories = SkylandRGRuleCategories.SKYLAND,
        allowed = {"true", "false"}
    )
    public static boolean renewableNetherrack = false;

    public static class RenewableDeepslateValidator implements RGValidator<String> {
        @Override
        public boolean validate(@NotNull String oldValue, @NotNull String newValue) {
            return newValue.equals("true") || newValue.equals("false") || newValue.equals("no_splash");
        }

        @Override
        public String reason() {
            return "The input value must be included in 'true', 'false', 'no_splash'";
        }
    }

    // 允许浓稠的药水将石头转化为深板岩，可以通过右键点击或者使用喷溅药水
    @Rule(
        categories = SkylandRGRuleCategories.SKYLAND,
        allowed = {"true", "false", "no_splash"},
        validator = RenewableDeepslateValidator.class
    )
    public static String renewableDeepslate = "false";

    // 允许监守者附近的附魔台提供迅捷潜行的附魔
    @Rule(
        categories = SkylandRGRuleCategories.SKYLAND,
        allowed = {"true", "false"}
    )
    public static boolean renewableSwiftSneak = false;

    // 溺尸在生成时有时会手持一个嗅探兽蛋
    @Rule(
        categories = SkylandRGRuleCategories.SKYLAND,
        allowed = {"true", "false"}
    )
    public static boolean sniffersFromDrowneds = false;

    public static class SuspiciousSniffersValidator implements RGValidator<String> {
        @Override
        public boolean validate(@NotNull String oldValue, @NotNull String newValue) {
            return newValue.equals("true") || newValue.equals("false") || newValue.equals("no_iron");
        }

        @Override
        public String reason() {
            return "The input value must be included in 'true', 'false', 'no_splash'";
        }
    }

    // 嗅探兽在某些情况下可以将沙子和沙砾转变为可疑的沙子和可疑的沙砾
    @Rule(
        categories = SkylandRGRuleCategories.SKYLAND,
        allowed = {"true", "false", "no_iron"},
        validator = SuspiciousSniffersValidator.class
    )
    public static String suspiciousSniffers = "false";

    // 允许小型垂滴叶在某些情况下可以缓慢地传播到附近的方块上
    @Rule(
        categories = SkylandRGRuleCategories.SKYLAND,
        allowed = {"true", "false"}
    )
    public static boolean spreadingSmallDripleaves = false;

    // 允许珊瑚传播到附近的方解石上
    @Rule(
        categories = SkylandRGRuleCategories.SKYLAND,
        allowed = {"true", "false"}
    )
    public static boolean spreadingCoral = false;

    public static class MaxWanderingTraderSpawnChanceValidator extends RGValidator.FloatValidator {
        @Override
        public Map.@NotNull Entry<Float, Float> getRange() {
            return Map.entry(0.025f, 1.0f);
        }
    }

    // 流浪商人的最大生成概率
    @Rule(
        categories = SkylandRGRuleCategories.SKYLAND,
        allowed = {"0.025", "0.075", "0.25", "0.75", "1.0"},
        validator = MaxWanderingTraderSpawnChanceValidator.class
    )
    public static float maxWanderingTraderSpawnChance = 0.075f;
}
