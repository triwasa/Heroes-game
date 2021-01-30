package pl.sdk;

import pl.sdk.creatures.Creature;

public interface DamageApplierIf {
    void applyDamage(int DamageToApply, Creature aDefender);
    void applySpellDamage(int SpellDamageToApply, Creature aDefender);
}
