package de.doctorintro.wizardbrawl.player;

import de.doctorintro.wizardbrawl.kit.IKit;
import de.doctorintro.wizardbrawl.spells.ISpell;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

/**
 * Created by Doctorintro on 16.07.2016.
 */
public class WizardPlayer implements IPlayer{

    private IKit kit;
    private Player player, target;
    private ISpell active, passive;
    private int killStreak;
    private Team team;

    public WizardPlayer(IKit kit, Player player) throws CloneNotSupportedException {
        this.kit = kit;
        this.player = player;
        this.active = (ISpell) kit.getActiv().cloned();
        this.passive = (ISpell) kit.getPassiv().cloned();
        this.killStreak = 0;
    }

    @Override
    public ISpell getActiv() {
        return active;
    }

    @Override
    public ISpell getPassiv() {
        return passive;
    }

    @Override
    public IKit getKit() {
        return kit;
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    @Override
    public Player getTarget() {
        return target;
    }

    @Override
    public void setTarget(Player target) {
        this.target = target;
    }

    @Override
    public int getKillStreak() { return killStreak; }

    @Override
    public void setKillStreak(int i) {
        killStreak = i;
    }
}
