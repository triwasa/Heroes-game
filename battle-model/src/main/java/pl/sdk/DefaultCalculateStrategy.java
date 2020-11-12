package pl.sdk;

import java.util.Random;

public class DefaultCalculateStrategy extends AbstractCalculateDamageStrategy {

    private final Random rand;

    public DefaultCalculateStrategy(){
        this(new Random());
    }

    public DefaultCalculateStrategy(Random aRandomizer) {
        super(aRandomizer);
        rand = aRandomizer;
    }

    @Override
    double changeDamageAfter(double aWholeStackDamageToDeal, Creature aAttacker) {
        return aWholeStackDamageToDeal;
    }
}
