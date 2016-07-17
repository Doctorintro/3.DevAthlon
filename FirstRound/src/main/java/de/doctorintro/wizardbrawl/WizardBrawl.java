package de.doctorintro.wizardbrawl;

import de.doctorintro.wizardbrawl.command.WizardCommand;
import de.doctorintro.wizardbrawl.listener.*;
import de.doctorintro.wizardbrawl.manager.InventoryManager;
import de.doctorintro.wizardbrawl.manager.KitManager;
import de.doctorintro.wizardbrawl.manager.LocationManager;
import de.doctorintro.wizardbrawl.manager.PlayerManager;
import de.doctorintro.wizardbrawl.utils.ScoreboardUtil;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

/**
 * Created by Doctorintro on 16.07.2016.
 */
public class WizardBrawl extends JavaPlugin{

    private static Plugin plugin;
    private static Random random;

    private LocationManager locationManager;
    private KitManager kitManager;
    private InventoryManager inventoryManager;
    private PlayerManager playerManager;

    public void onEnable() {
        plugin = this;
        loadManager();
        registerListener();
        registerCommands();
    }

    private void registerCommands() {
        this.getCommand("wizard").setExecutor(new WizardCommand(this));
    }

    private void registerListener() {
        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new EntityDamgeListener(this), this);
        manager.registerEvents(new InventoryClickListener(this), this);
        manager.registerEvents(new InventoryCloseListener(this), this);
        manager.registerEvents(new ItemInteractListener(this), this);
        manager.registerEvents(new ListenerToCancel(), this);
        manager.registerEvents(new OffHandListener(this), this);
        manager.registerEvents(new PlayerDeathListener(this), this);
        manager.registerEvents(new PlayerJoinListener(this), this);
        manager.registerEvents(new PlayerRespawnListener(this), this);
    }

    private void loadManager() {
        random = new Random();
        locationManager = new LocationManager(this);
        kitManager = new KitManager(this);
        inventoryManager = new InventoryManager(this);
        playerManager = new PlayerManager(this);
        ScoreboardUtil.setPlugin(this);
    }

    public static Random getRandom() {
        return random;
    }

    public InventoryManager getInventoryManager() {
        return inventoryManager;
    }

    public LocationManager getLocationManager() {
        return locationManager;
    }

    public KitManager getKitManager() { return kitManager; }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }

    public static Plugin getPlugin() { return plugin; }
}
