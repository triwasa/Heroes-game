package pl.sdk.creatures;

public class HealAfterAttackAttackStrategy extends AbstractAttackStrategy {

    private double selfHealingPercentage;

    HealAfterAttackAttackStrategy(double aSelfHealingPercentage) {
        selfHealingPercentage = aSelfHealingPercentage;
    }
    @Override
    public void beforeAttack(AttackingBattleObject aAttacker, DefendingBattleObject aDefender) {
        return;
    }



    @Override
    public void afterAttack(AttackingBattleObject aAttacker, DefendingBattleObject aDefender) {
        healAfterAttack(aAttacker,aDefender);
        aDefender.counterAttack(aAttacker);
    }
    public void healAfterAttack(AttackingBattleObject aAttacker, DefendingBattleObject aDefender) {
        int damageToDeal = aAttacker.getCalculateDamage().calculateDamage(aAttacker, aDefender);
        aDefender.getDamageApplier().applyDamage((int)(-damageToDeal * selfHealingPercentage), aDefender);
    }
}
