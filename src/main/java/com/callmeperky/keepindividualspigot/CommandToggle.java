package com.callmeperky.keepindividualspigot;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandToggle implements CommandExecutor {
    LuckPermsHandler luckperms = new LuckPermsHandler();
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!commandSender.hasPermission("keepinv.admin.toggle")) {
            commandSender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
            return true;
        }
        if(strings.length != 2){
            commandSender.sendMessage("Usage: /keepinv toggle <player>");
        } else {
            luckperms.hasPermission(strings[1], "keepinv.keep").thenAcceptAsync(
                    haskeep -> {
                        luckperms.setPermission(luckperms.getUUID(strings[1]), "keepinv.keep", !haskeep);
                        if(haskeep){
                            commandSender.sendMessage("Set " + strings[1] + "'s keepinventory rule to " + ChatColor.RED + !haskeep);
                        } else {
                            commandSender.sendMessage("Set " + strings[1] + "'s keepinventory rule to " + ChatColor.GREEN + !haskeep);
                        }
                        System.out.println(commandSender.getName() + " set " + strings[1] + "'s keepinventory rule to " + !haskeep);
                    }
            );
        }
        return true;
    }
}
