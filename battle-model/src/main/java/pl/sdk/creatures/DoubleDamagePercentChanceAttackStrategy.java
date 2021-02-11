package pl.sdk.creatures;

import org.w3c.dom.ranges.Range;
import pl.sdk.hero.Hero;

import java.util.Random;

public  class DoubleDamagePercentChanceAttackStrategy implements AttackStrategy {

    private int chanceToDealDoubleDamage;
    private Random rand;

    DoubleDamagePercentChanceAttackStrategy(int aChance){
        chanceToDealDoubleDamage = aChance;
        rand = new Random();
    }

    DoubleDamagePercentChanceAttackStrategy(int aChance, Random aRand){
        chanceToDealDoubleDamage = aChance;
        rand = aRand;
    }

    public void beforeAttack(BattleObject aAttacker, BattleObject aDefender) {
        return;
    }

    public void attack(BattleObject aAttacker, BattleObject aDefender) {
        if (aAttacker.isAlive()){
            beforeAttack(aAttacker,aDefender);
            int damageToDeal = aAttacker.getCalculateDamage().calculateDamage(aAttacker,aDefender);
            int roll = (rand.nextInt(100) + 1);
            if (roll <= chanceToDealDoubleDamage){
                damageToDeal = damageToDeal * 2;
            }
            aDefender.getDamageApplier().calculateDamageToApply(damageToDeal, aDefender);
            afterAttack(aAttacker,aDefender);
            counterAttack(aAttacker,aDefender);
        }
    }


    public void afterAttack(BattleObject aAttacker, BattleObject aDefender) {
        return;
    }

    public void counterAttack(BattleObject aAttacker, BattleObject aDefender) {
        if (aDefender.canCounterAttack()){
            int damageToDealInCounterAttack = aDefender.getCalculateDamage().calculateDamage(aDefender, aAttacker);
            aAttacker.getDamageApplier().calculateDamageToApply(damageToDealInCounterAttack, aAttacker);
            aDefender.counterAttackedInThisTurn();
        }
    }
}
