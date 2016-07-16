package de.doctorintro.wizardBrawl.listener;

import de.doctorintro.wizardBrawl.WizardBrawl;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by Doctorintro on 16.07.2016.
 */
public class PlayerJoinListener implements Listener{

    private WizardBrawl plugin;

    public PlayerJoinListener(WizardBrawl plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        e.setJoinMessage("");
        Player p = e.getPlayer();

        p.teleport(plugin.getLocationManager().getSpawnLocation());
        p.setHealthScale(20D);
        p.setGameMode(GameMode.ADVENTURE);
        p.setFoodLevel(20);
        p.setFlying(false);
        p.setAllowFlight(false);
        p.setLevel(0);
        p.setExp(0);
        p.setBedSpawnLocation(null);
        p.setSaturation(20);
        p.setCollidable(false);
        p.getInventory().clear();
        p.getInventory().setArmorContents(null);

        p.openInventory(plugin.getInventoryManager().getSelectWizard());
    }

}
