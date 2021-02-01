package pl.sdk.creatures;

public interface DamageApplierIf {
    void applyDamage(int DamageToApply, DefendingCreature aDefender);
    void applySpellDamage(int SpellDamageToApply, Creature aDefender);
}
