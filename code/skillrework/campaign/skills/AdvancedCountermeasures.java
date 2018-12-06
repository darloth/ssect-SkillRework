package skillrework.campaign.skills;

import com.fs.starfarer.api.characters.ShipSkillEffect;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;

public class AdvancedCountermeasures {

    public static final float PERSONAL_ARMOR_KINETIC_REDUCTION = 45f;
    public static final float FLEET_ARMOR_KINETIC_REDUCTION = 10f;
    public static final float PERSONAL_SHIELD_HE_REDUCTION = 21f;
    public static final float FLEET_SHIELD_HE_REDUCTION = 5f;
    public static final float PERSONAL_FIGHTER_DAMAGE_BONUS = 40f;
    public static final float FLEET_FIGHTER_DAMAGE_BONUS = 10f;
    public static final float PERSONAL_MISSILE_DAMAGE_BONUS = 40f;
    public static final float FLEET_MISSILE_DAMAGE_BONUS = 10f;



    public static class Level1p implements ShipSkillEffect {

        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getKineticArmorDamageTakenMult().modifyMult(id, 1f - PERSONAL_ARMOR_KINETIC_REDUCTION / 100f);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getKineticArmorDamageTakenMult().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "-" + (int)(PERSONAL_ARMOR_KINETIC_REDUCTION) + "% kinetic damage taken by armor";
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
            stats.getKineticArmorDamageTakenMult().modifyMult(id, 1f - FLEET_ARMOR_KINETIC_REDUCTION / 100f);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getKineticArmorDamageTakenMult().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "-" + (int)(FLEET_ARMOR_KINETIC_REDUCTION) + "% kinetic damage taken by armor";
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
            stats.getHighExplosiveShieldDamageTakenMult().modifyMult(id, 1f - PERSONAL_SHIELD_HE_REDUCTION / 100f);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getHighExplosiveShieldDamageTakenMult().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "-" + (int)(PERSONAL_SHIELD_HE_REDUCTION) + "% high-explosive damage taken by shields";
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
            stats.getHighExplosiveShieldDamageTakenMult().modifyMult(id, 1f - FLEET_SHIELD_HE_REDUCTION / 100f);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getHighExplosiveShieldDamageTakenMult().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "-" + (int)(FLEET_SHIELD_HE_REDUCTION) + "% high-explosive damage taken by shields";
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
            stats.getDamageToFighters().modifyFlat(id, PERSONAL_FIGHTER_DAMAGE_BONUS / 100f);
            stats.getDamageToMissiles().modifyFlat(id, PERSONAL_MISSILE_DAMAGE_BONUS / 100f);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getDamageToFighters().unmodify(id);
            stats.getDamageToMissiles().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(PERSONAL_FIGHTER_DAMAGE_BONUS) + "% damage to fighters and " + "+" + (int)(PERSONAL_MISSILE_DAMAGE_BONUS) + "% damage to missiles";
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
            stats.getDamageToFighters().modifyFlat(id, FLEET_FIGHTER_DAMAGE_BONUS / 100f);
            stats.getDamageToMissiles().modifyFlat(id, FLEET_MISSILE_DAMAGE_BONUS / 100f);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getDamageToFighters().unmodify(id);
            stats.getDamageToMissiles().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(FLEET_FIGHTER_DAMAGE_BONUS) + "% damage to fighters and " + "+" + (int)(FLEET_MISSILE_DAMAGE_BONUS) + "% damage to missiles";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.ALL_SHIPS;
        }
    }

}

