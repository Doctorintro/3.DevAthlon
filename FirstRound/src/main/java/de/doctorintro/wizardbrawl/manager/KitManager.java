package de.doctorintro.wizardbrawl.manager;

import de.doctorintro.wizardbrawl.kit.IKit;
import de.doctorintro.wizardbrawl.kit.Kit;
import de.doctorintro.wizardbrawl.utils.ItemFactory;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Doctorintro on 16.07.2016.
 */
public class KitManager {

    private List<IKit> kits;
    private HashMap<Player, IKit> players;

    public KitManager() {
        kits = new LinkedList<>();
        players = new LinkedHashMap<>();
        loadKits();
    }

    private void loadKits(){
        kits.add( new Kit("Test", 5, ChatColor.AQUA, new ItemFactory( new ItemStack(Material.STICK) ), new ItemFactory(new ItemStack(Material.DIAMOND)) ) );
    }

    public List<IKit> getKits() {
        return kits;
    }

    public IKit getKit(Player p){
        try {
            return players.get(p);
        } catch(Exception ex) {
            return null;
        }
    }

    public IKit getKit(String name){
        for (IKit kit : kits)
            if (kit.getName().equalsIgnoreCase(name))
                return kit;
        return null;
    }

    public void setKit(Player p, String name){
        IKit k = getKit(name);
        if(k == null)return;
        if(!players.containsKey(p) || (getKit(p) != null && !getKit(p).getName().equals(k.getName()))){
            p.getInventory().clear();
            p.getInventory().setArmorContents(new ItemStack[] { new ItemStack(Material.LEATHER_BOOTS), new ItemStack(Material.LEATHER_LEGGINGS), new ItemStack(Material.LEATHER_CHESTPLATE), k.getIcon()});
            p.getInventory().setItemInOffHand(null);
            p.getInventory().setItem(0, k.getActiv());
            p.getInventory().setItem(1, k.getPassiv());
            if(players.containsKey(p)) players.remove(p);
            players.put(p, k);
        }
    }
}
