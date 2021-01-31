package pl.sdk.creatures;

public class MulitpleAttackAttackStrategy extends AbstractAttackStrategy {

    private int attackCount;

    MulitpleAttackAttackStrategy(int aAttackCount) {
        attackCount = aAttackCount;
    }

    @Override
    public void beforeAttack(AttackingBattleObject aAttacker, DefendingBattleObject aDefender) {
        return;
    }

    @Override
    public void attack(AttackingBattleObject aAttacker, DefendingBattleObject aDefender) {
        for(int i = 0; i < attackCount; i++) {
            if (aAttacker.isAlive()){
                int damageToDeal = aAttacker.getCalculateDamage().calculateDamage(aAttacker,aDefender);
                aDefender.getDamageApplier().applyDamage(damageToDeal, aDefender);;
            }
        }
    }

    @Override
    public void afterAttack(AttackingBattleObject aAttacker, DefendingBattleObject aDefender) {
        aDefender.counterAttack(aAttacker);
    }
}
