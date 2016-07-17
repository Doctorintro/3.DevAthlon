package de.doctorintro.wizardbrawl.manager;

import de.doctorintro.wizardbrawl.WizardBrawl;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Doctorintro on 16.07.2016.
 */
public class LocationManager {

    private WizardBrawl plugin;

    private File file;
    private FileConfiguration cfg;
    private final String CODEC;

    private List<Location> spawns;
    private Location spawn;

    /**
     * TODO: Set variable
     */

    public LocationManager(WizardBrawl plugin) {
        CODEC = "[$&*}";
        file = new File("plugins/WizardBrawl", "locations.yml");
        cfg = YamlConfiguration.loadConfiguration(file);
        this.spawns = new LinkedList<>();
        loadLocations();
        /**this.spawn = new Location(Bukkit.getWorlds().get(0), -699, 1, -79, 90, 90);
        spawns.add(new Location(Bukkit.getWorlds().get(0), -738, 4, -28, 0, 0));
        spawns.add(new Location(Bukkit.getWorlds().get(0), -708, 4, -39, 0, 0));
        spawns.add(new Location(Bukkit.getWorlds().get(0), -691, 4, -2, 90, 0));**/
    }

    public Location getRandomSpawnLocation(){
        return spawns.get(plugin.getRandom().nextInt(spawns.size()));
    }

    public Location getSpawnLocation(){
        return spawn;
    }

    public void setSpawn(Location spawn) {
        this.spawn = spawn;
    }

    public void addSpawn(Location loc){
        spawns.add(loc);
    }

    public void addLocation(Location location){
        spawns.add(location);
    }

    public void safeLocations() throws IOException {
        cfg.set("locations", spawns);
        cfg.set("spawn", spawn);
        cfg.save(file);
    }

    public void loadLocations(){
        Object list = cfg.get("locations");
        if(list != null) spawns = (List<Location>) list;
        Object loc = cfg.get("spawn");
        if(loc != null)spawn = (Location) loc;
    }
}
