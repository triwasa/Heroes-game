package pl.sdk.creatures;

import pl.sdk.hero.Hero;

import java.util.Random;

public class HealCalculateDamageStrategy implements CalculateDamageStrategy {





    @Override
    public int calculateDamage(Attacker aAttacker, Defender aDefender) {
        Random rand=new Random();
        int healValue = rand.nextInt(aAttacker.getDamage().upperEndpoint() - aAttacker.getDamage().lowerEndpoint()+1) + aAttacker.getDamage().lowerEndpoint();
        int hpDifference = aDefender.getMaxHp() - aDefender.getCurrentHp();
        if (hpDifference < healValue){
            healValue = hpDifference;
        }
        return -healValue;


    }

    @Override
    public int calculateDamage(Attacker attacker, Defender aDefender, Hero hero) {
        return 0;
    }
}
