package de.doctorintro.wizardbrawl.spells;

import de.doctorintro.wizardbrawl.utils.ItemFactory;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Doctorintro on 16.07.2016.
 */
public abstract class Spell implements ISpell{

    private ItemStack spell;
    private String name;
    private Player target;
    private int duration, refill;

    public Spell(ItemFactory spellfactory, String name, boolean activ, int duration, int refill) {
        this.spell = spellfactory.setDisplayName( (activ ? "§c" : "§b") + name).build();
        this.name = name;
        this.duration = duration;
        this.refill = refill;
    }

    private SpellTask task;

    @Override
    public Material getType() {
        return spell.getType();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDisplayName() {
        return spell.getItemMeta().getDisplayName();
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public int getRefillDuration() {
        return refill;
    }

    @Override
    public ItemStack getItemStack() { return spell; }

    @Override
    public Player getTarget() { return target; }

    @Override
    public void onActive(Player target){
        task = new SpellTask(this);
        this.target = target;
    }

    @Override
    public SpellTask getTask() { return task; }

    @Override
    public Object cloned() throws CloneNotSupportedException {
        return super.clone();
    }


    public abstract void onStart(Player target);
}
