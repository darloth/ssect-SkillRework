package skillrework.campaign;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.CampaignUIAPI;
import com.fs.starfarer.api.campaign.CoreUITabId;
import com.fs.starfarer.api.campaign.listeners.CampaignInputListener;
import com.fs.starfarer.api.characters.MutableCharacterStatsAPI;
import com.fs.starfarer.api.characters.PersonAPI;
import com.fs.starfarer.api.input.InputEventAPI;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Darloth
 * Date: 07/12/2018
 * Time: 14:35
 */

public class SkillReworkAptitudeUpdaterListener implements CampaignInputListener {

    private static final int POINTS_PER_APTITUDE = 4;

    @Override
    public int getListenerInputPriority() {
        return 9000;
    }

    @Override
    public void processCampaignInputPreCore(List<InputEventAPI> events) {
//        final CampaignUIAPI ui = Global.getSector().getCampaignUI();

        // TODO: Make work when docked.
        CoreUITabId currentCoreTab = Global.getSector().getCampaignUI().getCurrentCoreTab();
        if (currentCoreTab == CoreUITabId.CHARACTER) {

            float numCombatLevels = 0;
            float numLeadershipLevels = 0;
            float numTechnologyLevels = 0;
            float numIndustryLevels = 0;

            PersonAPI player = Global.getSector().getPlayerPerson();
            List<MutableCharacterStatsAPI.SkillLevelAPI> skillsCopy = player.getStats().getSkillsCopy();
            for (MutableCharacterStatsAPI.SkillLevelAPI skillLevel : skillsCopy)
            {
                if(skillLevel.getSkill().isAptitudeEffect()) {
                    continue;
                }

                String governingAptitudeId = skillLevel.getSkill().getGoverningAptitudeId();
                switch (governingAptitudeId)
                {
                    case "combat":
                        numCombatLevels += skillLevel.getLevel();
                        break;
                    case "leadership":
                        numLeadershipLevels += skillLevel.getLevel();;
                        break;
                    case "technology":
                        numTechnologyLevels += skillLevel.getLevel();;
                        break;
                    case "industry":
                        numIndustryLevels += skillLevel.getLevel();;
                        break;
                }
            }

            float combatAptLevel = Math.max(1, Math.min(3, (int)Math.floor(1f + (numCombatLevels) / POINTS_PER_APTITUDE)));
            float leadershipAptLevel = Math.max(1, Math.min(3, (int)Math.floor(1f + (numLeadershipLevels) / POINTS_PER_APTITUDE)));
            float technologyAptLevel = Math.max(1, Math.min(3, (int)Math.floor(1f + (numTechnologyLevels) / POINTS_PER_APTITUDE)));
            float industryAptLevel = Math.max(1, Math.min(3, (int)Math.floor(1f + (numIndustryLevels) / POINTS_PER_APTITUDE)));


            if(combatAptLevel < player.getStats().getAptitudeLevel("combat"))
            {
                player.getStats().addPoints((int)(player.getStats().getAptitudeLevel("combat") - combatAptLevel));
            }

            if(leadershipAptLevel < player.getStats().getAptitudeLevel("leadership"))
            {
                player.getStats().addPoints((int)(player.getStats().getAptitudeLevel("leadership") - leadershipAptLevel));
            }

            if(technologyAptLevel < player.getStats().getAptitudeLevel("technology"))
            {
                player.getStats().addPoints((int)(player.getStats().getAptitudeLevel("technology") - technologyAptLevel));
            }

            if(industryAptLevel < player.getStats().getAptitudeLevel("industry"))
            {
                player.getStats().addPoints((int)(player.getStats().getAptitudeLevel("industry") - industryAptLevel));
            }

            player.getStats().setAptitudeLevel("combat", combatAptLevel);
            player.getStats().setAptitudeLevel("leadership", leadershipAptLevel);
            player.getStats().setAptitudeLevel("technology", technologyAptLevel);
            player.getStats().setAptitudeLevel("industry", industryAptLevel);
        }
    }

    @Override
    public void processCampaignInputPreFleetControl(List<InputEventAPI> events) {
    }

    @Override
    public void processCampaignInputPostCore(List<InputEventAPI> events) {
    }
}
