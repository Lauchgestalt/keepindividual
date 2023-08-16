package com.callmeperky.keepindividualspigot;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandList implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(strings.length != 0){
            commandSender.sendMessage("This command does not take any arguments.");
            return false;
        }
        KeepIndividualSpigot plugin = KeepIndividualSpigot.getPlugin(KeepIndividualSpigot.class);
        if(plugin.players.size() == 0){
            commandSender.sendMessage("The list is empty.");
            return true;
        }
        commandSender.sendMessage("Players in the list:");
        for(String player : plugin.players){
            commandSender.sendMessage(player);
        }
        return true;
    }
}
