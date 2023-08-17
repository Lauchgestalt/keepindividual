package com.callmeperky.keepindividualspigot;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.plugin.java.JavaPlugin;

public final class KeepIndividualSpigot extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getServer().getConsoleSender().sendMessage(Color.GREEN + "KeepIndividualSpigot enabled.");
        boolean gameruleValue = Bukkit.getServer().getWorlds().get(0).getGameRuleValue("keepInventory").equals("true");
        if(gameruleValue){
            Bukkit.getServer().getConsoleSender().sendMessage(Color.RED + "WARNING: gamerule keepInventory is set to true. This will override the plugins behavior.");
        }

        getServer().getPluginManager().registerEvents(new DeathListener(), this);
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        this.getCommand("KI").setExecutor(new CommandKI(this));
    }
}
