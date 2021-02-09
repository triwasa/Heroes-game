package pl.sdk.creatures;

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
}
