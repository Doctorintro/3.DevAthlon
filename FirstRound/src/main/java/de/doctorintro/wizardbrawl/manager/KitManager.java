package de.doctorintro.wizardbrawl.manager;

import de.doctorintro.wizardbrawl.WizardBrawl;
import de.doctorintro.wizardbrawl.kit.IKit;
import de.doctorintro.wizardbrawl.kit.Kit;
import de.doctorintro.wizardbrawl.spells.BeskermSpell;
import de.doctorintro.wizardbrawl.spells.Spoed;
import de.doctorintro.wizardbrawl.spells.SwartGatBom;
import de.doctorintro.wizardbrawl.spells.WeerligSpell;
import de.doctorintro.wizardbrawl.utils.ItemFactory;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Doctorintro on 16.07.2016.
 */
public class KitManager {

    private WizardBrawl plugin;
    private List<IKit> kits;
    private Armor armor;

    public KitManager(WizardBrawl plugin) {
        this.plugin = plugin;
        kits = new LinkedList<>();
        armor = new Armor();
        loadKits();
    }

    private void loadKits() {
        kits.add(new Kit("Afrikaanse", 12, ChatColor.GOLD, new WeerligSpell(), new BeskermSpell()));
        kits.add(new Kit("Speedy", 3, ChatColor.AQUA, new Spoed(), new SwartGatBom()));
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
        p.teleport(plugin.getLocationManager().getRandomSpawnLocation().clone().add(0, 0.3, 0));
        p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 10, 3));
        p.getInventory().clear();
        p.getInventory().setArmorContents(new ItemStack[]{armor.getBoots(), armor.getLeggins(), armor.getChestplate(), k.getIcon()});
        p.getInventory().setItemInOffHand(null);
        p.getInventory().setItem(0, k.getActiv().getItemStack());
        p.getInventory().setItem(1, k.getPassiv().getItemStack());
        plugin.getPlayerManager().onKitChoose(p, k);
    }

    private class Armor{
        private ItemStack boots, leggins, chestplate;

        public Armor() {
            boots = new ItemFactory(new ItemStack(Material.LEATHER_BOOTS)).setUnbreakable().build();
            leggins = new ItemFactory(new ItemStack(Material.LEATHER_LEGGINGS)).setUnbreakable().build();
            chestplate = new ItemFactory(new ItemStack(Material.LEATHER_CHESTPLATE)).setUnbreakable().build();
        }

        public ItemStack getBoots() {
            return boots;
        }

        public ItemStack getLeggins() {
            return leggins;
        }

        public ItemStack getChestplate() {
            return chestplate;
        }
    }
}
