package de.doctorintro.wizardbrawl.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 * Created by Doctorintro on 17.07.2016.
 */
public class PlayerDeathListener implements Listener{

    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        Player p = e.getEntity();
        e.setKeepInventory(true);
        e.setDeathMessage(" ");
        e.setKeepLevel(true);
    }

}
