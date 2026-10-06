<div align="center">

<img src="src/main/resources/pack.png" width="256" height="256" alt="铁砧工艺：空岛图标">

# 铁砧工艺：空岛

**一个 Minecraft NeoForge 空岛世界生成模组 —— 一切皆可在虚空中再生，配合铁砧工艺科技线畅玩空岛。**

[English](README.md) | 简体中文

</div>

[![Development Builds](https://github.com/Anvil-Dev/AnvilCraft-Skyland/actions/workflows/ci.yml/badge.svg)](https://github.com/Anvil-Dev/AnvilCraft-Skyland/actions/workflows/ci.yml)
[![GitHub downloads](https://img.shields.io/github/downloads/Anvil-Dev/AnvilCraft-Skyland/total?label=Github%20downloads&logo=github)](https://github.com/Anvil-Dev/AnvilCraft-Skyland/releases)

## 简介

铁砧工艺：空岛为 Minecraft 添加了 **空岛** 世界预设。世界生成为一片无尽虚空，只有一小块出生平台可供立足，灵感来源于 [CarpetSkyAdditions-Reborn](https://github.com/TreeOfSelf/CarpetSkyAdditions-Reborn/)。即便如此，世界依然可以完整游玩：借助模组内置的生成调整与可再生机制，结构、传送门与各类资源均可获得；与 [铁砧工艺](https://github.com/Anvil-Dev/AnvilCraft) 一同安装更能解锁完整的空岛科技流程。

## 特性

- **空岛世界预设**：创建世界时选择空岛世界类型，即可从虚空之上的一小块平台开始游戏。
- **可定位结构**：要塞传送门房间、蠹虫刷怪笼等结构会在固定位置生成，仍可通过 `/locate` 寻找；使用末地折跃门时会生成小岛。
- **可再生规则**：数十条可选规则让原本不可再生的资源变得可以获取 —— 可再生钻石、紫水晶母岩、龙首、回响碎片、海洋之心、珊瑚侵蚀、可疑的嗅探兽等等。
- **规则配置**：所有规则都可以通过 [RollingGate](https://github.com/Anvil-Dev/RollingGate) 集成在游戏中随时开关。
- **内置数据包**：普通空岛、金合欢空岛与铁砧工艺空岛三种变体，带来不同的出生平台与开局体验。
- **铁砧工艺集成**（可选）：添加石质铁砧、沙砾、苔藓与竹叶等内容，并提供适配空岛的粉碎、冷却、时移与熔炼配方，支撑从无到有直至毕业的全流程。

## 使用

1. 安装 Minecraft 1.21.1 与 NeoForge 21.x。
2. 将模组 jar 放入 `mods` 文件夹。铁砧工艺与 RollingGate 为可选但推荐搭配的模组。
3. 创建新世界，世界类型选择 **空岛**。

## 构建

```shell
./gradlew build
```

构建产物位于 `build/libs`。

## 许可证

- 源代码采用 [GNU LGPL 3.0](LICENSE) 许可证。
- 资源文件除明确声明外[保留所有权利](ASSETS_LICENSE)。
