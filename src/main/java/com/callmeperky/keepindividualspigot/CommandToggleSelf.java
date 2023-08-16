package com.callmeperky.keepindividualspigot;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.PermissionAttachment;

import java.util.Optional;

public class CommandToggleSelf implements CommandExecutor {
    LuckPermsHandler luckperms = new LuckPermsHandler();
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Optional<Boolean> hasPermission = luckperms.hasPermission(commandSender.getName(), "keepindividualspigot.toggle");
        if(hasPermission.equals(Optional.of(true))){
            commandSender.sendMessage("You do not have permission to use this command.");
            return false;
        } else {

        }

        KeepIndividualSpigot plugin = KeepIndividualSpigot.getPlugin(KeepIndividualSpigot.class);
        plugin.selfperm = !plugin.selfperm;
        commandSender.sendMessage("Self-permission toggled to " + plugin.selfperm);
        return true;
    }
}
