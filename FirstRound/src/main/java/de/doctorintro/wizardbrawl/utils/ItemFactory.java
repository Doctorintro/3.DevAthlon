package de.doctorintro.wizardbrawl.utils;

import com.google.common.collect.Lists;
import org.bukkit.Color;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.List;

/**
 * Created by Doctorintro on 16.07.2016.
 */
public class ItemFactory {

    public ItemStack itemStack;

    public ItemFactory(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public ItemFactory setDisplayName(String name){
        ItemMeta meta = getItemMeta();
        meta.setDisplayName(name);
        itemStack.setItemMeta(meta);
        return this;
    }

    public ItemFactory setLeatherColor(Color color){
        LeatherArmorMeta meta = (LeatherArmorMeta) getItemMeta();
        meta.setColor(color);
        itemStack.setItemMeta(meta);
        return this;
    }

    public ItemFactory setLore(List<String> lore){
        ItemMeta meta = getItemMeta();
        meta.setLore(lore);
        return this;
    }

    public ItemFactory setUnbreakable() {
        ItemMeta meta = getItemMeta();
        meta.spigot().setUnbreakable(true);
        itemStack.setItemMeta(meta);
        return this;
    }

    public ItemFactory setLore(String ... lore){
        ItemMeta meta = getItemMeta();
        meta.setLore(Lists.newArrayList(lore));
        return this;
    }

    public ItemStack build(){
        return itemStack;
    }

    public ItemMeta getItemMeta(){
        return itemStack.getItemMeta();
    }
}
