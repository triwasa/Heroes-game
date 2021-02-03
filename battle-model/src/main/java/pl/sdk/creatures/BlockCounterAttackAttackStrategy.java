package pl.sdk.creatures;

public class BlockCounterAttackAttackStrategy extends DefaultAttackStrategy {

    private final AttackStrategy decoratedAttackStrategy;
    BlockCounterAttackAttackStrategy(AttackStrategy aDecoratedAttackStrategy) {
        decoratedAttackStrategy = aDecoratedAttackStrategy;
    }
    @Override
    public void beforeAttack(Attacker aAttacker, Defender aDefender) {
        return;
    }

    @Override
    public void attack(Attacker aAttacker, Defender aDefender) {
        if (aAttacker.isAlive()){
            beforeAttack(aAttacker,aDefender);
            int damageToDeal = aAttacker.getCalculateDamage().calculateDamage(aAttacker,aDefender);
            aDefender.getDamageApplier().calculateDamageToApply(damageToDeal, aDefender);
            decoratedAttackStrategy.afterAttack(aAttacker,aDefender);
        }
    }


    @Override
    public void afterAttack(Attacker aAttacker, Defender aDefender) {
        return;
    }

}
