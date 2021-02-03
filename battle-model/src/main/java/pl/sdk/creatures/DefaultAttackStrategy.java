package pl.sdk.creatures;

public class DefaultAttackStrategy implements AttackStrategy {

    public void beforeAttack(Attacker aAttacker, Defender aDefender) {
        return;
    }

    public void attack(Attacker aAttacker, Defender aDefender) {
        if (aAttacker.isAlive()){
            beforeAttack(aAttacker,aDefender);
            int damageToDeal = aAttacker.getCalculateDamage().calculateDamage(aAttacker,aDefender);
            aDefender.getDamageApplier().applyDamage(damageToDeal, aDefender);
            afterAttack(aAttacker,aDefender);
        }
    }


    public void afterAttack(Attacker aAttacker, Defender aDefender) {
        aDefender.counterAttack(aAttacker);
    }
}
