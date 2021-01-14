package pl.sdk.warMachines;

import pl.sdk.warMachines.AbstractCalculateDamageStrategy;
import pl.sdk.warMachines.WarMachine;

import java.util.Random;

class DefaultCalculateStrategy extends pl.sdk.warMachines.AbstractCalculateDamageStrategy {

    private final Random rand;

    DefaultCalculateStrategy(){
        this(new Random());
    }

    DefaultCalculateStrategy(Random aRandomizer) {
        super(aRandomizer);
        rand = aRandomizer;
    }

}