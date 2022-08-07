package com.tnozamas.minecraftplugin.Util;

import org.bukkit.ChatColor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HexTranslate {

    public static String color(String string) {

        Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");

        for (Matcher matcher = pattern.matcher(string); matcher.find(); matcher = pattern.matcher(string)) {
            String color = string.substring(matcher.start(), matcher.end());
            string = string.replace(color, net.md_5.bungee.api.ChatColor.of(color) + "");
        }

        string = ChatColor.translateAlternateColorCodes('&', string);

        return string;
    }


}
