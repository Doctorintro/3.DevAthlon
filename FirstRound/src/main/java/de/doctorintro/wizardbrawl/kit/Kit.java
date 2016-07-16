package de.doctorintro.wizardbrawl.kit;

import de.doctorintro.wizardbrawl.spells.Spell;
import de.doctorintro.wizardbrawl.utils.ItemFactory;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Doctorintro on 16.07.2016.
 */
public class Kit implements IKit{

    private String name;
    private ItemStack icon;
    private Spell activ, passiv;

    public Kit(String name, int subid, ChatColor cc, Spell acivItem, Spell passivItem) {
        this.name = name;
        icon = new ItemFactory(new ItemStack(Material.STAINED_CLAY, 1, (short) subid)).setDisplayName(cc + name).build();
        activ = acivItem;
        passiv = passivItem;
    }

    @Override
    public String getName() { return name; }

    @Override
    public ItemStack getIcon() {
        return icon;
    }

    @Override
    public Spell getActiv() {
        return activ;
    }

    @Override
    public Spell getPassiv() {
        return passiv;
    }
}
