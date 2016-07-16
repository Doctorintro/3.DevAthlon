package de.doctorintro.wizardBrawl;

import de.doctorintro.wizardBrawl.manager.InventoryManager;
import de.doctorintro.wizardBrawl.manager.KitManager;
import de.doctorintro.wizardBrawl.manager.LocationManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

/**
 * Created by Doctorintro on 16.07.2016.
 */
public class WizardBrawl extends JavaPlugin{

    private LocationManager locationManager;
    private KitManager kitManager;
    private InventoryManager inventoryManager;

    private Random random;

    public void onEnable() {
        loadManager();
    }

    private void loadManager() {
        locationManager = new LocationManager(this);
        kitManager = new KitManager();
        inventoryManager = new InventoryManager(this);
    }

    public void onDisable() {

    }

    public Random getRandom() {
        return random;
    }

    public InventoryManager getInventoryManager() {
        return inventoryManager;
    }

    public LocationManager getLocationManager() {
        return locationManager;
    }

    public KitManager getKitManager() { return kitManager; }
}
