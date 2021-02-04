package pl.sdk.creatures;

public abstract class AbstractDamageApplier implements DamageApplierIf {

    @Override
    public void calculateDamageToApply(int aDamageToApply, Defender aDefender) {
        aDamageToApply = changeDamageApplied(aDamageToApply);
        aDefender.applyDamage(aDamageToApply);
    }

    @Override
    public void applySpellDamage(int aSpellDamageToApply, Defender aDefender) {
        changeSpellDamageApplied(aSpellDamageToApply);
    }

    public abstract int changeDamageApplied(int aDamageToDecrease);
    public abstract int changeSpellDamageApplied(int aSpellDamageToDecrease);
}
