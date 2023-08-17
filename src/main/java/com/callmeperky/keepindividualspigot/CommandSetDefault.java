package com.callmeperky.keepindividualspigot;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandSetDefault implements CommandExecutor {
    private final KeepIndividualSpigot plugin;

    public CommandSetDefault(KeepIndividualSpigot plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!commandSender.hasPermission("keepinv.admin.setdefault")) {
            commandSender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
            return true;
        }
        if(strings.length != 2) return false;
        switch (strings[1]){
            case "true":
                plugin.setDefaultKeep(true);
                commandSender.sendMessage("Set default to " + ChatColor.GREEN + "true.");
                return true;
            case "false":
                plugin.setDefaultKeep(false);
                commandSender.sendMessage("Set default to " + ChatColor.RED + "false.");
                return true;
            default:
                commandSender.sendMessage(ChatColor.YELLOW + "Usage: /ki setdefault <true/false>");
                return false;
        }
    }
}
