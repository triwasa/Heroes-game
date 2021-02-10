package pl.sdk.creatures;

import pl.sdk.hero.Hero;

public class BallistaAttackStrategy implements AttackStrategy{

    @Override
    public void attack(BattleObject aAttacker, BattleObject aDefender, Hero aHero) {
        if (aAttacker.isAlive()){
            beforeAttack(aAttacker,aDefender);
            int damageToDeal = aAttacker.getCalculateDamage().calculateDamage(aAttacker,aDefender, aHero);
            aDefender.getDamageApplier().calculateDamageToApply(damageToDeal, aDefender);
            afterAttack(aAttacker,aDefender);

        }
    }

    @Override
    public void attack(BattleObject aAttacker, BattleObject aDefender) {

    }

    @Override
    public void beforeAttack(BattleObject aAttacker, BattleObject aDefender) {

    }

    @Override
    public void afterAttack(BattleObject aAttacker, BattleObject aDefender) {

    }
}
