package pl.sdk.creatures;

public class HealAfterAttackAttackStrategy extends AbstractAttackStrategy {

    private double selfHealingPercentage;

    HealAfterAttackAttackStrategy(double aSelfHealingPercentage) {
        selfHealingPercentage = aSelfHealingPercentage;
    }
    @Override
    public void beforeAttack(BattleObject aAttacker, BattleObject aDefender) {
        return;
    }



    @Override
    public void afterAttack(BattleObject aAttacker, BattleObject aDefender) {
        healAfterAttack(aAttacker,aDefender);
        aDefender.counterAttack(aAttacker);
    }
    public void healAfterAttack(BattleObject aAttacker, BattleObject aDefender) {
        int damageToDeal = aAttacker.getCalculateDamage().calculateDamage(aAttacker, aDefender);
        aDefender.getDamageApplier().applyDamage((int)(-damageToDeal * selfHealingPercentage), aDefender);
    }
}
