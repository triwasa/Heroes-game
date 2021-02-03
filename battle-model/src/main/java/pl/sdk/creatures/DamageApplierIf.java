package pl.sdk.creatures;

public interface DamageApplierIf {
    void applyDamage(int DamageToApply, Defender aDefender);
    void applySpellDamage(int SpellDamageToApply, Defender aDefender);
}
