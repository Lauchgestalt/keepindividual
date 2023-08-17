package com.callmeperky.keepindividualspigot;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandToggleSelf implements CommandExecutor {
    LuckPermsHandler luckperms = new LuckPermsHandler();
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player sender = commandSender.getServer().getPlayer(commandSender.getName());
        luckperms.hasPermission(commandSender.getName(), "keepinv.keep").thenAcceptAsync(
                hasperm -> {
                    luckperms.setPermission(sender.getUniqueId(), "keepinv.keep", !hasperm);
                    if(hasperm) {
                        commandSender.sendMessage("Set your personal keepinventory rule to " + ChatColor.RED + !hasperm);
                    } else {
                        commandSender.sendMessage("Set your personal keepinventory rule to " + ChatColor.GREEN + !hasperm);
                    }
                    System.out.println(sender.getName() + " set his own keepinventory rule to " + !hasperm);
                }
        );
        return true;
    }
}
