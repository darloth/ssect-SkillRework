package skillrework.campaign.skills;

import com.fs.starfarer.api.characters.ShipSkillEffect;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;

public class OrdnanceExpertise {

    public static final float PERSONAL_PROJ_SPEED_BONUS_L1 = 10;
    public static final float FLEET_PROJ_SPEED_BONUS_L1 = 5;
    public static final float PERSONAL_PROJ_SPEED_BONUS_L2 = 10;
    public static final float PERSONAL_WEAPON_HITPOINTS_BONUS_L1 = 20;
    public static final float PERSONAL_WEAPON_HITPOINTS_BONUS_L2 = 20;
    public static final float FLEET_WEAPON_HITPOINTS_BONUS = 10;
    public static final float PERSONAL_DAMAGE_BONUS = 12.5f;
    public static final float FLEET_DAMAGE_BONUS = 2.5f;

    public static class Level1p implements ShipSkillEffect {

        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getProjectileSpeedMult().modifyPercent(id, PERSONAL_PROJ_SPEED_BONUS_L1);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getProjectileSpeedMult().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(PERSONAL_PROJ_SPEED_BONUS_L1) + "% ballistic and energy projectile speed";
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
            stats.getProjectileSpeedMult().modifyPercent(id, FLEET_PROJ_SPEED_BONUS_L1);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getProjectileSpeedMult().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(FLEET_PROJ_SPEED_BONUS_L1) + "% ballistic and energy projectile speed";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.ALL_SHIPS;
        }
    }

    public static class Level1B implements ShipSkillEffect {

        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getWeaponHealthBonus().modifyPercent(id, PERSONAL_WEAPON_HITPOINTS_BONUS_L1);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getWeaponHealthBonus().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(PERSONAL_WEAPON_HITPOINTS_BONUS_L1) + "% weapon hitpoints";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.PILOTED_SHIP;
        }

    }

    public static class Level2p implements ShipSkillEffect {

        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getWeaponHealthBonus().modifyPercent(id, PERSONAL_WEAPON_HITPOINTS_BONUS_L2);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getWeaponHealthBonus().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(PERSONAL_WEAPON_HITPOINTS_BONUS_L2) + "% weapon hitpoints";
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
            stats.getWeaponHealthBonus().modifyPercent(id, FLEET_WEAPON_HITPOINTS_BONUS);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getWeaponHealthBonus().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(FLEET_WEAPON_HITPOINTS_BONUS) + "% weapon hitpoints";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.PILOTED_SHIP;
        }

    }

    public static class Level2B implements ShipSkillEffect {

        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getProjectileSpeedMult().modifyPercent(id, PERSONAL_PROJ_SPEED_BONUS_L2);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getProjectileSpeedMult().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(PERSONAL_PROJ_SPEED_BONUS_L2) + "% ballistic and energy projectile speed";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.PILOTED_SHIP;
        }
    }

    public static class Level3p implements ShipSkillEffect {

        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getBallisticWeaponDamageMult().modifyPercent(id, PERSONAL_DAMAGE_BONUS);
            stats.getEnergyWeaponDamageMult().modifyPercent(id, PERSONAL_DAMAGE_BONUS);
            stats.getMissileWeaponDamageMult().modifyPercent(id, PERSONAL_DAMAGE_BONUS);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getBallisticWeaponDamageMult().unmodify(id);
            stats.getEnergyWeaponDamageMult().unmodify(id);
            stats.getMissileWeaponDamageMult().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + String.format("%.1f", PERSONAL_DAMAGE_BONUS) + "% weapon damage";
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
            stats.getBallisticWeaponDamageMult().modifyPercent(id, FLEET_DAMAGE_BONUS);
            stats.getEnergyWeaponDamageMult().modifyPercent(id, FLEET_DAMAGE_BONUS);
            stats.getMissileWeaponDamageMult().modifyPercent(id, FLEET_DAMAGE_BONUS);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getBallisticWeaponDamageMult().unmodify(id);
            stats.getEnergyWeaponDamageMult().unmodify(id);
            stats.getMissileWeaponDamageMult().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + String.format("%.1f", FLEET_DAMAGE_BONUS) + "% weapon damage";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.ALL_SHIPS;
        }

    }
}

