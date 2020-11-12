package pl.sdk;

import java.util.Random;

public class CalculateDamageIncreaseWithRandomChanceStrategy extends AbstractCalculateDamageStrategy {

    private final Random rand;
    private final double chanceToIncrease;
    private final double increaseFactor;

    public CalculateDamageIncreaseWithRandomChanceStrategy(double aChance, double aIncreaseFactor) {
        this(aChance,aIncreaseFactor,new Random());
    }

    public CalculateDamageIncreaseWithRandomChanceStrategy(double aChance, double aIncreaseFactor, Random aRand) {
        super(aRand);
        chanceToIncrease = aChance;
        increaseFactor = aIncreaseFactor;
        rand = aRand;
    }

    @Override
    double changeDamageAfter(double aDamageToChange, Creature aAttacker) {
        if (rand.nextDouble() <= chanceToIncrease){
            aDamageToChange = aDamageToChange * increaseFactor;
        }
        return aDamageToChange;
    }
}
