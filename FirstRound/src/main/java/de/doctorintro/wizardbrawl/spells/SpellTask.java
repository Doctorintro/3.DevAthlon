package de.doctorintro.wizardbrawl.spells;

import de.doctorintro.wizardbrawl.WizardBrawl;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by Doctorintro on 16.07.2016.
 */
public class SpellTask extends BukkitRunnable{

    private ISpell spell;
    private long duration, refilled;
    private boolean isRunnig;

    public SpellTask(ISpell spell) {
        this.spell = spell;
        this.duration = spell.getStart() + spell.getDuration();
        this.refilled = spell.getStart() + spell.getRefillDuration();
        runTaskTimer(WizardBrawl.getPlugin(), 0, 20);
    }

    @Override
    public void run() {
        if (isRunnig == false) isRunnig = true;
        if(System.currentTimeMillis() >= refilled) {
            cancel();
            spell.onFinish(spell.getTarget());
        }else if(System.currentTimeMillis() < duration){
            isRunnig = false;
            spell.onStart(spell.getTarget());
        }
    }

    public boolean isRunnig() {
        return isRunnig;
    }
}
