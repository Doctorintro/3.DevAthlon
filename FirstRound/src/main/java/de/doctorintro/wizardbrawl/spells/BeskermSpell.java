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
        ItemStack offhand = target.getInventory().getItemInOffHand().clone();
        target.getInventory().setItemInOffHand(new ItemStack(Material.AIR));
        target.getInventory().addItem(offhand);
    }

    @Override
    public void onRepeat(Player target) {
        target.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20*2, 2, true, true));
    }

    @Override
    public void onStart(Player target) {

    }
}
