package de.doctorintro.wizardBrawl.listener;

import de.doctorintro.wizardBrawl.WizardBrawl;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Doctorintro on 16.07.2016.
 */
public class InventoryClickListener implements Listener{

    private WizardBrawl plugin;

    public InventoryClickListener(WizardBrawl plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onClicked(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        ItemStack itemStack = e.getCurrentItem();
        Inventory inv = e.getInventory();
        e.setCancelled(true);
        if(itemStack == null || itemStack.getItemMeta() == null || itemStack.getItemMeta().getDisplayName() == null){
            e.setCancelled(true);
            return;
        }
        if(inv.getTitle().equals(plugin.getInventoryManager().getSelectWizard().getTitle())){
            if(itemStack.getType().equals(Material.LEATHER_HELMET)){
                p.openInventory(plugin.getInventoryManager().getKitInventor(ChatColor.stripColor(itemStack.getItemMeta().getDisplayName())));
            }
        }else if(inv.getTitle().contains("Zunft")){
            if(itemStack.getItemMeta().getDisplayName().contains("§a")){

                p.closeInventory();
            }else if(itemStack.getItemMeta().getDisplayName().contains("§c")){
                p.openInventory(plugin.getInventoryManager().getSelectWizard());
            }
        } else e.setCancelled(false);
    }

}
