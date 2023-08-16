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
        this.getCommand("KI_add").setExecutor(new CommandAdd());
        this.getCommand("KI_remove").setExecutor(new CommandRemove());
        this.getCommand("KI_list").setExecutor(new CommandList());
        this.getCommand("KI_addself").setExecutor(new CommandAddSelf());
        this.getCommand("KI_removeself").setExecutor(new CommandRemoveSelf());
        this.getCommand("KI_toggleself").setExecutor(new CommandToggleSelf());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getConfig().set("players", players);
        saveConfig();
    }
}
