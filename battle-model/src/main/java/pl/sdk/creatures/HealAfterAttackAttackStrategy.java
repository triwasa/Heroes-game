package pl.sdk.creatures;

public class HealAfterAttackAttackStrategy extends DefaultAttackStrategy {

    private double selfHealingPercentage;
    private final AttackStrategy decoratedAttackStrategy;

    HealAfterAttackAttackStrategy(AttackStrategy attackStrategy, double aSelfHealingPercentage) {
        selfHealingPercentage = aSelfHealingPercentage;
        decoratedAttackStrategy = attackStrategy;
    }
    @Override
    public void beforeAttack(BattleObject aAttacker, BattleObject aDefender) {
        decoratedAttackStrategy.beforeAttack(aAttacker,aDefender);
    }

    @Override
    public void attack(BattleObject aAttacker, BattleObject aDefender) {
        decoratedAttackStrategy.attack(aAttacker, aDefender);
    }

    @Override
    public void afterAttack(BattleObject aAttacker, BattleObject aDefender) {
        healAfterAttack(aAttacker,aDefender);
        decoratedAttackStrategy.afterAttack(aAttacker,aDefender);
    }
    public void healAfterAttack(BattleObject aAttacker, BattleObject aDefender) {
        int damageToDeal = aAttacker.getCalculateDamage().calculateDamage(aAttacker, aDefender);
        aDefender.getDamageApplier().applyDamage((int)(-damageToDeal * selfHealingPercentage), aDefender);
    }
}
