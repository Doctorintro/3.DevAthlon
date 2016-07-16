package de.doctorintro.wizardBrawl.manager;

import de.doctorintro.wizardBrawl.WizardBrawl;
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
    }

    public Location getRandomSpawnLocation(){
        return spawns.get(plugin.getRandom().nextInt(spawns.size()));
    }

    public Location getSpawnLocation(){
        return spawn;
    }
}
