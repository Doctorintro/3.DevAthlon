package de.doctorintro.wizardBrawl.listener;

import de.doctorintro.wizardBrawl.WizardBrawl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

/**
 * Created by Doctorintro on 16.07.2016.
 */
public class InventoryCloseListener implements Listener{

    private WizardBrawl plugin;

    public InventoryCloseListener(WizardBrawl plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onClose(InventoryCloseEvent e){
        Player p  = (Player) e.getPlayer();
        if (plugin.getKitManager().getKit(p) == null) {
            p.openInventory(plugin.getInventoryManager().getSelectWizard());
        }
    }

}
