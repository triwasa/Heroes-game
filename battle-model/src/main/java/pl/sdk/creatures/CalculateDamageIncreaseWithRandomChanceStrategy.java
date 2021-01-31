package pl.sdk.creatures;

import java.util.Random;

class CalculateDamageIncreaseWithRandomChanceStrategy extends AbstractCalculateDamageStrategy {

    private final double chanceToIncrease;
    private final double increaseFactor;

    CalculateDamageIncreaseWithRandomChanceStrategy(double aChance, double aIncreaseFactor) {
        this(aChance,aIncreaseFactor,new Random());
    }

    CalculateDamageIncreaseWithRandomChanceStrategy(double aChance, double aIncreaseFactor, Random aRand) {
        super(aRand);
        chanceToIncrease = aChance;
        increaseFactor = aIncreaseFactor;
    }

    @Override
    double changeDamageAfter(double aDamageToChange, AttackingBattleObject aAttacker, DefendingBattleObject aDefender) {
        if (getRand().nextDouble() <= chanceToIncrease){
            aDamageToChange = aDamageToChange * increaseFactor;
        }
        return aDamageToChange;
    }
}
