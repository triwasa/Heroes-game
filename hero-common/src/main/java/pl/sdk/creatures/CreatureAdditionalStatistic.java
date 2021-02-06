package pl.sdk.creatures;

public class CreatureAdditionalStatistic implements CreatureAdditionalStatisticIf  {

    private int additionalMoveRange;
    private int additionalHp;
    private int resistance;

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



    void increaseMoveRange(int aMoveRangeToIncrease) {
        additionalMoveRange += aMoveRangeToIncrease;
    }


    void increaseHp(int aHpToIncrease) {
        additionalHp += aHpToIncrease;
    }


    void increaseResistance(int aResistanceToIncrease) {
        resistance += aResistanceToIncrease;
    }
}
