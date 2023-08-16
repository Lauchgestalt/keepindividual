package com.callmeperky.keepindividualspigot;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class CommandKI implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        switch (strings[0]){
            case "toggleself":
                return new CommandToggleSelf().onCommand(commandSender, command, s, strings);
            case "toggle":
                return new CommandToggle().onCommand(commandSender, command, s, strings);
            case "list":
                return new CommandList().onCommand(commandSender, command, s, strings);
            case "setdefault":
                return new CommandList().onCommand(commandSender, command, s, strings);
            case "help":
                commandSender.sendMessage("Commands:");
                commandSender.sendMessage("/ki toggleself");
                commandSender.sendMessage("/ki toggle <player>");
                commandSender.sendMessage("/ki list");
                commandSender.sendMessage("/ki setdefault <true/false>");
                return true;
            default:
                commandSender.sendMessage("Unknown command. Use /ki help for help.");
                return false;
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        List<String> commands = new ArrayList<>();
        commands.add("toggleself");
        commands.add("toggle");
        commands.add("list");
        commands.add("setdefault");
        commands.add("help");
        return commands;
    }
}
