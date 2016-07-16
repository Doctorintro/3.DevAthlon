package de.doctorintro.wizardBrawl.manager;

import de.doctorintro.wizardBrawl.WizardBrawl;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

/**
 * Created by Doctorintro on 16.07.2016.
 */
public class InventoryManager {

    public WizardBrawl plugin;

    public Inventory selectWizard;

    public InventoryManager(WizardBrawl plugin) {
        this.plugin = plugin;

        createSelectWizard();
    }

    /**
     * TODO: Create Inventorys
     **/

    private void createSelectWizard(){
        int kits = plugin.getKitManager().getKits().size();
        int size = 9;
        while ( kits > size && size < 54){
            size += 9;
        }
        selectWizard = Bukkit.createInventory(null, size, "§e§lWähle dein Stamm");
        for (int i = 0; i < plugin.getKitManager().getKits().size(); i++) {
            selectWizard.setItem(i, plugin.getKitManager().getKits().get(i).getIcon());
        }
    }

    public Inventory getSelectWizard() {
        return selectWizard;
    }
}
