package de.doctorintro.wizardbrawl.listener;

import de.doctorintro.wizardbrawl.WizardBrawl;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

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
        if(itemStack == null || itemStack.getItemMeta() == null || itemStack.getItemMeta().getDisplayName() == null){
            return;
        }
        e.setCancelled(true);
        if(inv.getTitle().equals(plugin.getInventoryManager().getSelectWizard().getTitle())){
            if(itemStack.getType().equals(Material.STAINED_CLAY)){
                p.setMetadata("openChooser", new FixedMetadataValue(plugin, false));
                p.openInventory(plugin.getInventoryManager().getKitInventor(ChatColor.stripColor(itemStack.getItemMeta().getDisplayName())));
            }
        }else if(inv.getTitle().contains("Zunft")){
            if(itemStack.getItemMeta().getDisplayName().contains("§a")){
                p.setMetadata("openChooser", new FixedMetadataValue(plugin, false));
                plugin.getKitManager().setKit(p, ChatColor.stripColor(inv.getTitle().split(" ")[2]));
                p.closeInventory();
            }else if(itemStack.getItemMeta().getDisplayName().contains("§c")){
                p.closeInventory();
            }
        }else if(!e.getSlotType().equals(InventoryType.SlotType.ARMOR) && !(e.getSlot() == - 106)) {
            e.setCancelled(false);
        }
    }

}
