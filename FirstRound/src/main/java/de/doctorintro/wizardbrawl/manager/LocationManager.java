package de.doctorintro.wizardbrawl.manager;

import de.doctorintro.wizardbrawl.WizardBrawl;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Doctorintro on 16.07.2016.
 */
public class LocationManager {

    private WizardBrawl plugin;

    private List<Location> spawns;
    private Location spawn;

    /**
     * TODO: Set variable
     */

    public LocationManager(WizardBrawl plugin) {
        this.spawns = new LinkedList<>();
        this.spawn = new Location(Bukkit.getWorlds().get(0), -713, 18, 12, 90, 90);
        spawns.add(new Location(Bukkit.getWorlds().get(0), -738, 4, -28, 0, 0));
        spawns.add(new Location(Bukkit.getWorlds().get(0), -708, 4, -39, 0, 0));
        spawns.add(new Location(Bukkit.getWorlds().get(0), -691, 4, -2, 90, 0));
    }

    public Location getRandomSpawnLocation(){
        return spawns.get(plugin.getRandom().nextInt(spawns.size()));
    }

    public Location getSpawnLocation(){
        return spawn;
    }
}
