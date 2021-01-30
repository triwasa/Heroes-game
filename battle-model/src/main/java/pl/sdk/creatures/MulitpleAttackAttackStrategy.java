package pl.sdk.creatures;

public class MulitpleAttackAttackStrategy implements AttackStrategy {

    private int attackCount;

    MulitpleAttackAttackStrategy(int aAttackCount) {
        attackCount = aAttackCount;
    }
    @Override
    public void attack(AttackingBattleObject aAttacker, DefendingBattleObject aDefender) {
        for(int i = 0; i < attackCount; i++) {
            if (aAttacker.isAlive()){
                int damageToDeal = aAttacker.getCalculateDamage().calculateDamage(aAttacker,aDefender);
                aDefender.getApplyDamage().applyDamage(damageToDeal, aDefender);
                aDefender.counterAttack(aAttacker);
            }
        }
    }
}
