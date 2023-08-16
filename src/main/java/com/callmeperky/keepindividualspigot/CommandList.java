package com.callmeperky.keepindividualspigot;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.List;

public class CommandList implements CommandExecutor {
    LuckPermsHandler luckperms = new LuckPermsHandler();
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        luckperms.getUsersWithPermission("keepinv.keep").thenAcceptAsync(
                users -> {
                    System.out.println(commandSender.getName() + " listed users with keepinv.keep");
                    commandSender.sendMessage("Players with keepinv.keep:");
                    for (String user : users) {
                        commandSender.sendMessage(user);
                    }
                }
        );
        return true;
    }
}
