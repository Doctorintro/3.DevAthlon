package de.doctorintro.wizardbrawl.spells;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Doctorintro on 16.07.2016.
 */
public interface ISpell extends Cloneable{

    Material getType();
    String getName();
    String getDisplayName();
    int getDuration();
    int getRefillDuration();
    int getDifferent(int i);
    ItemStack getItemStack();
    Player getTarget();
    void onActive(Player Target);
    void onStart(Player Target);
    void onRepeat(Player Target);
    void onFinish(Player target);
    void onRefill(Player target);
    SpellTask getTask();
    Object cloned() throws CloneNotSupportedException;
}