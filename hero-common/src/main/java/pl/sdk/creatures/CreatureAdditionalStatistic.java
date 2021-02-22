package pl.sdk.creatures;


import com.google.common.collect.Range;

public class CreatureAdditionalStatistic implements CreatureAdditionalStatisticIf  {

    private int additionalMoveRange;
    private int additionalHp;
    private int resistance;
    private int additionalAttack;
    private int additionalDefence;
    private Range<Integer> additionalDamage;

    CreatureAdditionalStatistic() {
        additionalDamage = Range.closed(0,0);
    }

    @Override
    public int getAdditionalMoveRange() {
        return additionalMoveRange;
    }

    @Override
    public int getAdditionalHp() {
        return additionalHp;
    }

    @Override
    public int getResistance() {
        return resistance;
    }

    @Override
    public int getAdditionalAttack() {
        return additionalAttack;
    }

    @Override
    public int getAdditionalDefence() {
        return additionalDefence;
    }

    @Override
    public Range<Integer> getAdditionalDamage() {
        return additionalDamage;
    }


    void increaseMoveRange(int aMoveRangeToIncrease) {
        additionalMoveRange += aMoveRangeToIncrease;
    }


    void increaseHp(int aHpToIncrease) {
        additionalHp += aHpToIncrease;
    }


    void increaseResistance(int aResistanceToIncrease) {
        resistance += aResistanceToIncrease;
    }

    void increaseDamage(int aLowerBound, int aUpperBound) { additionalDamage = Range.closed(additionalDamage.lowerEndpoint() + aLowerBound, additionalDamage.upperEndpoint() + aUpperBound);
    }
    void increaseAttack(int attackToIncrease) {
        additionalAttack += attackToIncrease;
    }
    void increaseDefence(int defenceToIncrease) {
        additionalDefence += defenceToIncrease;
    }
}
