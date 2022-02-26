package com.skeplugin.keepip.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandsProcess implements Listener {
	@EventHandler
	public void onCommandProcess(PlayerCommandPreprocessEvent e) {
		if (e.getMessage().startsWith("/keepip")) {
			Player p = e.getPlayer();
			if (!(p.hasPermission("keepip.reload")) && !(p.hasPermission("keepip.enable")) && !(p.hasPermission("keepip.disble"))) {
				e.setCancelled(true);
				p.sendMessage(ChatColor.RED + "You don't have permission to use this command !");
			}
		}
	}
}