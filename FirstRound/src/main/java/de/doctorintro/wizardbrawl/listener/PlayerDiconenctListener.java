package de.doctorintro.wizardbrawl.listener;

import de.doctorintro.wizardbrawl.WizardBrawl;
import de.doctorintro.wizardbrawl.player.IPlayer;
import de.doctorintro.wizardbrawl.utils.ScoreboardUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created by Doctorintro on 17.07.2016.
 */
public class PlayerDiconenctListener implements Listener{

    private WizardBrawl plugin;

    public PlayerDiconenctListener(WizardBrawl plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void on(PlayerQuitEvent e){
        e.setQuitMessage("");
        IPlayer wp = plugin.getPlayerManager().getPlayer(e.getPlayer());
        if(wp != null) plugin.getPlayerManager().getPlayerList().remove(wp);
        plugin.getPlayerManager().sort();
        plugin.getPlayerManager().getPlayerList().forEach(all -> { ScoreboardUtil.createScoreboard(all); });
    }

}
