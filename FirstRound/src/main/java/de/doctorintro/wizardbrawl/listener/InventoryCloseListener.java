package de.doctorintro.wizardbrawl.listener;

import de.doctorintro.wizardbrawl.WizardBrawl;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.metadata.MetadataValue;

import java.util.List;

/**
 * Created by Doctorintro on 16.07.2016.
 */
public class InventoryCloseListener implements Listener{

    private WizardBrawl plugin;

    public InventoryCloseListener(WizardBrawl plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onClose(InventoryCloseEvent e) {
        Player p = (Player) e.getPlayer();
        Inventory inv = e.getInventory();
        if (inv.getTitle().contains("Zunft")) {
            List<MetadataValue> meta = p.getMetadata("openChooser");
            if (plugin.getPlayerManager().getPlayer(p) == null) {
                if((meta == null || meta.isEmpty())) {
                    Bukkit.getScheduler().runTaskLater(plugin, () -> {
                        p.openInventory(plugin.getInventoryManager().getSelectWizard());
                    }, 1);
                }else{
                    p.removeMetadata("openChooser", plugin);
                }
            }
        }
    }
}
