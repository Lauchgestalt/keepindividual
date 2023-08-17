package com.callmeperky.keepindividualspigot;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.ArrayList;
import java.util.List;

public class DeathListener implements Listener {
    LuckPermsHandler luckperms = new LuckPermsHandler();
    List<String> deathMessages = new ArrayList<String>();

    public DeathListener(){
        deathMessages.add("Schade, %player% ist gestorben.");
        deathMessages.add("Oh nein, %player% ist gestorben.");
        deathMessages.add("RIP %player%");
        deathMessages.add("F in den Chat für %player%");
        deathMessages.add("Oh nein! %player% hat das Zeitliche gesegnet.");
        deathMessages.add("Ein Held fällt: %player%'s Abenteuer endet hier.");
        deathMessages.add("Die Pixelwelt trauert um %player%'s Verlust.");
        deathMessages.add("Trostloser Moment: %player% ist gefallen.");
        deathMessages.add("Die Götter rufen nach %player%.");
        deathMessages.add("Das Spiel der Blöcke hat %player% überlistet.");
        deathMessages.add("Ein tragischer Tod für %player%, aber das Abenteuer geht weiter.");
        deathMessages.add("Die Legende von %player% endet hier.");
        deathMessages.add("Der Tapferkeit von %player% wird gedacht.");
        deathMessages.add("Der Boden hat sich nach %player% gesehnt.");
        deathMessages.add("Die Pixel haben ihren Tribut gefordert: %player% ist gefallen.");
        deathMessages.add("Selbst die Mutigsten wie %player% können dem Tod nicht entkommen.");
        deathMessages.add("Die Welt der Blöcke hat %player%'s Geschichte beendet.");
        deathMessages.add("Die Schergen der Dunkelheit haben %player% ergriffen.");
        deathMessages.add("Ein weiteres Abenteuer von %player% findet ein jähes Ende.");
        deathMessages.add("Die Servergötter nehmen %player% in ihre Obhut.");
        deathMessages.add("Die Schatten haben %player% verschlungen, doch die Erinnerung bleibt.");
        deathMessages.add("%player% hat den Endbildschirm erreicht.");
        deathMessages.add("Die Pixelwelt hat %player% verschlungen.");

    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event){
        event.setDeathMessage(deathMessages.get((int) (Math.random() * deathMessages.size())).replace("%player%", event.getEntity().getName()));
        boolean perm = luckperms.api.getUserManager().getUser(event.getEntity().getUniqueId()).getCachedData().getPermissionData().checkPermission("keepinv.keep").asBoolean();
        if(perm){
            event.setKeepInventory(true);
            event.setKeepLevel(true);
            event.getDrops().clear();
            event.setDroppedExp(0);
        }
    }
}
