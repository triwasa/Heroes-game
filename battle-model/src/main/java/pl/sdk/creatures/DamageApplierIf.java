package pl.sdk.creatures;

public interface DamageApplierIf {
    void calculateDamageToApply(int DamageToApply, Defender aDefender);
    void applySpellDamage(int SpellDamageToApply, Defender aDefender);
}
