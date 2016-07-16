package de.doctorintro.wizardbrawl.spells;

import de.doctorintro.wizardbrawl.WizardBrawl;
import de.doctorintro.wizardbrawl.utils.ItemFactory;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashSet;

/**
 * Created by Doctorintro on 16.07.2016.
 */
public class Weerlig extends Spell{

    private Location loc;
    private WizardBrawl plugin;

    public Weerlig(ItemFactory spellfactory, String name, boolean active, int duration, int refill) {
        super(new ItemFactory(new ItemStack(Material.BLAZE_ROD)), "Weerlig", true, 15, 52);
    }

    @Override
    public void onRepeat(Player target) {
        int i = plugin.getRandom().nextInt(5);
        if(3 <= i || i <= 5){
            loc.getWorld().strikeLightning( loc.clone().add( i * 2 - Math.random(), 0, i / 2 + Math.random() ) );
        }
    }

    @Override
    public void onFinish(Player target) {

    }

    @Override
    public void onStart(Player target) {
        loc = target.getTargetBlock(new HashSet<Material>(), 50).getLocation();
    }
}
