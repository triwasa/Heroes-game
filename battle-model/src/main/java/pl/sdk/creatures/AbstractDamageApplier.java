package pl.sdk.creatures;

public abstract class AbstractDamageApplier implements DamageApplierIf {

    @Override
    public void applyDamage(int aDamageToApply, DefendingBattleObject aDefender) {
        changeDamageApplied(aDamageToApply);
        int amount = aDefender.getAmount();
        int currentHp = aDefender.getCurrentHp();

        int fullCurrentHp = (aDefender.getMaxHp() * (amount - 1)) + currentHp - aDamageToApply;
        if (fullCurrentHp <= 0) {
            amount = 0;
            currentHp = 0;
        }
        else
        {
            if(fullCurrentHp % aDefender.getMaxHp()==0)
            {
                currentHp=aDefender.getMaxHp();
                amount=fullCurrentHp/aDefender.getMaxHp();
            }
            else
            {
                currentHp = fullCurrentHp % aDefender.getMaxHp();
                if (aDamageToApply >= 0){
                    amount = (fullCurrentHp/aDefender.getMaxHp()) + 1;
                }else{
                    amount = (fullCurrentHp/aDefender.getMaxHp());
                }
            }
        }
    }

    @Override
    public void applySpellDamage(int aSpellDamageToApply, Creature aDefender) {
        changeSpellDamageApplied(aSpellDamageToApply);
    }

    public abstract int changeDamageApplied(int aDamageToDecrease);
    public abstract int changeSpellDamageApplied(int aSpellDamageToDecrease);
}
