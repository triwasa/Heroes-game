package pl.sdk.creatures;

import pl.sdk.hero.Hero;

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
    double changeDamageAfter(double aDamageToChange, Attacker aAttacker, Defender aDefender) {
        if (getRand().nextDouble() <= chanceToIncrease){
            aDamageToChange = aDamageToChange * increaseFactor;
        }
        return aDamageToChange;
    }

    @Override
    public int calculateDamage(Attacker attacker, Defender aDefender, Hero hero) {
        return 0;
    }
}
