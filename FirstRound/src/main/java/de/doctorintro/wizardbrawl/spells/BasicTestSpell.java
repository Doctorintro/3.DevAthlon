package de.doctorintro.wizardbrawl.spells;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Created by Doctorintro on 16.07.2016.
 */
public class BasicTestSpell extends Spell{

    public BasicTestSpell() {
        super(new ItemStack(Material.DIAMOND), "GLOWING", 20, 50);
        System.out.print(getDuration()+"");
    }

    @Override
    public void onFinish(Player target) {
        ItemStack offhand = target.getInventory().getItemInOffHand().clone();
        target.getInventory().setItemInOffHand(new ItemStack(Material.AIR));
        target.getInventory().addItem(offhand);
    }

    @Override
    public void onStart(Player target) {
        target.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 20, 10));
    }
}
