package skillrework.campaign.skills;

import com.fs.starfarer.api.characters.ShipSkillEffect;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;

public class MissileSpecialization {

    public static final float PERSONAL_MISSILE_SPEC_SPEED_BONUS = 20f;
    public static final float PERSONAL_MISSILE_SPEC_RANGE_MULT = 0.84f;
    public static final float PERSONAL_MISSILE_SPEC_ACCEL_BONUS = 40f;
    public static final float PERSONAL_MISSILE_TURN_RATE_BONUS = 40f;
    public static final float PERSONAL_MISSILE_TURN_ACCEL_BONUS = 80f;
    public static final float FLEET_MISSILE_SPEC_SPEED_BONUS = 5f;
    public static final float FLEET_MISSILE_SPEC_RANGE_MULT = 0.955f;
    public static final float FLEET_MISSILE_SPEC_ACCEL_BONUS = 10f;
    public static final float FLEET_MISSILE_TURN_RATE_BONUS = 10f;
    public static final float FLEET_MISSILE_TURN_ACCEL_BONUS = 20f;

    public static final float PERSONAL_MISSILE_SPEC_PERK_HEALTH_BONUS = 50f;
    public static final float FLEET_MISSILE_SPEC_PERK_HEALTH_BONUS = 50f;

    public static final float PERSONAL_MISSILE_SPEC_PERK_DAMAGE_BONUS = 25f;
    public static final float FLEET_MISSILE_SPEC_PERK_DAMAGE_BONUS = 25f;

    public static class Level1p implements ShipSkillEffect {

        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getMissileMaxSpeedBonus().modifyPercent(id, PERSONAL_MISSILE_SPEC_SPEED_BONUS);
            stats.getMissileWeaponRangeBonus().modifyMult(id, PERSONAL_MISSILE_SPEC_RANGE_MULT);

            stats.getMissileAccelerationBonus().modifyPercent(id, PERSONAL_MISSILE_SPEC_ACCEL_BONUS);
            stats.getMissileMaxTurnRateBonus().modifyPercent(id, PERSONAL_MISSILE_TURN_RATE_BONUS);
            stats.getMissileTurnAccelerationBonus().modifyPercent(id, PERSONAL_MISSILE_TURN_ACCEL_BONUS);

        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getMissileMaxSpeedBonus().unmodify(id);
            stats.getMissileWeaponRangeBonus().unmodify(id);

            stats.getMissileAccelerationBonus().unmodify(id);
            stats.getMissileMaxTurnRateBonus().unmodify(id);
            stats.getMissileTurnAccelerationBonus().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(PERSONAL_MISSILE_SPEC_SPEED_BONUS) + "% missile speed and maneuverability";
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
            stats.getMissileMaxSpeedBonus().modifyPercent(id, FLEET_MISSILE_SPEC_SPEED_BONUS);
            stats.getMissileWeaponRangeBonus().modifyMult(id, FLEET_MISSILE_SPEC_RANGE_MULT);

            stats.getMissileAccelerationBonus().modifyPercent(id, FLEET_MISSILE_SPEC_ACCEL_BONUS);
            stats.getMissileMaxTurnRateBonus().modifyPercent(id, FLEET_MISSILE_TURN_RATE_BONUS);
            stats.getMissileTurnAccelerationBonus().modifyPercent(id, FLEET_MISSILE_TURN_ACCEL_BONUS);

        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getMissileMaxSpeedBonus().unmodify(id);
            stats.getMissileWeaponRangeBonus().unmodify(id);

            stats.getMissileAccelerationBonus().unmodify(id);
            stats.getMissileMaxTurnRateBonus().unmodify(id);
            stats.getMissileTurnAccelerationBonus().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(FLEET_MISSILE_SPEC_SPEED_BONUS) + "% missile speed and maneuverability";
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
            stats.getMissileHealthBonus().modifyPercent(id, PERSONAL_MISSILE_SPEC_PERK_HEALTH_BONUS);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getMissileHealthBonus().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(PERSONAL_MISSILE_SPEC_PERK_HEALTH_BONUS) + "% missile, rocket, bomb, and torpedo hitpoints";
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
            stats.getMissileHealthBonus().modifyPercent(id, FLEET_MISSILE_SPEC_PERK_HEALTH_BONUS);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getMissileHealthBonus().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(FLEET_MISSILE_SPEC_PERK_HEALTH_BONUS) + "% missile, rocket, bomb, and torpedo hitpoints";
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
            stats.getMissileWeaponDamageMult().modifyPercent(id, PERSONAL_MISSILE_SPEC_PERK_DAMAGE_BONUS);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getMissileWeaponDamageMult().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(PERSONAL_MISSILE_SPEC_PERK_DAMAGE_BONUS) + "% missile damage";
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
            stats.getMissileWeaponDamageMult().modifyPercent(id, FLEET_MISSILE_SPEC_PERK_DAMAGE_BONUS);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getMissileWeaponDamageMult().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(FLEET_MISSILE_SPEC_PERK_DAMAGE_BONUS) + "% missile damage";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.ALL_SHIPS;
        }

    }
}

