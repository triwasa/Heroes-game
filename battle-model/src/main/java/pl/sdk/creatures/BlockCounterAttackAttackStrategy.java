package pl.sdk.creatures;

import pl.sdk.creatures.AttackStrategy;
import pl.sdk.creatures.AttackingBattleObject;
import pl.sdk.creatures.DefendingBattleObject;

public class BlockCounterAttackAttackStrategy extends DefaultAttackStrategy {

    private final AttackStrategy decoratedAttackStrategy;
    BlockCounterAttackAttackStrategy(AttackStrategy aDecoratedAttackStrategy) {
        decoratedAttackStrategy = aDecoratedAttackStrategy;
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
        return;
    }

}
