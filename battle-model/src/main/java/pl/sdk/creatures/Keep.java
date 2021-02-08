package pl.sdk.creatures;

import com.google.common.collect.Range;

public class Keep implements BattleObject, Fortification {


    private String name = "Keep";
    private int maxHp = 2;
    private int currentHp = 2;
    private int attack = 1;
    private int amount;
    private int level = 1;
    public Range<Integer> damage = Range.closed(15,15);
    private DefaultCalculateStrategy dealDamageCalc = new DefaultCalculateStrategy();
    private PossibleAttackManagerIf possibleAttacKManager;


    public Keep() {
        possibleAttacKManager = new PossibleAttackManagerForCreature();
    }
    @Override
    public AttackStrategy getAttackStrategy() {
        return null;
    }

    @Override
    public CalculateDamageStrategy getCalculateDamage() {
        return null;
    }

    @Override
    public Range<Integer> getDamage() {
        return null;
    }

    @Override
    public int getAttack() {
        return 0;
    }

    @Override
    public double getAttackRange() {
        return 0;
    }

    @Override
    public boolean canFortificationAttack() {
        return possibleAttacKManager.canFortificationAttack();
    }

    @Override
    public boolean canCreatureAttack() {
        return possibleAttacKManager.canCreatureAttack();
    }



    @Override
    public DamageApplierIf getDamageApplier() {
        return null;
    }

    @Override
    public void applyDamage(int aDamageToApply) {
        int fullCurrentHp = currentHp - aDamageToApply;
        if (fullCurrentHp <= 0) {
            amount = 0;
            currentHp = 0;
        }
        else
        {
            currentHp = fullCurrentHp;
        }

    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public String getMovementType() {
        return null;
    }

    @Override
    public int getMoveRange() {
        return 0;
    }

    @Override
    public boolean canCounterAttack() {
        return false;
    }

    @Override
    public boolean isAlive() {
        return false;
    }

    @Override
    public int getCurrentHp() {
        return 0;
    }

    @Override
    public boolean[][] getSplashRange() {
        return new boolean[0][];
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getAmount() {
        return 0;
    }

    @Override
    public int getMaxHp() {
        return 0;
    }



    @Override
    public int getArmor() {
        return 0;
    }



    @Override
    public boolean isCreature() {
        return false;
    }

    @Override
    public boolean isFortification() {
        return true;
    }


    @Override
    public void counterAttackedInThisTurn() {

    }
}
