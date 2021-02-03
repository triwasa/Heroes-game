package pl.sdk.creatures;

public class HealAfterAttackAttackStrategy extends DefaultAttackStrategy {

    private double selfHealingPercentage;
    private final AttackStrategy decoratedAttackStrategy;

    HealAfterAttackAttackStrategy(AttackStrategy attackStrategy, double aSelfHealingPercentage) {
        selfHealingPercentage = aSelfHealingPercentage;
        decoratedAttackStrategy = attackStrategy;
    }
    @Override
    public void beforeAttack(Attacker aAttacker, Defender aDefender) {
        decoratedAttackStrategy.beforeAttack(aAttacker,aDefender);
    }

    @Override
    public void attack(Attacker aAttacker, Defender aDefender) {
        decoratedAttackStrategy.attack(aAttacker, aDefender);
    }

    @Override
    public void afterAttack(Attacker aAttacker, Defender aDefender) {
        healAfterAttack(aAttacker,aDefender);
        decoratedAttackStrategy.afterAttack(aAttacker,aDefender);
    }
    public void healAfterAttack(Attacker aAttacker, Defender aDefender) {
        int damageToDeal = aAttacker.getCalculateDamage().calculateDamage(aAttacker, aDefender);
        aDefender.getDamageApplier().calculateDamageToApply((int)(-damageToDeal * selfHealingPercentage), aDefender);
    }
}
