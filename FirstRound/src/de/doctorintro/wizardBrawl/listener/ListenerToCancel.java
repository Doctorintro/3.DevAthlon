package de.doctorintro.wizardBrawl.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

/**
 * Created by Doctorintro on 16.07.2016.
 */
public class ListenerToCancel implements Listener{

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    public void onFood(FoodLevelChangeEvent e){
        e.setCancelled(true);
    }
}
