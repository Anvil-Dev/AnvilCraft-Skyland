<div align="center">

<img src="src/main/resources/pack.png" width="256" height="256" alt="AnvilCraft: Skyland icon">

# AnvilCraft: Skyland

**A NeoForge skyblock world generation mod for Minecraft — an empty world where everything is renewable, powered by the AnvilCraft technology line.**

English | [简体中文](README.zh_CN.md)

</div>

[![Development Builds](https://github.com/Anvil-Dev/AnvilCraft-Skyland/actions/workflows/ci.yml/badge.svg)](https://github.com/Anvil-Dev/AnvilCraft-Skyland/actions/workflows/ci.yml)
[![GitHub downloads](https://img.shields.io/github/downloads/Anvil-Dev/AnvilCraft-Skyland/total?label=Github%20downloads&logo=github)](https://github.com/Anvil-Dev/AnvilCraft-Skyland/releases)

## Introduction

AnvilCraft: Skyland adds a **Skyland** world preset to Minecraft. The world is generated as an endless void with only a small spawn platform to stand on, inspired by [CarpetSkyAdditions-Reborn](https://github.com/TreeOfSelf/CarpetSkyAdditions-Reborn/). Even so, the world is fully playable: structures, portals and resources can all be obtained through the mod's built-in generation tweaks and renewable mechanics, and playing together with [AnvilCraft](https://github.com/Anvil-Dev/AnvilCraft) unlocks a complete skyblock technology progression.

## Features

- **Skyland world preset**: select the Skyland world type when creating a world to start on a small platform above the void.
- **Locatable structures**: stronghold portal rooms, silverfish spawners and more are generated at fixed positions, so they can still be found with `/locate`; end gateways spawn small islands when used.
- **Renewable rules**: dozens of optional rules make normally non-renewable resources obtainable — renewable diamonds, budding amethysts, dragon heads, echo shards, hearts of the sea, coral erosion, suspicious sniffers and much more.
- **Rule configuration**: all rules can be toggled in game through the [RollingGate](https://github.com/Anvil-Dev/RollingGate) integration.
- **Built-in data packs**: Normal Skyland, Acacia Skyland and AnvilCraft Skyland variants change the spawn platform and starting experience.
- **AnvilCraft integration** (optional): adds the stone anvil, pebble, moss and bamboo leaves, plus skyblock-friendly crushing, cooling, time-warp and melting recipes, enabling a full progression from nothing to endgame.

## Usage

1. Install Minecraft 1.21.1 with NeoForge 21.x.
2. Drop the mod jar into the `mods` folder. AnvilCraft and RollingGate are optional but recommended companions.
3. Create a new world and choose **Skyland** as the world type.

## Building

```shell
./gradlew build
```

The built jar is located in `build/libs`.

## License

- Source code is licensed under the [GNU LGPL 3.0](LICENSE).
- Assets are [all rights reserved](ASSETS_LICENSE) unless explicitly stated.
