package pl.sdk.creatures;

public abstract class AbstractAttackStrategy implements AttackStrategy {

    public abstract void beforeAttack(AttackingBattleObject aAttacker, DefendingBattleObject aDefender);

    @Override
    public void attack(AttackingBattleObject aAttacker, DefendingBattleObject aDefender) {
        if (aAttacker.isAlive()){
            beforeAttack(aAttacker,aDefender);
            int damageToDeal = aAttacker.getCalculateDamage().calculateDamage(aAttacker,aDefender);
            aDefender.getDamageApplier().applyDamage(damageToDeal, aDefender);
            afterAttack(aAttacker,aDefender);
        }
    }


    public abstract void afterAttack(AttackingBattleObject aAttacker, DefendingBattleObject aDefender);
}
