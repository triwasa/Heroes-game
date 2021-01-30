package pl.sdk.creatures;

public class DefaultAttackStrategy extends AbstractAttackStrategy {
    @Override
    public void beforeAttack(AttackingBattleObject aAttacker, DefendingBattleObject aDefender) {
        return;
    }

    @Override
    public void afterAttack(AttackingBattleObject aAttacker, DefendingBattleObject aDefender) {
        aDefender.counterAttack(aAttacker);
    }
}
