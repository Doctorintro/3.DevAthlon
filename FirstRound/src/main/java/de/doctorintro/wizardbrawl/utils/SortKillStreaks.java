package de.doctorintro.wizardbrawl.utils;

import de.doctorintro.wizardbrawl.player.IPlayer;

import java.util.Comparator;

/**
 * Created by Doctorintro on 17.07.2016.
 */
public class SortKillStreaks implements Comparator<IPlayer>{

    @Override
    public int compare(IPlayer p1, IPlayer p2) {
        return p2.getKillStreak() - p1.getKillStreak();
    }
}
