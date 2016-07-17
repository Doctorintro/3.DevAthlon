package de.doctorintro.wizardbrawl.listener;

import de.doctorintro.wizardbrawl.WizardBrawl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

/**
 * Created by Doctorintro on 17.07.2016.
 */
public class EntityDamgeListener implements Listener{

    private WizardBrawl plugin;

    public EntityDamgeListener(WizardBrawl plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void on(EntityDamageEvent e){
        if(!(e.getEntity() instanceof Player)) return;
        if(plugin.getPlayerManager().getPlayer((Player) e.getEntity()) == null) e.setCancelled(true);
        else e.setCancelled(false);
    }

}
