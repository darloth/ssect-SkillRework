package skillrework.campaign.skills;

import com.fs.starfarer.api.characters.ShipSkillEffect;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;

public class ImpactMitigation {

    public static final float PERSONAL_ARMOR_BONUS = 120;
    public static final float FLEET_ARMOR_BONUS = 30;
    public static final float PERSONAL_MAX_DAMAGE_REDUCTION_BONUS = 0.04f;
    public static final float FLEET_MAX_DAMAGE_REDUCTION_BONUS = 0.01f;
    public static final float PERSONAL_ARMOR_DAMAGE_REDUCTION = 16f;
    public static final float FLEET_ARMOR_DAMAGE_REDUCTION = 5f;


    public static class Level1p implements ShipSkillEffect {
        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getEffectiveArmorBonus().modifyPercent(id, PERSONAL_ARMOR_BONUS);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getEffectiveArmorBonus().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(PERSONAL_ARMOR_BONUS) + " armor for damage reduction calculation only";
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
            stats.getEffectiveArmorBonus().modifyPercent(id, FLEET_ARMOR_BONUS);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getEffectiveArmorBonus().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(FLEET_ARMOR_BONUS) + " armor for damage reduction calculation only";
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
            stats.getMaxArmorDamageReduction().modifyFlat(id, PERSONAL_MAX_DAMAGE_REDUCTION_BONUS);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getMaxArmorDamageReduction().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "Maximum damage reduction by armor raised from 85% to 89%";
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
            stats.getMaxArmorDamageReduction().modifyFlat(id, FLEET_MAX_DAMAGE_REDUCTION_BONUS);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getMaxArmorDamageReduction().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "Maximum damage reduction by armor raised by 1% (to 86% or 90% if stacking with above)";
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
            stats.getArmorDamageTakenMult().modifyMult(id, 1f - PERSONAL_ARMOR_DAMAGE_REDUCTION / 100f);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getArmorDamageTakenMult().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "-" + (int)(PERSONAL_ARMOR_DAMAGE_REDUCTION) + "% armor damage taken";
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
            stats.getArmorDamageTakenMult().modifyMult(id, 1f - FLEET_ARMOR_DAMAGE_REDUCTION / 100f);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getArmorDamageTakenMult().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "-" + (int)(FLEET_ARMOR_DAMAGE_REDUCTION) + "% armor damage taken";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.ALL_SHIPS;
        }
    }

}
