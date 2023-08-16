package com.callmeperky.keepindividualspigot;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandRemoveSelf implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        KeepIndividualSpigot plugin = KeepIndividualSpigot.getPlugin(KeepIndividualSpigot.class);
        if(strings.length != 0){
            commandSender.sendMessage("This command does not take any arguments.");
            return false;
        } else {
            if(!plugin.selfperm){
                commandSender.sendMessage("Self-permission is not enabled.");
                return false;
            }
            if(plugin.players.contains(commandSender.getName())){
                plugin.players.remove(commandSender.getName());
                commandSender.sendMessage("Removed " + commandSender.getName() + " from the list.");
                return true;
            } else {
                commandSender.sendMessage("You are not in the list.");
                return false;
            }
        }
    }
}
