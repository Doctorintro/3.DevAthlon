package de.doctorintro.wizardbrawl.listener;

import de.doctorintro.wizardbrawl.WizardBrawl;
import de.doctorintro.wizardbrawl.player.IPlayer;
import de.doctorintro.wizardbrawl.utils.ScoreboardUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 * Created by Doctorintro on 17.07.2016.
 */
public class PlayerDeathListener implements Listener{

    private WizardBrawl plugin;

    public PlayerDeathListener(WizardBrawl plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        Player p = e.getEntity();
        e.setKeepInventory(true);
        e.setDeathMessage("");
        e.setKeepLevel(true);
        IPlayer wp = plugin.getPlayerManager().getPlayer(p);
        wp.setKillStreak(0);
        if(p.getKiller() != null){
            IPlayer wpk = plugin.getPlayerManager().getPlayer(p.getKiller());
            int kills = wpk.getKillStreak();
            kills++;
            wpk.setKillStreak(kills);
            wp.setTarget(p.getKiller());
        }
        plugin.getPlayerManager().sort();
        plugin.getPlayerManager().getPlayerList().forEach(all -> { ScoreboardUtil.createScoreboard(all); });
    }

}
