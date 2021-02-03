package pl.sdk.creatures;

public abstract class AbstractDamageApplier implements DamageApplierIf {

    @Override
    public void applyDamage(int aDamageToApply, Defender aDefender) {
        changeDamageApplied(aDamageToApply);
        int amount = aDefender.getAmount();
        int currentHp = aDefender.getCurrentHp();

        int fullCurrentHp = (aDefender.getMaxHp() * (amount - 1)) + currentHp - aDamageToApply;
        if (fullCurrentHp <= 0) {
            aDefender.amountAfterAttack(0);
            aDefender.currentHpAfterAttack(0);
        }
        else
        {
            if(fullCurrentHp % aDefender.getMaxHp()==0)
            {
                aDefender.currentHpAfterAttack(aDefender.getMaxHp());
                aDefender.amountAfterAttack(fullCurrentHp/aDefender.getMaxHp());
            }
            else
            {
                aDefender.currentHpAfterAttack(fullCurrentHp % aDefender.getMaxHp());
                if (aDamageToApply >= 0){
                    aDefender.amountAfterAttack( (fullCurrentHp/aDefender.getMaxHp()) + 1);
                }else{
                    aDefender.amountAfterAttack(fullCurrentHp/aDefender.getMaxHp());
                }
            }
        }
    }
    public void applyDamage(int aDamageToApply, Attacker aDefender) {
        changeDamageApplied(aDamageToApply);
        int fullCurrentHp = aDefender.getMaxHp();
        if (fullCurrentHp <= 0) {
           // aDefender.currentHpAfterAttack(0);
        }
        else
        {
            if(fullCurrentHp % aDefender.getMaxHp()==0)
            {
               // aDefender.currentHpAfterAttack(aDefender.getMaxHp());
            }
            else
            {
               // aDefender.currentHpAfterAttack(fullCurrentHp % aDefender.getMaxHp());
            }
        }
    }

    @Override
    public void applySpellDamage(int aSpellDamageToApply, Defender aDefender) {
        changeSpellDamageApplied(aSpellDamageToApply);
    }

    public abstract int changeDamageApplied(int aDamageToDecrease);
    public abstract int changeSpellDamageApplied(int aSpellDamageToDecrease);
}
