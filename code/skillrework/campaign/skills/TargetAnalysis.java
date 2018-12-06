package skillrework.campaign.skills;

import com.fs.starfarer.api.characters.ShipSkillEffect;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;

public class TargetAnalysis {

    public static final float PERSONAL_DAMAGE_TO_MODULES_BONUS = 40;
    public static final float FLEET_DAMAGE_TO_MODULES_BONUS = 10;
    public static final float PERSONAL_DAMAGE_TO_SHIELDS_BONUS = 12.5f;
    public static final float FLEET_DAMAGE_TO_SHIELDS_BONUS = 2.5f;
    public static final float PERSONAL_HIT_STRENGTH_BONUS = 40;
    public static final float FLEET_HIT_STRENGTH_BONUS = 10;


    public static class Level1p implements ShipSkillEffect {

        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getDamageToTargetEnginesMult().modifyPercent(id, PERSONAL_DAMAGE_TO_MODULES_BONUS);
            stats.getDamageToTargetWeaponsMult().modifyPercent(id, PERSONAL_DAMAGE_TO_MODULES_BONUS);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getDamageToTargetEnginesMult().unmodify(id);
            stats.getDamageToTargetWeaponsMult().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(PERSONAL_DAMAGE_TO_MODULES_BONUS) + "% damage to weapons and engines";
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
            stats.getDamageToTargetEnginesMult().modifyPercent(id, FLEET_DAMAGE_TO_MODULES_BONUS);
            stats.getDamageToTargetWeaponsMult().modifyPercent(id, FLEET_DAMAGE_TO_MODULES_BONUS);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getDamageToTargetEnginesMult().unmodify(id);
            stats.getDamageToTargetWeaponsMult().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(FLEET_DAMAGE_TO_MODULES_BONUS) + "% damage to weapons and engines";
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
            stats.getDamageToTargetShieldsMult().modifyPercent(id, PERSONAL_DAMAGE_TO_SHIELDS_BONUS);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getDamageToTargetShieldsMult().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + String.format("%.1f",PERSONAL_DAMAGE_TO_SHIELDS_BONUS) + "% damage to shields";
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
            stats.getDamageToTargetShieldsMult().modifyPercent(id, FLEET_DAMAGE_TO_SHIELDS_BONUS);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getDamageToTargetShieldsMult().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + String.format("%.1f",FLEET_DAMAGE_TO_SHIELDS_BONUS) + "% damage to shields";
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
            stats.getHitStrengthBonus().modifyPercent(id, PERSONAL_HIT_STRENGTH_BONUS);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getHitStrengthBonus().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(PERSONAL_HIT_STRENGTH_BONUS) + "% hit strength for armor damage reduction calculation only";
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
            stats.getHitStrengthBonus().modifyPercent(id, FLEET_HIT_STRENGTH_BONUS);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getHitStrengthBonus().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(FLEET_HIT_STRENGTH_BONUS) + "% hit strength for armor damage reduction calculation only";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.ALL_SHIPS;
        }
    }

}

