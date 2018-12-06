package skillrework.campaign.skills;

import com.fs.starfarer.api.characters.ShipSkillEffect;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;

public class EvasiveAction {

    public static final float PERSONAL_MANEUVERABILITY_BONUS = 40;
    public static final float FLEET_MANEUVERABILITY_BONUS = 10;
    public static final float PERSONAL_DAMAGE_TO_MODULES_REDUCTION = 45;
    public static final float FLEET_DAMAGE_TO_MODULES_REDUCTION = 10;
    public static final float PERSONAL_EFFECTIVE_ARMOR_BONUS = 40;
    public static final float FLEET_EFFECTIVE_ARMOR_BONUS = 10;


    public static class Level1p implements ShipSkillEffect {

        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getAcceleration().modifyPercent(id, PERSONAL_MANEUVERABILITY_BONUS);
            stats.getDeceleration().modifyPercent(id, PERSONAL_MANEUVERABILITY_BONUS);
            stats.getTurnAcceleration().modifyPercent(id, PERSONAL_MANEUVERABILITY_BONUS * 2f);
            stats.getMaxTurnRate().modifyPercent(id, PERSONAL_MANEUVERABILITY_BONUS);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getAcceleration().unmodify(id);
            stats.getDeceleration().unmodify(id);
            stats.getTurnAcceleration().unmodify(id);
            stats.getMaxTurnRate().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(PERSONAL_MANEUVERABILITY_BONUS) + "% maneuverability";
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
            stats.getAcceleration().modifyPercent(id, FLEET_MANEUVERABILITY_BONUS);
            stats.getDeceleration().modifyPercent(id, FLEET_MANEUVERABILITY_BONUS);
            stats.getTurnAcceleration().modifyPercent(id, FLEET_MANEUVERABILITY_BONUS * 2f);
            stats.getMaxTurnRate().modifyPercent(id, FLEET_MANEUVERABILITY_BONUS);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getAcceleration().unmodify(id);
            stats.getDeceleration().unmodify(id);
            stats.getTurnAcceleration().unmodify(id);
            stats.getMaxTurnRate().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(FLEET_MANEUVERABILITY_BONUS) + "% maneuverability";
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
            stats.getEngineDamageTakenMult().modifyMult(id, 1f - PERSONAL_DAMAGE_TO_MODULES_REDUCTION / 100f);
            stats.getWeaponDamageTakenMult().modifyMult(id, 1f - PERSONAL_DAMAGE_TO_MODULES_REDUCTION / 100f);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getEngineDamageTakenMult().unmodify(id);
            stats.getWeaponDamageTakenMult().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "-" + (int)(PERSONAL_DAMAGE_TO_MODULES_REDUCTION) + "% weapon and engine damage taken";
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
            stats.getEngineDamageTakenMult().modifyMult(id, 1f - FLEET_DAMAGE_TO_MODULES_REDUCTION / 100f);
            stats.getWeaponDamageTakenMult().modifyMult(id, 1f - FLEET_DAMAGE_TO_MODULES_REDUCTION / 100f);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getEngineDamageTakenMult().unmodify(id);
            stats.getWeaponDamageTakenMult().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "-" + (int)(FLEET_DAMAGE_TO_MODULES_REDUCTION) + "% weapon and engine damage taken";
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
            stats.getEffectiveArmorBonus().modifyPercent(id, PERSONAL_EFFECTIVE_ARMOR_BONUS);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getEffectiveArmorBonus().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(PERSONAL_EFFECTIVE_ARMOR_BONUS) + "% armor for damage reduction calculation only";
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
            stats.getEffectiveArmorBonus().modifyPercent(id, FLEET_EFFECTIVE_ARMOR_BONUS);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getEffectiveArmorBonus().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(FLEET_EFFECTIVE_ARMOR_BONUS) + "% armor for damage reduction calculation only";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.ALL_SHIPS;
        }
    }

}
