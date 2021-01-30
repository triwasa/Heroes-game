package pl.sdk;

public class DefaultDamageApplier extends AbstractDamageApplier {


    @Override
    public int decreaseDamageApplied(int aDamageToDecrease) {
        return aDamageToDecrease;
    }

    @Override
    public int decreaseSpellDamageApplied(int aSpellDamageToDecrease) {
        return aSpellDamageToDecrease;
    }
}
