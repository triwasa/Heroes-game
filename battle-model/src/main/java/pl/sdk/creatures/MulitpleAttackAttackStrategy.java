package pl.sdk.creatures;

public class MulitpleAttackAttackStrategy extends DefaultAttackStrategy {

    private int attackCount;
    private final AttackStrategy decoratedAttackStrategy;

    MulitpleAttackAttackStrategy(AttackStrategy attackStrategy,int aAttackCount) {
        attackCount = aAttackCount;
        decoratedAttackStrategy = attackStrategy;
    }

    @Override
    public void beforeAttack(Attacker aAttacker, Defender aDefender) {
        decoratedAttackStrategy.beforeAttack(aAttacker,aDefender);
    }

    @Override
    public void attack(Attacker aAttacker, Defender aDefender) {
        for(int i = 0; i < attackCount; i++) {
            if (aAttacker.isAlive()){
                int damageToDeal = aAttacker.getCalculateDamage().calculateDamage(aAttacker,aDefender);
                aDefender.getDamageApplier().applyDamage(damageToDeal, aDefender);;
            }
        }
    }

    @Override
    public void afterAttack(Attacker aAttacker, Defender aDefender) {
        decoratedAttackStrategy.afterAttack(aAttacker,aDefender);
    }
}
