package pl.sdk.creatures;

public abstract class AbstractAttackStrategy implements AttackStrategy {

    public abstract void beforeAttack(BattleObject aAttacker, BattleObject aDefender);

    @Override
    public void attack(BattleObject aAttacker, BattleObject aDefender) {
        if (aAttacker.isAlive()){
            beforeAttack(aAttacker,aDefender);
            int damageToDeal = aAttacker.getCalculateDamage().calculateDamage(aAttacker,aDefender);
            aDefender.getDamageApplier().applyDamage(damageToDeal, aDefender);
            afterAttack(aAttacker,aDefender);
        }
    }


    public abstract void afterAttack(BattleObject aAttacker, BattleObject aDefender);
}
