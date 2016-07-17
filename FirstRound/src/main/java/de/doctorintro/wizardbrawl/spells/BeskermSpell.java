package de.doctorintro.wizardbrawl.spells;

import de.doctorintro.wizardbrawl.utils.ItemFactory;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Created by Doctorintro on 16.07.2016.
 */
public class BeskermSpell extends Spell{

    public BeskermSpell() {
        super(new ItemFactory(new ItemStack(Material.DIAMOND)).setLore("§bGeneriert ein", "§b§lSchutzschild §r§bfür dich."), "Beskerm", false, 20, 50);
    }

    @Override
    public void onFinish(Player target) {

    }

    @Override
    public void onRefill(Player target) {
        target.getInventory().addItem(getItemStack());
    }

    @Override
    public void onRepeat(Player target) {
        target.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20*2, 2, true, true));
    }

    @Override
    public void onStart(Player target) { target.getInventory().setItemInOffHand(new ItemStack(Material.AIR)); }
}
