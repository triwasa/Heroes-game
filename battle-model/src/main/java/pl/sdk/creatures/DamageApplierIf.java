package pl.sdk.creatures;

public interface DamageApplierIf {
    void applyDamage(int DamageToApply, CreatureDefender aDefender);
    void applySpellDamage(int SpellDamageToApply, Creature aDefender);
}
