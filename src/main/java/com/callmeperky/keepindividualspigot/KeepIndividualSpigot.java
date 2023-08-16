package com.callmeperky.keepindividualspigot;
import org.bukkit.inventory.Inventory;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public final class KeepIndividualSpigot extends JavaPlugin {
    public List<String> players;
    public boolean selfperm;
    public PermissionAttachment attachment;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        players = getConfig().getStringList("players");
        selfperm = getConfig().getBoolean("selfperm");

        getServer().getPluginManager().registerEvents(new DeathListener(), this);
        this.getCommand("KI").setExecutor(new CommandKI());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getConfig().set("players", players);
        saveConfig();
    }
}
