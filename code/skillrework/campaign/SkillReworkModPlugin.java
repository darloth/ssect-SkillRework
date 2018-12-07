package skillrework.campaign;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.characters.MutableCharacterStatsAPI;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Darloth
 * Date: 06/12/2018
 * Time: 23:16
 */
public class SkillReworkModPlugin extends BaseModPlugin {

//    @Override
//    public void onApplicationLoad() throws Exception {
//        Global.getSector().addTransientScript(new SkillReworkAptitudeUpdater());
//    }


    @Override
    public void onNewGame() {
        Global.getSector().getListenerManager().addListener(new SkillReworkAptitudeUpdaterListener(), true);

        RefundPlayerSkillpoints();
    }

    @Override
    public void onGameLoad(boolean newGame) {
        if (!newGame)
        {
            Global.getSector().getListenerManager().addListener(new SkillReworkAptitudeUpdaterListener(), true);

        }
    }

    private void RefundPlayerSkillpoints() {
        // Most of this entire method copied wholesale from LazyWizard's ConsoleCommands Respec command.
        // Thankyou LazyWizard, your source is an inspiration to us all, and your dedication is amazing and appreciated!

        // Refund aptitudes
        final MutableCharacterStatsAPI player
                = Global.getSector().getPlayerPerson().getStats();
        for (final String aptitude : Global.getSettings().getAptitudeIds())
        {
            final int total = (int) player.getAptitudeLevel(aptitude);
            if (total > 0)
            {
                player.setAptitudeLevel(aptitude, 0f);
                player.addPoints(total);
            }
        }

        // Refund skills
        for (final String skill : Global.getSettings().getSortedSkillIds())
        {
            // Ignore aptitudes (included in list because officers treat them as skills)
            if (Global.getSettings().getSkillSpec(skill).isAptitudeEffect())
            {
                continue;
            }

            final int total = (int) player.getSkillLevel(skill);
            if (total > 0)
            {
                player.setSkillLevel(skill, 0f);
                player.addPoints(total);
            }
        }

        player.refreshCharacterStatsEffects();
    }

}
