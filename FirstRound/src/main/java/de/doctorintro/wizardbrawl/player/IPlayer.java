package de.doctorintro.wizardbrawl.player;

import de.doctorintro.wizardbrawl.kit.IKit;
import de.doctorintro.wizardbrawl.spells.ISpell;
import org.bukkit.entity.Player;

/**
 * Created by Doctorintro on 16.07.2016.
 */
public interface IPlayer{

    ISpell getActiv();
    ISpell getPassiv();
    IKit getKit();
    Player getPlayer();
    Player getTarget();
    void setTarget(Player target);
    int getKillStreak();
    void setKillStreak(int i);
}
