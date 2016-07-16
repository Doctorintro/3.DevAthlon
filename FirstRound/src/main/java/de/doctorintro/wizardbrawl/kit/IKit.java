package de.doctorintro.wizardbrawl.kit;


import de.doctorintro.wizardbrawl.spells.Spell;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Doctorintro on 16.07.2016.
 */
public interface IKit {

    public String getName();
    public ItemStack getIcon();
    public Spell getActiv();
    public Spell getPassiv();

}
