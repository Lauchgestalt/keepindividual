package com.callmeperky.keepindividualspigot;

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
                    commandSender.sendMessage("Set your personal keepinventory rule to " + !hasperm);
                    System.out.println("Set " + sender.getName() + "'s keepinventory rule to " + !hasperm);
                }
        );
        return true;
    }
}
