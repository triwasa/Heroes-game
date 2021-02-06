package pl.sdk.creatures;

public class BlockCounterAttackAttackStrategy extends DefaultAttackStrategy {

    private final AttackStrategy decoratedAttackStrategy;
    BlockCounterAttackAttackStrategy(AttackStrategy aDecoratedAttackStrategy) {
        decoratedAttackStrategy = aDecoratedAttackStrategy;
    }
    @Override
    public void beforeAttack(BattleObject aAttacker, BattleObject aDefender) {
        decoratedAttackStrategy.afterAttack(aAttacker,aDefender);
        return;
    }

    @Override
    public void attack(BattleObject aAttacker, BattleObject aDefender) {
        if (aAttacker.isAlive()){
            beforeAttack(aAttacker,aDefender);
            int damageToDeal = aAttacker.getCalculateDamage().calculateDamage(aAttacker,aDefender);
            aDefender.getDamageApplier().calculateDamageToApply(damageToDeal, aDefender);
            afterAttack(aAttacker,aDefender);
        }
    }


    @Override
    public void afterAttack(BattleObject aAttacker, BattleObject aDefender) {
        decoratedAttackStrategy.afterAttack(aAttacker,aDefender);
        return;
    }

}
