package de.doctorintro.wizardbrawl.command;

import de.doctorintro.wizardbrawl.WizardBrawl;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Doctorintro on 16.07.2016.
 */
public class WizardCommand implements CommandExecutor{

    private WizardBrawl plugin;

    public WizardCommand(WizardBrawl plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if(!(sender instanceof Player)) return false;
        ((Player)sender).openInventory(plugin.getInventoryManager().getSelectWizard());
        return false;
    }
}
