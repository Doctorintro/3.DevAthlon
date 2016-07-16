package de.doctorintro.wizardBrawl;

import de.doctorintro.wizardBrawl.listener.InventoryClickListener;
import de.doctorintro.wizardBrawl.listener.InventoryCloseListener;
import de.doctorintro.wizardBrawl.listener.ListenerToCancel;
import de.doctorintro.wizardBrawl.listener.PlayerJoinListener;
import de.doctorintro.wizardBrawl.manager.InventoryManager;
import de.doctorintro.wizardBrawl.manager.KitManager;
import de.doctorintro.wizardBrawl.manager.LocationManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
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
        registerListener();
    }

    private void registerListener() {
        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new InventoryClickListener(this), this);
        manager.registerEvents(new InventoryCloseListener(this), this);
        manager.registerEvents(new ListenerToCancel(), this);
        manager.registerEvents(new PlayerJoinListener(this), this);
    }

    private void loadManager() {
        locationManager = new LocationManager(this);
        kitManager = new KitManager();
        inventoryManager = new InventoryManager(this);
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
