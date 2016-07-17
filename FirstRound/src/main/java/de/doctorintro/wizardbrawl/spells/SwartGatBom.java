package de.doctorintro.wizardbrawl.spells;

import de.doctorintro.wizardbrawl.WizardBrawl;
import de.doctorintro.wizardbrawl.utils.ItemFactory;
import de.doctorintro.wizardbrawl.utils.Particle;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Doctorintro on 17.07.2016.
 */
public class SwartGatBom extends Spell{

    private WizardBrawl plugin;
    private Item item;

    public SwartGatBom(WizardBrawl plugin) {
        super(new ItemFactory( new ItemStack(Material.POISONOUS_POTATO)), "SwartGatBom", false, 10, 43);
        this.plugin = plugin;
    }

    @Override
    public void onFinish(Player target) {
        Bukkit.getOnlinePlayers().forEach(p -> {
            Particle.sendParticle(p, item.getLocation(), "hugeexplosion", 5 + WizardBrawl.getRandom().nextInt(2));
            if(p.getLocation().distanceSquared(item.getLocation()) <= 5){
                p.damage(5);
                p.playSound(item.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 2, 2);
            }
        });
        item.remove();
    }

    @Override
    public void onRefill(Player target) {
        target.getInventory().addItem(getItemStack());
    }

    @Override
    public void onRepeat(Player target) {
        Bukkit.getOnlinePlayers().forEach(p -> {
            Particle.sendParticle(p, item.getLocation(), "smoke", 5 + WizardBrawl.getRandom().nextInt(2));
            if(p.getLocation().distance(item.getLocation()) < 5){
                p.playSound(item.getLocation(), Sound.ENTITY_CREEPER_PRIMED, 1, 1);
            }
        });
    }

    @Override
    public void onStart(Player target) {
        item = target.getWorld().dropItem(target.getLocation(), getItemStack());
        item.setVelocity(target.getLocation().getDirection().multiply(1.3));
        Bukkit.getScheduler().runTaskLater(plugin, ()-> target.getInventory().setItemInOffHand(new ItemStack(Material.AIR)), 5);
    }
}
