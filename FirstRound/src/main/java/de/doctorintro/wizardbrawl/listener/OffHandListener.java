package de.doctorintro.wizardbrawl.listener;

import de.doctorintro.wizardbrawl.WizardBrawl;
import de.doctorintro.wizardbrawl.player.IPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Doctorintro on 16.07.2016.
 */
public class OffHandListener implements Listener{

    private WizardBrawl plugin;

    public OffHandListener(WizardBrawl plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onSwitch(PlayerSwapHandItemsEvent e){
        Player p = e.getPlayer();
        IPlayer wp = plugin.getPlayerManager().getPlayer(p);
        ItemStack off = e.getOffHandItem();
        ItemStack main = e.getMainHandItem();
        e.setCancelled(true);
        if(off.getType().equals(wp.getPassiv().getType())){
            if (!wp.getPassiv().getTask().isRunnig()) {
                e.setCancelled(false);
                    wp.getPassiv().onActive(p);
            }else{
                e.setCancelled(true);
            }
        }
    }

}
