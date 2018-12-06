package skillrework.campaign.skills;

import com.fs.starfarer.api.characters.ShipSkillEffect;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;
import com.fs.starfarer.api.impl.campaign.ids.Stats;

public class DamageControl {

    public static final float PERSONAL_INSTA_REPAIR = 0.15f;
    public static final float FLEET_INSTA_REPAIR = 0.10f;

    public static final float PERSONAL_CREW_LOSS_REDUCTION = 45;
    public static final float FLEET_CREW_LOSS_REDUCTION = 10;

    public static final float PERSONAL_MODULE_REPAIR_BONUS = 40;
    public static final float FLEET_MODULE_REPAIR_BONUS = 10;

    public static final float PERSONAL_HULL_DAMAGE_REDUCTION = 21;
    public static final float FLEET_HULL_DAMAGE_REDUCTION = 5;
    public static final float PERSONAL_OVERLOAD_REDUCTION = 21;
    public static final float FLEET_OVERLOAD_REDUCTION = 5;

    public static class Level1p implements ShipSkillEffect {

        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getCrewLossMult().modifyMult(id, 1f - PERSONAL_CREW_LOSS_REDUCTION / 100f);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getCrewLossMult().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "-" + (int)(PERSONAL_CREW_LOSS_REDUCTION) + "% crew lost due to hull damage in combat";
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
            stats.getCrewLossMult().modifyMult(id, 1f - FLEET_CREW_LOSS_REDUCTION / 100f);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getCrewLossMult().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "-" + (int)(FLEET_CREW_LOSS_REDUCTION) + "% crew lost due to hull damage in combat";
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
            stats.getDynamic().getMod(Stats.INDIVIDUAL_SHIP_RECOVERY_MOD).modifyFlat(id, 1000f);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getDynamic().getMod(Stats.INDIVIDUAL_SHIP_RECOVERY_MOD).unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "If lost in combat, ship is almost always recoverable";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.PILOTED_SHIP;
        }
    }

    public static class Level1C implements ShipSkillEffect {
        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getDynamic().getMod(Stats.INSTA_REPAIR_FRACTION).modifyFlat(id, PERSONAL_INSTA_REPAIR);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getDynamic().getMod(Stats.INSTA_REPAIR_FRACTION).unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "" + (int) Math.round(PERSONAL_INSTA_REPAIR * 100f) + "% of hull and armor damage taken repaired after combat ends, at no cost";
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
            float timeMult = 1f / ((100f + PERSONAL_MODULE_REPAIR_BONUS) / 100f);
            stats.getCombatWeaponRepairTimeMult().modifyMult(id, timeMult);
            stats.getCombatEngineRepairTimeMult().modifyMult(id, timeMult);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getCombatWeaponRepairTimeMult().unmodify(id);
            stats.getCombatEngineRepairTimeMult().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "" + (int)(PERSONAL_MODULE_REPAIR_BONUS) + "% faster in-combat weapon and engine repairs";
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
            float timeMult = 1f / ((100f + FLEET_MODULE_REPAIR_BONUS) / 100f);
            stats.getCombatWeaponRepairTimeMult().modifyMult(id, timeMult);
            stats.getCombatEngineRepairTimeMult().modifyMult(id, timeMult);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getCombatWeaponRepairTimeMult().unmodify(id);
            stats.getCombatEngineRepairTimeMult().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "" + (int)(FLEET_MODULE_REPAIR_BONUS) + "% faster in-combat weapon and engine repairs";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.ALL_SHIPS;
        }
    }

    public static class Level2B implements ShipSkillEffect {
        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getDynamic().getMod(Stats.INSTA_REPAIR_FRACTION).modifyFlat(id, FLEET_INSTA_REPAIR);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getDynamic().getMod(Stats.INSTA_REPAIR_FRACTION).unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "" + (int) Math.round(FLEET_INSTA_REPAIR * 100f) + "% of hull and armor damage taken repaired after combat ends, at no cost";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.ALL_SHIPS;
        }
    }

    public static class Level3Ap implements ShipSkillEffect {

        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getHullDamageTakenMult().modifyMult(id, 1f - PERSONAL_HULL_DAMAGE_REDUCTION / 100f);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getHullDamageTakenMult().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "-" + (int)(PERSONAL_HULL_DAMAGE_REDUCTION) + "% hull damage taken";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.PILOTED_SHIP;
        }
    }

    public static class Level3Af implements ShipSkillEffect {

        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getHullDamageTakenMult().modifyMult(id, 1f - FLEET_HULL_DAMAGE_REDUCTION / 100f);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getHullDamageTakenMult().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "-" + (int)(FLEET_HULL_DAMAGE_REDUCTION) + "% hull damage taken";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.ALL_SHIPS;
        }
    }

    public static class Level3Bp implements ShipSkillEffect {

        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getOverloadTimeMod().modifyMult(id, 1f - PERSONAL_OVERLOAD_REDUCTION / 100f);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getOverloadTimeMod().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "-" + (int)(PERSONAL_OVERLOAD_REDUCTION) + "% overload duration";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.PILOTED_SHIP;
        }
    }

    public static class Level3Bf implements ShipSkillEffect {

        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getOverloadTimeMod().modifyMult(id, 1f - FLEET_OVERLOAD_REDUCTION / 100f);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getOverloadTimeMod().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "-" + (int)(FLEET_OVERLOAD_REDUCTION) + "% overload duration";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.ALL_SHIPS;
        }
    }
}
