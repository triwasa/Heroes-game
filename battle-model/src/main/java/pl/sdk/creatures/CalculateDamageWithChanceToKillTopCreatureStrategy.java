package pl.sdk.creatures;

import java.util.Random;

public class CalculateDamageWithChanceToKillTopCreatureStrategy extends AbstractCalculateDamageStrategy {

    double chanceToKill;

    CalculateDamageWithChanceToKillTopCreatureStrategy(double aChanceToKill) {
        this(aChanceToKill, new Random());
    }

    CalculateDamageWithChanceToKillTopCreatureStrategy(double aChanceToKill, Random aRand) {
        super(aRand);
        chanceToKill = aChanceToKill;
    }

    @Override
    double changeDamageAfter(double aWholeStackDamageToDeal, CreatureAttacker aAttacker, CreatureDefender aDefender) {
        int amount = aAttacker.getAmount();
        int attempts;
        
        if(aAttacker.getAmount() % 10 == 0) {
            attempts = aAttacker.getAmount() / 10;
        }
        else {
            attempts = (aAttacker.getAmount() / 10) + 1;
        }

        double realChanceToKill;

        for(int i = 0; i < attempts; i++) {
            if(amount > 10) amount = 10;
             realChanceToKill = 1 - Math.pow((1 - chanceToKill), amount);
             if(getRand().nextDouble() <= realChanceToKill) {
                 aWholeStackDamageToDeal = aWholeStackDamageToDeal + aDefender.getMaxHp();
             }
             amount = aAttacker.getAmount() - (10 * i + 1);
        }
        return aWholeStackDamageToDeal;
    }
}
