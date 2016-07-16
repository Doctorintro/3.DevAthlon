package de.doctorintro.wizardbrawl.manager;

import de.doctorintro.wizardbrawl.WizardBrawl;
import de.doctorintro.wizardbrawl.kit.IKit;
import de.doctorintro.wizardbrawl.kit.Kit;
import de.doctorintro.wizardbrawl.spells.BasicTestSpell;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Doctorintro on 16.07.2016.
 */
public class KitManager {

    private WizardBrawl plugin;
    private List<IKit> kits;

    public KitManager(WizardBrawl plugin) {
        this.plugin = plugin;
        kits = new LinkedList<>();
        loadKits();
    }

    private void loadKits() {
        kits.add(new Kit("Test", 5, ChatColor.AQUA, new BasicTestSpell(), new BasicTestSpell()));
    }

    public List<IKit> getKits() {
        return kits;
    }

    public IKit getKit(String name) {
        for (IKit kit : kits)
            if (kit.getName().equalsIgnoreCase(name))
                return kit;
        return null;
    }

    public void setKit(Player p, String name) throws CloneNotSupportedException {
        IKit k = getKit(name);
        if (k == null) return;
        p.getInventory().clear();
        p.getInventory().setArmorContents(new ItemStack[]{new ItemStack(Material.LEATHER_BOOTS), new ItemStack(Material.LEATHER_LEGGINGS), new ItemStack(Material.LEATHER_CHESTPLATE), k.getIcon()});
        p.getInventory().setItemInOffHand(null);
        p.getInventory().setItem(0, k.getActiv().getItemStack());
        p.getInventory().setItem(1, k.getPassiv().getItemStack());
        plugin.getPlayerManager().onKitChoose(p, k);
    }
}
