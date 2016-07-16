package de.doctorintro.wizardbrawl.manager;

import de.doctorintro.wizardbrawl.WizardBrawl;
import de.doctorintro.wizardbrawl.kit.IKit;
import de.doctorintro.wizardbrawl.player.IPlayer;
import de.doctorintro.wizardbrawl.player.WizardPlayer;
import org.bukkit.entity.Player;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Doctorintro on 16.07.2016.
 */
public class PlayerManager {

    private WizardBrawl plugin;

    private List<IPlayer> playerList;

    public PlayerManager(WizardBrawl plugin) {
        this.plugin = plugin;
        this.playerList = new LinkedList<>();
    }

    public void onKitChoose(Player p, IKit kit) throws CloneNotSupportedException {
        playerList.add(new WizardPlayer(kit, p));
    }

    public IPlayer getPlayer(Player p){
        for (IPlayer iPlayer : playerList) {
            if (iPlayer.getPlayer().equals(p)) {
                return iPlayer;
            }
        }
        return null;
    }
}
