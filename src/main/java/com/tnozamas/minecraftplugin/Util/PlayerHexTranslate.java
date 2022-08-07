package com.tnozamas.minecraftplugin.Util;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerHexTranslate implements Listener {

    @EventHandler
    public void onMessage(AsyncPlayerChatEvent event) {

        event.setMessage(HexTranslate.color(event.getMessage()));

    }

}
