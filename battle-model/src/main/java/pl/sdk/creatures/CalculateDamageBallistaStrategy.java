package pl.sdk.creatures;

import pl.sdk.hero.Hero;

import java.util.Random;

public class CalculateDamageBallistaStrategy extends AbstractCalculateDamageStrategy {


    private static final Random rand= new Random();
    private int heroAttack;

    CalculateDamageBallistaStrategy(int heroAttack) {
        super(rand);
        this.heroAttack = heroAttack;
    }

    @Override
    public int calculateDamage(Attacker aAttacker, Defender aDefender) {
        Random rand=new Random();
        int damage = rand.nextInt(aAttacker.getDamage().upperEndpoint() - aAttacker.getDamage().lowerEndpoint()+1) + aAttacker.getDamage().lowerEndpoint();
        return damage * (heroAttack + 1);

    }


    @Override
    double changeDamageAfter(double aWholeStackDamageToDeal, Attacker aAttacker, Defender aDefender) {
        return 0;
    }
}
