package pl.sdk.warMachines;

import java.util.Random;

class DefaultCalculateStrategy extends AbstractCalculateDamageStrategy {

    private final Random rand;

    DefaultCalculateStrategy(){
        this(new Random());
    }

    DefaultCalculateStrategy(Random aRandomizer) {
        super(aRandomizer);
        rand = aRandomizer;
    }

    @Override
    double changeDamageAfter(double aWholeStackDamageToDeal, WarMachine aAttacker) {
        return aWholeStackDamageToDeal;
    }
}