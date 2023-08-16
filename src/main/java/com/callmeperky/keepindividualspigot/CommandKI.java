package com.callmeperky.keepindividualspigot;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.List;

public class CommandKI implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        switch (strings[0]){
            case "toggleself":
                return new CommandAddSelf().onCommand(commandSender, command, s, strings);
            case "add":
                return new CommandToggleSelf().onCommand(commandSender, command, s, strings);
            case "remove":
                return new CommandAdd().onCommand(commandSender, command, s, strings);
            case "list":
                return new CommandRemove().onCommand(commandSender, command, s, strings);
            case "setdefault":
                return new CommandList().onCommand(commandSender, command, s, strings);
            default:
                commandSender.sendMessage("Unknown command. Use /ki help for help.");
                return false;
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        return null;
    }
}
