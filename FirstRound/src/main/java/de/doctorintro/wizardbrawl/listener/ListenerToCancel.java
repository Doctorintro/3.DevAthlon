package de.doctorintro.wizardbrawl.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

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

    @EventHandler
    public void onArchivment(PlayerAchievementAwardedEvent e) { e.setCancelled(true); }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e){ e.setCancelled(true); }

     @EventHandler
    public void onPickUp(PlayerPickupItemEvent e){
         e.setCancelled(true);
     }
}
