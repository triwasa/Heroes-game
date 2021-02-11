package pl.sdk.creatures;

import pl.sdk.hero.Hero;

import java.util.Random;

public class DefaultCalculateStrategy extends AbstractCalculateDamageStrategy {

    private final Random rand;

    DefaultCalculateStrategy(){
        this(new Random());
    }

    DefaultCalculateStrategy(Random aRandomizer) {
        super(aRandomizer);
        rand = aRandomizer;
    }

    @Override
    double changeDamageAfter(double aWholeStackDamageToDeal, Attacker aAttacker, Defender aDefender) {
        return aWholeStackDamageToDeal;
    }

    @Override
    public int calculateDamage(Attacker attacker, Defender aDefender, Hero hero) {
        return 0;
    }
}
