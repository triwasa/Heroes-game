package pl.sdk.creatures;

import pl.sdk.creatures.Creature;
import pl.sdk.creatures.DefendingBattleObject;

public interface DamageApplierIf {
    void applyDamage(int DamageToApply, DefendingBattleObject aDefender);
    void applySpellDamage(int SpellDamageToApply, Creature aDefender);
}
