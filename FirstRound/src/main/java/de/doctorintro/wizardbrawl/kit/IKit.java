package de.doctorintro.wizardbrawl.kit;


import org.bukkit.inventory.ItemStack;

/**
 * Created by Doctorintro on 16.07.2016.
 */
public interface IKit {

    public String getName();
    public ItemStack getIcon();
    public ItemStack getActiv();
    public ItemStack getPassiv();

}
