package pl.sdk;

import java.util.Random;

public class DefaultCalculateDamageStrategyWithSelfHealing extends AbstractCalculateDamageStrategy {

    private final Random rand;
    private final double selfHealingPercentage;

    public DefaultCalculateDamageStrategyWithSelfHealing(double aSelfHealingPercentage) {
        this(aSelfHealingPercentage, new Random());
    }

    DefaultCalculateDamageStrategyWithSelfHealing(double aSelfHealingPercentage, Random aRand) {
        super(aRand);
        rand = aRand;
        selfHealingPercentage = aSelfHealingPercentage;
    }

    @Override
    double changeDamageAfter(double aWholeStackDamageToDeal, Creature aAttacker) {
        aAttacker.applyDamage((int)-(aWholeStackDamageToDeal * selfHealingPercentage));
        return aWholeStackDamageToDeal;
    }
}
