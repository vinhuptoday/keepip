package com.skeplugin.keepip.tabs;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

public class TabCompletion implements TabCompleter {
	List<String> arg_cmd = new ArrayList<String>();
	List<String> arg_cmd_2 = new ArrayList<String>();
	@Override
	public List<String> onTabComplete(CommandSender sender, Command arg1,
			String arg2, String[] arg3) {
		if (arg_cmd.isEmpty()) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (p.hasPermission("keepip.enable")) arg_cmd.add("enable");
				if (p.hasPermission("keepip.disable")) arg_cmd.add("disable");
				if (p.hasPermission("keepip.reload")) arg_cmd.add("reload");
				if (arg_cmd_2.isEmpty()) {
					if (p.hasPermission("keepip.enable")) {
						arg_cmd_2.add("xp");
						arg_cmd_2.add("inventory");
					}
					if (p.hasPermission("keepip.disable")) {
						arg_cmd_2.add("xp");
						arg_cmd_2.add("inventory");
					}
				}
			}
		}
		List<String> result = new ArrayList<String>();
		List<String> result1 = new ArrayList<String>();
		if (arg3.length == 1) {
			for (String a : arg_cmd) {
				if (a.toLowerCase().startsWith(arg3[0].toLowerCase())) {
					result.add(a);
				}
			}
			return result;
		}
		if (arg3.length == 2) {
			for (String a : arg_cmd_2) {
				if (a.toLowerCase().startsWith(arg3[1].toLowerCase())) {
					result1.add(a);
				}
			}
			return result1;
		}
		return null;
	}
}