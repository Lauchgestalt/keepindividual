package com.callmeperky.keepindividualspigot;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Objects;

public class CommandList implements CommandExecutor {
    LuckPermsHandler luckperms = new LuckPermsHandler();
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!commandSender.hasPermission("keepinv.admin.list")) {
            commandSender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
            return true;
        }
        luckperms.getUsersWithPermission("keepinv.keep").thenAcceptAsync(
                users -> {
                    System.out.println(commandSender.getName() + " listed users with keepinv.keep");
                    commandSender.sendMessage("Players with keepinv.keep:");
                    for (String user : users) {
                        String[] userparts = user.split(": ");
                        String boolvalue = userparts[1];
                        if(Objects.equals(boolvalue, "true")){
                            user = userparts[0] + ": " + ChatColor.GREEN + boolvalue;
                        } else {
                            user = userparts[0] + ": " + ChatColor.RED + boolvalue;
                        }
                        commandSender.sendMessage(user);
                    }
                }
        );
        return true;
    }
}
