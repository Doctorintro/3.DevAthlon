package de.doctorintro.wizardbrawl.spells;

import de.doctorintro.wizardbrawl.utils.ItemFactory;
import de.doctorintro.wizardbrawl.utils.Particle;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Doctorintro on 17.07.2016.
 */
public class Spoed extends Spell{

    public Spoed() {
        super(new ItemFactory( new ItemStack(Material.COAL)), "Spoed", true, 2, 15);
    }

    @Override
    public void onFinish(Player target) {

    }

    @Override
    public void onRefill(Player target) {

    }

    @Override
    public void onRepeat(Player target) {
        Bukkit.getOnlinePlayers().forEach(p -> {
            Particle.sendParticle(p, target.getLocation().clone().add(0, 0.3, 0), "enchantmenttable", 10);});
    }

    @Override
    public void onStart(Player target) {
        target.setVelocity(target.getLocation().getDirection().multiply(target.getWalkSpeed()*10));
    }
}
