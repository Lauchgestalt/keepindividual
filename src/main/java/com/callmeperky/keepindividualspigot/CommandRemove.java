package com.callmeperky.keepindividualspigot;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandRemove implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        KeepIndividualSpigot plugin = KeepIndividualSpigot.getPlugin(KeepIndividualSpigot.class);
        if (strings.length != 1) {
            commandSender.sendMessage("Only remove one user at a time.");
            return false;
        }
        if(plugin.players.contains(strings[0])){
            plugin.players.remove(strings[0]);
            commandSender.sendMessage("Removed " + strings[0] + " from the list.");
            return true;
        } else {
            commandSender.sendMessage(strings[0] + " is not in the list.");
            return false;
        }
    }
}