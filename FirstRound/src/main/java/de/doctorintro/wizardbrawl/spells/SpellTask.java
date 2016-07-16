package de.doctorintro.wizardbrawl.spells;

import de.doctorintro.wizardbrawl.WizardBrawl;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by Doctorintro on 16.07.2016.
 */
public class SpellTask extends BukkitRunnable{

    private ISpell spell;
    private int running;
    private boolean isRunnig;

    public SpellTask(ISpell spell) {
        running = 0;
        this.spell = spell;
        runTaskTimer(WizardBrawl.getPlugin(), 0, 20);
    }

    @Override
    public void run() {
        if (isRunnig == false) isRunnig = true;
        if(running >= spell.getRefillDuration()) {
            cancel();
            isRunnig = false;
            spell.onFinish(spell.getTarget());
        }else if(running < spell.getDuration()){
            spell.onStart(spell.getTarget());
        }
        running++;
    }

    public boolean isRunnig() {
        return isRunnig;
    }
}
