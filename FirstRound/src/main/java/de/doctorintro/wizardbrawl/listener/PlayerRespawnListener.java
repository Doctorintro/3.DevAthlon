package de.doctorintro.wizardbrawl.listener;

import de.doctorintro.wizardbrawl.WizardBrawl;
import de.doctorintro.wizardbrawl.player.IPlayer;
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
    public void on(PlayerRespawnEvent e) throws CloneNotSupportedException {
        IPlayer wp = plugin.getPlayerManager().getPlayer(e.getPlayer());
        if(wp != null) {
            e.setRespawnLocation(plugin.getLocationManager().getRandomSpawnLocation());
            plugin.getKitManager().setKit(wp.getPlayer(), wp.getKit().getName(), false);
        }else{
            e.setRespawnLocation(plugin.getLocationManager().getSpawnLocation());
            wp.getPlayer().openInventory(plugin.getInventoryManager().getSelectWizard());
        }

    }

}
