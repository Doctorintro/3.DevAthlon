package de.doctorintro.wizardbrawl.command;

import de.doctorintro.wizardbrawl.WizardBrawl;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

/**
 * Created by Doctorintro on 16.07.2016.
 */
public class WizardCommand implements CommandExecutor{

    private WizardBrawl plugin;

    public WizardCommand(WizardBrawl plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(!(sender instanceof Player)) return false;
        Player p = (Player) sender;
        if(!p.isOp()) return false;
        if(args.length == 1){
            if(args[0].equalsIgnoreCase("spawn")){
                plugin.getLocationManager().setSpawn(p.getLocation());
                p.sendMessage("§5Spawn wurde gesetzt nutze nun: /w safe");
            }else if(args[0].equalsIgnoreCase("location")){
                plugin.getLocationManager().addSpawn(p.getLocation());
                p.sendMessage("§5Location wurde gesetzt nutze nun: /w safe");
            }else if(args[0].equalsIgnoreCase("safe")){
                try {
                    plugin.getLocationManager().safeLocations();
                    p.sendMessage("§5Die Locations wurden §aerfolgreich §5gespeichert.");
                } catch (IOException e) {
                    p.sendMessage("§5Die Locations konnten §cnicht erfolgreich §5gespeichert werden.");
                    e.printStackTrace();
                }
            }else {
                sendHelp(p);
            }
        }else{
            sendHelp(p);
        }
        return true;
    }

    private void sendHelp(Player p){
        p.sendMessage("§5/w spawn §a| Setz den Spawn für die Kitauswähler");
        p.sendMessage("§5/w location §a| Fügt einen neue Kampflocation hinzu");
    }
}
