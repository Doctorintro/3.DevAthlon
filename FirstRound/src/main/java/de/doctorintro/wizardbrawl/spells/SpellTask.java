package de.doctorintro.wizardbrawl.spells;

import de.doctorintro.wizardbrawl.WizardBrawl;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

/**
 * Created by Doctorintro on 16.07.2016.
 */
public class SpellTask extends BukkitRunnable{

    private ISpell spell;
    private int running;
    private BukkitTask task;
    private boolean isRunnig;

    public SpellTask(ISpell spell) {
        running = 0;
        this.spell = spell;

    }

    public void go(){
        running = 0;
        task = runTaskTimer(WizardBrawl.getPlugin(), 0, 20);
    }

    @Override
    public void run() {
        if (isRunnig == false) isRunnig = true;
        if(running >= spell.getRefillDuration()) {
            task.cancel();
            isRunnig = false;
            spell.onFinish(spell.getTarget());
        }else if(running <= spell.getDuration()){
            spell.onRepeat(spell.getTarget());
        }
        running++;
    }

    public boolean isRunnig() {
        return isRunnig;
    }

    public int getRunning() { return running; }
}
