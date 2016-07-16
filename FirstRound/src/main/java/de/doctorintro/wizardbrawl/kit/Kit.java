package de.doctorintro.wizardbrawl.kit;

import de.doctorintro.wizardbrawl.utils.ItemFactory;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Doctorintro on 16.07.2016.
 */
public class Kit implements IKit{

    private String name;
    public ItemStack icon, activ, passiv;

    public Kit(String name, Color color, ChatColor cc, ItemFactory acivItem, ItemFactory passivItem) {
        this.name = name;
        icon = new ItemFactory(new ItemStack(Material.LEATHER_HELMET)).setDisplayName(cc + name).setLeatherColor(color).build();
        activ = acivItem.build();
        passiv = passivItem.build();
    }

    @Override
    public String getName() { return name; }

    @Override
    public ItemStack getIcon() {
        return icon;
    }

    @Override
    public ItemStack getActiv() {
        return activ;
    }

    @Override
    public ItemStack getPassiv() {
        return passiv;
    }
}
