package pl.sdk.creatures;


import com.google.common.collect.Range;

public class CreatureAdditionalStatistic implements CreatureAdditionalStatisticIf  {

    private int additionalMoveRange;
    private int additionalHp;
    private int resistance;
    private Range<Integer> additionalDamage;

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
}
