package com.skeplugin.keepip;

import org.bukkit.plugin.java.JavaPlugin;

import com.skeplugin.keepip.commands.Commands;
import com.skeplugin.keepip.listener.CommandsProcess;
import com.skeplugin.keepip.listener.KeepInventoryXP;
import com.skeplugin.keepip.tabs.TabCompletion;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin {
	public static Main plugin;
	public static Main getPlugin() {
		return plugin;
	}
	@Override
	public void onEnable() {
		// Give Main to "plugin" static
		plugin = this;
		// Save configuration
		saveDefaultConfig();
		// Send message to Console
		getServer().getConsoleSender().sendMessage("[" + ChatColor.GREEN + "KeepInventoryXP" + ChatColor.RESET + "] Plugin is enabled !");
		// Registers
		registerEvents();
		registerCommand();
	}
	public void registerEvents() {
		getServer().getPluginManager().registerEvents(new KeepInventoryXP(), this);
		getServer().getPluginManager().registerEvents(new CommandsProcess(), this);
	}
	public void registerCommand() {
		getCommand("keepip").setExecutor(new Commands());
		getCommand("keepip").setTabCompleter(new TabCompletion());
	}
}