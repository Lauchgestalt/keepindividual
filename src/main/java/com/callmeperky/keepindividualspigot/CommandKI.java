package com.callmeperky.keepindividualspigot;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CommandKI implements CommandExecutor, TabCompleter {
    private final KeepIndividualSpigot plugin;

    public CommandKI(KeepIndividualSpigot plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)) return false;
        switch (strings[0]){
            case "toggleself":
                return new CommandToggleSelf().onCommand(commandSender, command, s, strings);
            case "toggle":
                return new CommandToggle().onCommand(commandSender, command, s, strings);
            case "list":
                return new CommandList().onCommand(commandSender, command, s, strings);
            case "help":
                commandSender.sendMessage(ChatColor.GREEN + "Commands:");
                commandSender.sendMessage("/ki toggleself");
                commandSender.sendMessage("/ki toggle <player>");
                commandSender.sendMessage("/ki list");
                commandSender.sendMessage("/ki help");
                return true;
            default:
                commandSender.sendMessage(ChatColor.RED + "Unknown command. Use /ki help for help.");
                return false;
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        if(strings.length == 1){
            List<String> commands = new ArrayList<>();
            commands.add("toggleself");
            commands.add("toggle");
            commands.add("list");
            commands.add("help");
            return commands;
        } else if (strings.length == 2){
            if(Objects.equals(strings[0], "toggle")){
                List<String> players = new ArrayList<>();
                for(Player player : plugin.getServer().getOnlinePlayers()){
                    players.add(player.getName());
                }
                return players;
            } else {
                return null;
            }
        }
        return null;
    }
}
