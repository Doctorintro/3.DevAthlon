package de.doctorintro.wizardbrawl.utils;

import de.doctorintro.wizardbrawl.WizardBrawl;
import de.doctorintro.wizardbrawl.player.IPlayer;
import org.bukkit.Bukkit;
import org.bukkit.scoreboard.*;

/**
 * Created by Doctorintro on 17.07.2016.
 */
public class ScoreboardUtil {

    private static WizardBrawl plugin;

    public static void setPlugin(WizardBrawl wb){
        plugin = wb;
    }

    public static Team createScoreboard(IPlayer player){
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Team team = scoreboard.registerNewTeam("evil");
        team.setPrefix("§c");
        if(player.getTarget() != null) team.addEntry(player.getTarget().getDisplayName());
        updateScore(player, scoreboard);
        return team;
    }

    private static void updateScore(IPlayer player, Scoreboard scoreboard){
        Objective obj = scoreboard.getObjective(DisplaySlot.SIDEBAR);
        if (obj != null) obj.unregister();
        obj = getObjective(scoreboard);
        for(int i = 0; i < 5 && i < plugin.getPlayerManager().getPlayerList().size(); i++){
            IPlayer wp = plugin.getPlayerManager().getPlayerList().get(i);
            Score p = obj.getScore(wp.getPlayer().getDisplayName()+"§a: "+wp.getKillStreak());
            p.setScore(wp.getKillStreak());
        }

        Score dummy = obj.getScore("§l──────────");
        Score you = obj.getScore("§6"+player.getPlayer().getDisplayName()+"§a: "+player.getKillStreak());
        you.setScore(-2);
        dummy.setScore(-1);
        player.getPlayer().setScoreboard(scoreboard);
    }

    private static Objective getObjective(Scoreboard scoreboard){
        Objective obj = scoreboard.registerNewObjective("score", "dummy");
        obj.setDisplayName("§5§lTop 5 KillStreaks");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        return obj;
    }

}
