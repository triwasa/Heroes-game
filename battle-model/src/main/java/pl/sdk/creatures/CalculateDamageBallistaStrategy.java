package pl.sdk.creatures;

import pl.sdk.hero.Hero;

import java.util.Random;

public class CalculateDamageBallistaStrategy extends AbstractCalculateDamageStrategy {


    private final Random rand;
    CalculateDamageBallistaStrategy() {
        this(new Random());
    }

    CalculateDamageBallistaStrategy(Random aRandomizer) {
        super(aRandomizer);
        rand = aRandomizer;
    }

    @Override
    public int calculateDamage(Attacker aAttacker, Defender aDefender, Hero hero) {
        Random rand=new Random();
        int damage = rand.nextInt(aAttacker.getDamage().upperEndpoint() - aAttacker.getDamage().lowerEndpoint()+1) + aAttacker.getDamage().lowerEndpoint();
        return damage * (hero.getAttack() + 1);

    }


    @Override
    double changeDamageAfter(double aWholeStackDamageToDeal, Attacker aAttacker, Defender aDefender) {
        return 0;
    }
}
