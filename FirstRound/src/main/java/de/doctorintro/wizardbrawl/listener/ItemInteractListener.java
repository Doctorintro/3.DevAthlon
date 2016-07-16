package de.doctorintro.wizardbrawl.listener;

import de.doctorintro.wizardbrawl.WizardBrawl;
import de.doctorintro.wizardbrawl.player.IPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Created by Doctorintro on 16.07.2016.
 */
public class ItemInteractListener implements Listener{

    private WizardBrawl plugin;

    public ItemInteractListener(WizardBrawl plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void on(PlayerInteractEvent e){
        Player p = e.getPlayer();
        IPlayer wp = plugin.getPlayerManager().getPlayer(p);
        if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            if(e.getMaterial().equals(wp.getActiv().getType())){
                if(!wp.getActiv().getTask().isRunnig()){
                    wp.getActiv().onActive(p);
                }
            }
        }
    }

}
