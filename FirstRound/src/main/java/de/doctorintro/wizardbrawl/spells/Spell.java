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
    public Player player;
    private int duration, refill;
    private SpellTask task;

    public Spell(ItemFactory spellfactory, String name, boolean active, int duration, int refill) {
        this.spell = spellfactory.setDisplayName( (active ? "§5" : "§b") + name).build();
        this.name = name;
        this.duration = duration;
        this.refill = refill;
        this.task = new SpellTask(this);
    }

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
    public int getDifferent(int i) {
        int r = i - task.getRunning();
        return r < 0 ? 0 : r;
    }

    @Override
    public ItemStack getItemStack() { return spell; }

    @Override
    public Player getTarget() {
        return player; }

    @Override
    public void onActive(Player player){
        this.player = player;
        task = new SpellTask(this);
        task.go();
        onStart(player);
    }

    @Override
    public SpellTask getTask() { return task; }

    @Override
    public Object cloned() throws CloneNotSupportedException {
        return super.clone();
    }
}
