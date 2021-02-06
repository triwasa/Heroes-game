package pl.sdk.creatures;

public class MulitpleAttackAttackStrategy extends DefaultAttackStrategy {

    private int attackCount;
    private final AttackStrategy decoratedAttackStrategy;

    MulitpleAttackAttackStrategy(AttackStrategy attackStrategy,int aAttackCount) {
        attackCount = aAttackCount;
        decoratedAttackStrategy = attackStrategy;
    }

    @Override
    public void beforeAttack(BattleObject aAttacker, BattleObject aDefender) {
        return;
    }

    @Override
    public void attack(BattleObject aAttacker, BattleObject aDefender) {
        for(int i = 0; i < attackCount; i++) {
            beforeAttack(aAttacker,aDefender);
            decoratedAttackStrategy.attack(aAttacker,aDefender);
            afterAttack(aAttacker,aDefender);
        }
    }

    @Override
    public void afterAttack(BattleObject aAttacker, BattleObject aDefender) {
        return;
    }
}
