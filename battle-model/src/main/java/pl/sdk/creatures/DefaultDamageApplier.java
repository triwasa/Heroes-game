package pl.sdk.creatures;



public class DefaultDamageApplier extends AbstractDamageApplier {


    @Override
    public int changeDamageApplied(int aDamageToDecrease) {
        System.out.println("damage applied: " + aDamageToDecrease);
        return aDamageToDecrease;

    }

    @Override
    public int changeSpellDamageApplied(int aSpellDamageToDecrease) {
        return aSpellDamageToDecrease;
    }
}
