package pl.sdk.creatures;

public class MulitpleAttackAttackStrategy extends AbstractAttackStrategy {

    private int attackCount;

    MulitpleAttackAttackStrategy(int aAttackCount) {
        attackCount = aAttackCount;
    }

    @Override
    public void beforeAttack(BattleObject aAttacker, BattleObject aDefender) {
        return;
    }

    @Override
    public void attack(BattleObject aAttacker, BattleObject aDefender) {
        for(int i = 0; i < attackCount; i++) {
            if (aAttacker.isAlive()){
                int damageToDeal = aAttacker.getCalculateDamage().calculateDamage(aAttacker,aDefender);
                aDefender.getDamageApplier().applyDamage(damageToDeal, aDefender);;
            }
        }
    }

    @Override
    public void afterAttack(BattleObject aAttacker, BattleObject aDefender) {
        aDefender.counterAttack(aAttacker);
    }
}
