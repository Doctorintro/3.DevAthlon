package de.doctorintro.wizardBrawl.manager;

import de.doctorintro.wizardBrawl.kit.IKit;
import de.doctorintro.wizardBrawl.kit.Kit;
import de.doctorintro.wizardBrawl.utils.ItemFactory;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
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
        loadKits();
    }

    private void loadKits(){
        kits.add( new Kit("Test", Color.AQUA, new ItemFactory( new ItemStack(Material.STICK) ), new ItemFactory(new ItemStack(Material.DIAMOND)) ) );
    }

    public List<IKit> getKits() {
        return kits;
    }

    public IKit getKit(Player p){
        return players.get(p);
    }

    public void setKit(Player p, IKit k){
        if(!players.containsKey(p) || !players.get(p).getName().equals(k.getName())){
            p.getInventory().clear();
            p.getInventory().setArmorContents(new ItemStack[] {k.getIcon(), new ItemStack(Material.LEATHER_CHESTPLATE), new ItemStack(Material.LEATHER_LEGGINGS), new ItemStack(Material.LEATHER_BOOTS)});
            p.getInventory().setItemInOffHand(null);
            p.getInventory().setItem(0, k.getActiv());
            p.getInventory().setItem(1, k.getPassiv());
            if(players.containsKey(p)) players.remove(p);
            players.put(p, k);
        }
    }
}
