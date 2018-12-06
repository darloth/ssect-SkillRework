package skillrework.campaign.skills;

import com.fs.starfarer.api.characters.ShipSkillEffect;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;

public class Helmsmanship {

    public static float PERSONAL_ACCELERATION_BONUS = 40f;
    public static float FLEET_ACCELERATION_BONUS = 10f;
    public static float PERSONAL_SPEED_BONUS = 8f;
    public static float FLEET_SPEED_BONUS = 2f;
    public static float PERSONAL_ZERO_FLUX_LEVEL = 5f; //but not for carriers
    public static float FLEET_ZERO_FLUX_LEVEL = 1f;



    public static class Level1p implements ShipSkillEffect {

        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getAcceleration().modifyPercent(id, PERSONAL_ACCELERATION_BONUS);
            stats.getDeceleration().modifyPercent(id, PERSONAL_ACCELERATION_BONUS);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getAcceleration().unmodify(id);
            stats.getDeceleration().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(PERSONAL_ACCELERATION_BONUS) + "% acceleration";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.PILOTED_SHIP;
        }
    }
    public static class Level1f implements ShipSkillEffect {

        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getAcceleration().modifyPercent(id, FLEET_ACCELERATION_BONUS);
            stats.getDeceleration().modifyPercent(id, FLEET_ACCELERATION_BONUS);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getAcceleration().unmodify(id);
            stats.getDeceleration().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(FLEET_ACCELERATION_BONUS) + "% acceleration";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.ALL_SHIPS;
        }
    }

    public static class Level2p implements ShipSkillEffect {
        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getMaxSpeed().modifyPercent(id, PERSONAL_SPEED_BONUS);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getMaxSpeed().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(PERSONAL_SPEED_BONUS) + "% top speed";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.PILOTED_SHIP;
        }
    }
    public static class Level2f implements ShipSkillEffect {
        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getMaxSpeed().modifyPercent(id, FLEET_SPEED_BONUS);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getMaxSpeed().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(FLEET_SPEED_BONUS) + "% top speed";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.ALL_SHIPS;
        }
    }

    public static class Level3p implements ShipSkillEffect {

        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            if(stats.getNumFighterBays().getModifiedValue() > 0)
            {
                // Carriers do not get the full bonus.
                stats.getZeroFluxMinimumFluxLevel().modifyFlat(id, FLEET_ZERO_FLUX_LEVEL * 0.01f);
            }
            else
            {
                stats.getZeroFluxMinimumFluxLevel().modifyFlat(id, PERSONAL_ZERO_FLUX_LEVEL * 0.01f);
            }
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getZeroFluxMinimumFluxLevel().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "0-flux speed boost activated at up to " + (int)(PERSONAL_ZERO_FLUX_LEVEL) + "% flux (non-carriers only)";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.PILOTED_SHIP;
        }
    }
    public static class Level3f implements ShipSkillEffect {

        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getZeroFluxMinimumFluxLevel().modifyFlat(id, FLEET_ZERO_FLUX_LEVEL * 0.01f);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getZeroFluxMinimumFluxLevel().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "0-flux speed boost activated at up to " + (int)(FLEET_ZERO_FLUX_LEVEL) + "% flux";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.ALL_SHIPS;
        }
    }

}

