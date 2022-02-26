package com.skeplugin.keepip.listener;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.skeplugin.keepip.Main;

public class KeepInventoryXP implements Listener {
	public Main pl = Main.getPlugin();
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		if (pl.getConfig().getBoolean("enable-keep-inventory")) {
			if (e.getEntity().getPlayer().hasPermission("keepip.inventory")) {
				e.setKeepInventory(true);
				e.getDrops().clear();
				if (pl.getConfig().getBoolean("enable-keep-xp-message")) {
					e.getEntity().getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix") + pl.getConfig().getString("kept-inventory-messsage")));
				}
			}	
		}
		if (pl.getConfig().getBoolean("enable-keep-xp")) {
			if (e.getEntity().getPlayer().hasPermission("keepip.xp")) {
				e.setKeepLevel(true);
				e.setDroppedExp(0);
				if (pl.getConfig().getBoolean("enable-keep-inventory-message")) {
					e.getEntity().getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix") + pl.getConfig().getString("kept-xp-message")));
				}
			}	
		}
	}
}