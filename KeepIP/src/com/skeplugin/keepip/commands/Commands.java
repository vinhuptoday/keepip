package com.skeplugin.keepip.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.skeplugin.keepip.Main;

public class Commands implements CommandExecutor {
	public Main pl = Main.getPlugin();
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (args.length == 0) {
				if (p.hasPermission("keepip.reload") || (p.hasPermission("keepip.enable") || p.hasPermission("keepip.disable"))) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix")) + ChatColor.GREEN + "Usage: /keepip <enable/disable> <inventory/xp>");
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix")) + ChatColor.GREEN + "To reload configuration: /keepip reload");
				} else {
					p.sendMessage(ChatColor.RED + "You don't have permission to use this command !");
				}
			} else {
				if (args[0].equalsIgnoreCase("enable")) {
					if (p.hasPermission("keepip.enable")) {
						if (args.length >= 2) {
							if (args[1].equalsIgnoreCase("inventory")) {
								pl.getConfig().set("enable-keep-inventory", true);
								pl.saveConfig();
								p.sendMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix")) + "Keep Inventory enabled !");
							} else if (args[1].equalsIgnoreCase("xp")) {
								pl.getConfig().set("enable-keep-xp", true);
								pl.saveConfig();
								p.sendMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix")) + "Keep XP enabled !");
							} else {
								p.sendMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix")) + ChatColor.GREEN + "Usage: /keepip enable <inventory/xp>");
							}
						} else {
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix")) + ChatColor.GREEN + "Usage: /keepip enable <inventory/xp>");
						}
					} else {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix")) + "You don't have permission (keepip.enable) to use this command !");
					}
				} else if (args[0].equalsIgnoreCase("disable")) {
					if (p.hasPermission("keepip.disable")) {
						if (args.length >= 2) {
							if (args[1].equalsIgnoreCase("inventory")) {
								pl.getConfig().set("enable-keep-inventory", false);
								pl.saveConfig();
								p.sendMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix")) + "Keep Inventory disabled !");
							} else if (args[1].equalsIgnoreCase("xp")) {
								pl.getConfig().set("enable-keep-xp", false);
								pl.saveConfig();
								p.sendMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix")) + "Keep XP disabled !");
							} else {
								p.sendMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix")) + ChatColor.GREEN + "Usage: /keepip disable <inventory/xp>");
							}
						} else {
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix")) + ChatColor.GREEN + "Usage: /keepip disable <inventory/xp>");
						}
					} else {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix")) + "You don't have permission (keepip.disable) to use this command !");
					}
				} else if (args[0].equalsIgnoreCase("reload")) {
					if (p.hasPermission("keepip.reload")) {
						pl.reloadConfig();
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix")) + "Configuration reloaded");
					} else {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix")) + "You don't have permission (keepip.reload) to use this command !");
					}
				} else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix")) + ChatColor.GREEN + "Usage: /keepip <enable/disable> <inventory/xp>");
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix")) + ChatColor.GREEN + "To reload configuration: /keepip reload");
				}
			}
		} else {
			if (!(args.length == 0)) {
				if (args[0].equalsIgnoreCase("enable")) {
					if (args.length >= 2) {
						if (args[1].equalsIgnoreCase("inventory")) {
							pl.getConfig().set("enable-keep-inventory", true);
							pl.saveConfig();
							pl.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix")) + "Keep Inventory enabled !");
						} else if (args[1].equalsIgnoreCase("xp")) {
							pl.getConfig().set("enable-keep-xp", true);
							pl.saveConfig();
							pl.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix")) + "Keep XP enabled !");
						} else {
							pl.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix")) + ChatColor.GREEN + "Usage: /keepip enable <inventory/xp>");
						}
					} else {
						pl.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix")) + ChatColor.GREEN + "Usage: /keepip enable <inventory/xp>");
					}
			} else if (args[0].equalsIgnoreCase("disable")) {
					if (args.length >= 2) {
						if (args[1].equalsIgnoreCase("inventory")) {
							pl.getConfig().set("enable-keep-inventory", false);
							pl.saveConfig();
							pl.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix")) + "Keep Inventory disabled !");
						} else if (args[1].equalsIgnoreCase("xp")) {
							pl.getConfig().set("enable-keep-xp", false);
							pl.saveConfig();
							pl.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix")) + "Keep XP disabled !");
						} else {
							pl.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix")) + ChatColor.GREEN + "Usage: /keepip disable <inventory/xp>");
						}
					} else {
						pl.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix")) + ChatColor.GREEN + "Usage: /keepip disable <inventory/xp>");
					}
				} else if (args[0].equalsIgnoreCase("reload")) {
					pl.reloadConfig();
					pl.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix")) + "Configuration reloaded");
				} else {
					pl.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix")) + ChatColor.GREEN + "Usage: /keepip <enable/disable> <inventory/xp>");
					pl.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix")) + ChatColor.GREEN + "To reload configuration: /keepip reload");
				}
			} else {
				pl.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix")) + ChatColor.GREEN + "Usage: /keepip <enable/disable> <inventory/xp>");
				pl.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getString("prefix")) + ChatColor.GREEN + "To reload configuration: /keepip reload");
			}
			}
		return true;
	}
}