package com.callmeperky.keepindividualspigot;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandAdd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        KeepIndividualSpigot plugin = KeepIndividualSpigot.getPlugin(KeepIndividualSpigot.class);
        if (strings.length != 1) {
            commandSender.sendMessage("Only add one user at a time.");
            return false;
        }
        if(plugin.players.contains(strings[0])){
            commandSender.sendMessage(strings[0] + " is already in the list.");
            return false;
        } else {
            commandSender.sendMessage("Added " + strings[0] + " to the list.");
            plugin.players.add(strings[0]);
            return true;
        }
    }
}
