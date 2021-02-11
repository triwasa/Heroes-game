package pl.sdk.creatures;

import pl.sdk.hero.Hero;

import java.util.Random;

public  class ballistickAttackStrategy implements AttackStrategy {

    Random rand;
    int percentToDealDoubleDamage;
    boolean secondHit;

    ballistickAttackStrategy(int aTier){
        rand = new Random();
        switch (aTier){
            case 1:{
                percentToDealDoubleDamage = 60;
                secondHit = false;
                break;
            }
            case 2:{
                percentToDealDoubleDamage = 60;
                secondHit = true;
            }
            case 3:{
                percentToDealDoubleDamage = 100;
                secondHit = false;
            }
        }
    }

    ballistickAttackStrategy(Random aRand, int aPercent, boolean aSecondHit){
        rand = aRand;
        percentToDealDoubleDamage = aPercent;
        secondHit = aSecondHit;
    }

    public void beforeAttack(BattleObject aAttacker, BattleObject aDefender) {

    }

    public void attack(BattleObject aAttacker, BattleObject aDefender) {
        if (aAttacker.isAlive()){
            int damageToDeal;
            int roll = (rand.nextInt(100) +1);
            if (roll <= percentToDealDoubleDamage){
                CalculateDamageStrategy maxDamageCalculator = new MaxCalculateDamageStrategy(new Random());
                damageToDeal = maxDamageCalculator.calculateDamage(aAttacker, aDefender);
            }
            else{
                damageToDeal = aAttacker.getCalculateDamage().calculateDamage(aAttacker, aDefender);
            }
            aDefender.getDamageApplier().calculateDamageToApply(damageToDeal, aDefender);
            afterAttack(aAttacker,aDefender);
            if (secondHit){
                roll = (rand.nextInt(100) +1);
                if (roll <= percentToDealDoubleDamage){
                    CalculateDamageStrategy maxDamageCalculator = new MaxCalculateDamageStrategy(new Random());
                    damageToDeal = maxDamageCalculator.calculateDamage(aAttacker, aDefender);
                }
                else{
                    damageToDeal = aAttacker.getCalculateDamage().calculateDamage(aAttacker, aDefender);
                }
                aDefender.getDamageApplier().calculateDamageToApply(damageToDeal, aDefender);
                afterAttack(aAttacker,aDefender);
            }
        }
    }

    @Override
    public void attack(BattleObject aAttacker, BattleObject aDefender, Hero aHero) {

    }

    public void afterAttack(BattleObject aAttacker, BattleObject aDefender) {

    }

    public void counterAttack(BattleObject aAttacker, BattleObject aDefender) {
        if (aDefender.canCounterAttack()){
            int damageToDealInCounterAttack = aDefender.getCalculateDamage().calculateDamage(aDefender, aAttacker);
            aAttacker.getDamageApplier().calculateDamageToApply(damageToDealInCounterAttack, aAttacker);
            aDefender.counterAttackedInThisTurn();
        }
    }

}
