package de.doctorintro.wizardbrawl.player;

import de.doctorintro.wizardbrawl.kit.IKit;
import de.doctorintro.wizardbrawl.spells.ISpell;
import org.bukkit.craftbukkit.v1_10_R1.Overridden;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;

/**
 * Created by Doctorintro on 16.07.2016.
 */
public class WizardPlayer implements IPlayer{

    private IKit kit;
    private Player player;
    private ISpell active, passive;
    private int killStreak;
    private Scoreboard scoreboard;

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

    @Overridden
    public Scoreboard getScoreboard() {
        return scoreboard;
    }

    @Override
    public int getKillStreak() { return killStreak; }
}
