package pl.sdk;

import pl.sdk.creatures.Creature;

public class AttackEngine {
    Board board;
    AbstractDamageApplier damageApplier;


    AttackEngine(Board aBoard) {
        board = aBoard;
        damageApplier = new DefaultDamageApplier();
    }
    public void attack(Creature)
    public void attackField(Creature aAttacker, Creature aDefender) {
        if (aAttacker.isAlive()) {
            int damageToDeal = aAttacker.calculateDamage(aAttacker, aDefender);
            aDefender.applyDamage(damageToDeal);
            aAttacker.counterAttack(aDefender);
        }
    }

    void counterAttack(Creature aCounterAttacker, Creature aDefender ) {
        if (aDefender.canCounterAttack()){
            int damageToDealInCounterAttack = aDefender.calculateDamage(aDefender, this);
            damageApplier.applyDamage(damageToDealInCounterAttack, aDefender);
            aDefender.counterAttackedInThisTurn();
        }
    }
}
