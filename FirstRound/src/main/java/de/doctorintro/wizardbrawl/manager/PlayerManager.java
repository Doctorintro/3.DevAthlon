package de.doctorintro.wizardbrawl.manager;

import de.doctorintro.wizardbrawl.WizardBrawl;
import de.doctorintro.wizardbrawl.kit.IKit;
import de.doctorintro.wizardbrawl.player.IPlayer;
import de.doctorintro.wizardbrawl.player.WizardPlayer;
import de.doctorintro.wizardbrawl.spells.ISpell;
import de.doctorintro.wizardbrawl.utils.Actionbar;
import de.doctorintro.wizardbrawl.utils.ScoreboardUtil;
import de.doctorintro.wizardbrawl.utils.SortKillStreaks;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Doctorintro on 16.07.2016.
 */
public class PlayerManager {

    private WizardBrawl plugin;
    private BukkitTask task;

    private List<IPlayer> playerList;

    public PlayerManager(WizardBrawl plugin) {
        this.plugin = plugin;
        this.playerList = new LinkedList<>();
        task = Bukkit.getScheduler().runTaskTimerAsynchronously(plugin,() -> {
            if(!playerList.isEmpty()){
                playerList.forEach(p -> {
                    Actionbar.sendMessage(analysSpell(p.getActiv()) + " §r | " + analysSpell(p.getPassiv()), p.getPlayer()); });
            }
        } ,0 , 20);
    }

    public void onKitChoose(Player p, IKit kit) throws CloneNotSupportedException {
        playerList.add(new WizardPlayer(kit, p));
        sort();
        playerList.forEach(all -> { ScoreboardUtil.createScoreboard(all); });
    }

    public IPlayer getPlayer(Player p){
        for (IPlayer iPlayer : playerList) {
            if (iPlayer.getPlayer().equals(p)) {
                return iPlayer;
            }
        }
        return null;
    }

    private String analysSpell(ISpell spell){
        String display = spell.getDisplayName();
        boolean isRunning = spell.getTask().isRunnig();
        int duration = spell.getDifferent(spell.getDuration());
        int refill = spell.getDifferent(spell.getRefillDuration());
        return display + (isRunning ? " §aWirkung: §e" + duration + "s §aRefill: §e" + refill + "s" : " §aBereit");
    }

    public void sort(){
        if(playerList != null && playerList.size() > 1) Collections.sort(playerList, new SortKillStreaks());
    }

    public List<IPlayer> getPlayerList() {
        return playerList;
    }
}
