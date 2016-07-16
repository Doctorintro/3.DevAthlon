package de.doctorintro.wizardbrawl.spells;

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
    private long start, duration, refill;

    public Spell(ItemStack spell, String name,long duration, long refill) {
        this.spell = spell;
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
    public long getDuration() {
        return duration;
    }

    @Override
    public long getRefillDuration() {
        return refill;
    }

    @Override
    public long getStart() { return start; }

    @Override
    public ItemStack getItemStack() { return spell; }

    @Override
    public Player getTarget() { return target; }

    @Override
    public void onActive(Player Target){
        task = new SpellTask(this);
    }

    @Override
    public SpellTask getTask() { return task; }

    @Override
    public Object cloned() throws CloneNotSupportedException {
        return super.clone();
    }


    public abstract void onStart(Player target);
}
