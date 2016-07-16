package de.doctorintro.wizardbrawl.manager;

import de.doctorintro.wizardbrawl.WizardBrawl;
import de.doctorintro.wizardbrawl.kit.IKit;
import de.doctorintro.wizardbrawl.utils.ItemFactory;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Doctorintro on 16.07.2016.
 */
public class InventoryManager {

    public WizardBrawl plugin;

    public Inventory selectWizard;
    public Map<String, Inventory> kits;

    public InventoryManager(WizardBrawl plugin) {
        this.plugin = plugin;
        this.kits = new LinkedHashMap<>();

        createSelectWizard();
        loadKitInventorys();
    }

    private void loadKitInventorys() {
        for(IKit kit : plugin.getKitManager().getKits()){
            Inventory add = Bukkit.createInventory(null , 3*9, "Zunft des "+kit.getName());
            for (int i = 0; i < add.getSize(); i++)
                add.setItem(i, new ItemFactory( new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15) ).setDisplayName("").build());
            for(int i = 0; i < add.getSize()-9; i+= 9)
                add.setItem(0, new ItemFactory( new ItemStack(Material.WOOL, 1, (short) 5) ).setDisplayName("§aAuswählen").build());
            for(int i = 8; i < add.getSize()-9; i+= 9)
                add.setItem(8, new ItemFactory( new ItemStack(Material.WOOL, 1 , (short)14) ).setDisplayName("§cAbbrechen").build());
            add.setItem(13, kit.getIcon());
            add.setItem(20, kit.getActiv());
            add.setItem(14, kit.getPassiv());
        }
    }

    public Inventory getKitInventor(String kitName){
        return kits.get(kitName);
    }

    private void createSelectWizard(){
        int kits = plugin.getKitManager().getKits().size();
        int size = 9;
        while ( kits > size && size < 54){
            size += 9;
        }
        selectWizard = Bukkit.createInventory(null, size, "§e§lWähle deine Zunft");
        for (int i = 0; i < plugin.getKitManager().getKits().size(); i++) {
            selectWizard.setItem(i, plugin.getKitManager().getKits().get(i).getIcon());
        }
    }

    public Inventory getSelectWizard() {
        return selectWizard;
    }
}
