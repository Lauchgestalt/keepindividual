package com.callmeperky.keepindividualspigot;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;
import java.util.List;

public class JoinListener implements Listener {
    private List<String> joinMessages = new ArrayList<>();

    public JoinListener(){
        joinMessages.add("Schön, dass du da bist, %player% :)");;
        joinMessages.add("Willkommen, %player%!");;
        joinMessages.add("Hallo, %player%!");;
        joinMessages.add("Juhu! %player% ist da!");;
        joinMessages.add("Ein lautes 'Willkommen' für %player%!");
        joinMessages.add("Der tapfere Abenteurer %player% ist eingetroffen!");
        joinMessages.add("Hoch die Tassen, %player% ist da!");
        joinMessages.add("Alle Mann an Deck, %player% ist an Land gesprungen!");
        joinMessages.add("Herzlich willkommen, %player%! Die Party kann beginnen!");
        joinMessages.add("Ahoi, %player%! Dein Abenteuer beginnt jetzt!");
        joinMessages.add("Es ist Zeit, %player% zu begrüßen!");
        joinMessages.add("Bereit machen für %player%'s epischen Auftritt!");
        joinMessages.add("Rollt den roten Teppich aus für %player%!");
        joinMessages.add("Ein donnerndes Hallo für %player%!");
        joinMessages.add("Grüß dich, %player%! Deine Reise beginnt hier.");
        joinMessages.add("Schick schick, %player% ist angekommen!");
        joinMessages.add("Willkommen an Bord, %player%!");
        joinMessages.add("Hey ho, %player%! Lasst das Abenteuer beginnen!");
        joinMessages.add("Haltet euch fest, %player% ist gelandet!");
        joinMessages.add("Schön dich zu sehen, %player%! Bring das Pixelabenteuer zum Leben!");
        joinMessages.add("Herzlich willkommen, %player%! Deine Legende wartet auf dich!");
        joinMessages.add("Gut gemacht, du hast den Server gefunden, %player%!");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        event.setJoinMessage(joinMessages.get((int) (Math.random() * joinMessages.size())).replace("%player%", event.getPlayer().getName()));
    }
}
