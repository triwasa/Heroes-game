package pl.sdk.creatures;



public class DefaultDamageApplier extends AbstractDamageApplier {


    @Override
    public int changeDamageApplied(int aDamageToDecrease) {
        return aDamageToDecrease;
    }

    @Override
    public int changeSpellDamageApplied(int aSpellDamageToDecrease) {
        return aSpellDamageToDecrease;
    }
}
