package pl.sdk.creatures;

public class DefaultAttackStrategy extends AbstractAttackStrategy {
    @Override
    public void beforeAttack(BattleObject aAttacker, BattleObject aDefender) {
        return;
    }

    @Override
    public void afterAttack(BattleObject aAttacker, BattleObject aDefender) {
        aDefender.counterAttack(aAttacker);
    }
}
