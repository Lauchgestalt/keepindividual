package com.callmeperky.keepindividualspigot;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.java.JavaPlugin;

public final class KeepIndividualSpigot extends JavaPlugin {
    public PermissionAttachment attachment;
    public boolean defaultkeep;
    private boolean isFirstRun;

    @Override
    public void onEnable() {
        Bukkit.getServer().getConsoleSender().sendMessage(Color.GREEN + "KeepIndividualSpigot enabled.");
        saveDefaultConfig();
        isFirstRun = getConfig().getBoolean("firstrun");
        boolean gameruleValue = Bukkit.getServer().getWorlds().get(0).getGameRuleValue("keepInventory").equals("true");
        if(isFirstRun){
            getConfig().set("firstrun", false);
            getConfig().set("default", true);

            if(gameruleValue){
                getConfig().set("default", true);
                defaultkeep = true;
                Bukkit.getServer().getWorlds().get(0).setGameRuleValue("keepInventory", "false");
                gameruleValue = false;
            } else {
                getConfig().set("default", false);
                defaultkeep = false;
            }

            saveConfig();
            isFirstRun = false;
        }
        if(gameruleValue){
            Bukkit.getServer().getConsoleSender().sendMessage(Color.RED + "WARNING: gamerule keepInventory is set to true. This will override the plugins behavior.");
        }

        getServer().getPluginManager().registerEvents(new DeathListener(), this);
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        this.getCommand("KI").setExecutor(new CommandKI(this));
    }

    public void setDefaultKeep(boolean value){
        defaultkeep = value;
        getConfig().set("default", value);
        saveConfig();
    }
}
