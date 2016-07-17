package de.doctorintro.wizardbrawl.listener;

import de.doctorintro.wizardbrawl.WizardBrawl;
import de.doctorintro.wizardbrawl.player.IPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

/**
 * Created by Doctorintro on 17.07.2016.
 */
public class EntityDamageByEntityListener implements Listener{

    private WizardBrawl plugin;

    public EntityDamageByEntityListener(WizardBrawl plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void on(EntityDamageByEntityEvent e){
        if(e.getDamager() instanceof Player){
            IPlayer wp = plugin.getPlayerManager().getPlayer((Player) e.getDamager());
            if(((Player) e.getDamager()).getInventory().getItemInMainHand().getType().equals(wp.getActiv().getType()))
                e.setDamage(EntityDamageEvent.DamageModifier.MAGIC, 3);
        }
    }

}
