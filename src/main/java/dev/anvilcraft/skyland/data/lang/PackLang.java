package dev.anvilcraft.skyland.data.lang;

import dev.anvilcraft.lib.v2.registrum.providers.RegistrumLangProvider;

/**
 * 内置数据包相关语言
 */
public class PackLang {
    public static void init(RegistrumLangProvider provider) {
        provider.add("pack.skyland.builtin_pack", "Skyland DataPack");
        provider.add("pack.skyland.skyland.description", "Normal Skyland");
        provider.add("pack.skyland.skyland_acacia.description", "Acacia Skyland");
        provider.add("pack.skyland.skyland_anvilcraft.description", "AnvilCraft Skyland");
    }
}
