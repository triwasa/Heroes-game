package pl.sdk.creatures;

public class DefaultAttackStrategy implements AttackStrategy {

    public void beforeAttack(BattleObject aAttacker, BattleObject aDefender) {
        return;
    }

    public void attack(BattleObject aAttacker, BattleObject aDefender) {
        if (aAttacker.isAlive()){
            beforeAttack(aAttacker,aDefender);
            int damageToDeal = aAttacker.getCalculateDamage().calculateDamage(aAttacker,aDefender);
            aDefender.getDamageApplier().applyDamage(damageToDeal, aDefender);
            afterAttack(aAttacker,aDefender);
        }
    }


    public void afterAttack(BattleObject aAttacker, BattleObject aDefender) {
        aDefender.counterAttack(aAttacker);
    }
}
