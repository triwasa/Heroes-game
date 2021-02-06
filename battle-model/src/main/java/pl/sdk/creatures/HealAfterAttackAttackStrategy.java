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
        return;
    }

    @Override
    public void attack(BattleObject aAttacker, BattleObject aDefender) {
        beforeAttack(aAttacker,aDefender);
        decoratedAttackStrategy.attack(aAttacker, aDefender);
        afterAttack(aAttacker,aDefender);
    }

    @Override
    public void afterAttack(BattleObject aAttacker, BattleObject aDefender) {
        healAfterAttack(aAttacker,aDefender);

    }
    private void healAfterAttack(Attacker aAttacker, Defender aDefender) {
        int damageToDeal = aAttacker.getCalculateDamage().calculateDamage(aAttacker, aDefender);
        aAttacker.getDamageApplier().calculateDamageToApply((int)(-damageToDeal * selfHealingPercentage), (Defender)aAttacker);
    }
}
