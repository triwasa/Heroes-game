package pl.sdk.creatures;

public class DefaultAttackStrategy implements AttackStrategy {
    @Override
    public void attack(AttackingBattleObject aAttacker, DefendingBattleObject aDefender) {
        if (aAttacker.isAlive()){
            int damageToDeal = aAttacker.getCalculateDamage().calculateDamage(aAttacker,aDefender);
            aDefender.getApplyDamage().applyDamage(damageToDeal, aDefender);
            aDefender.counterAttack(aAttacker);
        }
    }
}
