package pl.sdk.creatures;

public class BlockCounterAttackAttackStrategy extends DefaultAttackStrategy {

    private final AttackStrategy decoratedAttackStrategy;
    BlockCounterAttackAttackStrategy(AttackStrategy aDecoratedAttackStrategy) {
        decoratedAttackStrategy = aDecoratedAttackStrategy;
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
        return;
    }

}
