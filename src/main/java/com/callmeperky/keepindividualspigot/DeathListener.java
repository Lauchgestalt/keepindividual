package com.callmeperky.keepindividualspigot;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {
    LuckPermsHandler luckperms = new LuckPermsHandler();
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event){
        event.setDeathMessage("Schade, " + event.getEntity().getName() + " ist gestorben.");
        boolean perm = luckperms.api.getUserManager().getUser(event.getEntity().getUniqueId()).getCachedData().getPermissionData().checkPermission("keepinv.keep").asBoolean();
        if(perm){
            event.setKeepInventory(true);
            event.setKeepLevel(true);
            event.getDrops().clear();
            event.setDroppedExp(0);
        }
    }
}
