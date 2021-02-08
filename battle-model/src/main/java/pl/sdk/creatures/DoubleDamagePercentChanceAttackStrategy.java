package pl.sdk.creatures;

import java.util.Random;

public  class DoubleDamagePercentChanceAttackStrategy implements AttackStrategy {

    private int chanceToDealDoubleDamage;
    private Random rand;

    DoubleDamagePercentChanceAttackStrategy(int aChance){
        chanceToDealDoubleDamage = aChance;
        Random rand = new Random();
    }

    public void beforeAttack(BattleObject aAttacker, BattleObject aDefender) {
        return;
    }

    public void attack(BattleObject aAttacker, BattleObject aDefender) {
        if (aAttacker.isAlive()){
            beforeAttack(aAttacker,aDefender);
            int damageToDeal = aAttacker.getCalculateDamage().calculateDamage(aAttacker,aDefender);
            int roll = (rand.nextInt(100) + 1);
            if (roll > chanceToDealDoubleDamage){
                damageToDeal = damageToDeal * 2;
            }
            aDefender.getDamageApplier().calculateDamageToApply(damageToDeal, aDefender);
            afterAttack(aAttacker,aDefender);
            aDefender.counterAttack(aAttacker);
        }
    }

    public void afterAttack(BattleObject aAttacker, BattleObject aDefender) {
        return;
    }
}
