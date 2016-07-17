package de.doctorintro.wizardbrawl.listener;

import de.doctorintro.wizardbrawl.WizardBrawl;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

/**
 * Created by Doctorintro on 17.07.2016.
 */
public class PlayerRespawnListener implements Listener{

    private WizardBrawl plugin;

    public PlayerRespawnListener(WizardBrawl plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void on(PlayerRespawnEvent e){
        e.setRespawnLocation(plugin.getLocationManager().getRandomSpawnLocation());
    }

}
