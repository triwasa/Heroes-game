package pl.sdk;

import pl.sdk.creatures.*;

public class AttackEngine {
    Board board;
    AbstractDamageApplier damageApplier;
    AttackStrategy attackStrategy;


    AttackEngine(Board aBoard) {
        board = aBoard;
        damageApplier = new DefaultDamageApplier();
    }
    public void attack(AttackingBattleObject aAttacker, DefendingBattleObject aDefender) {
        if (aAttacker.isAlive()) {
            attackStrategy = aAttacker.getAttackStrategy();
            attackStrategy.attack(aAttacker,aDefender);
        }
    }
    public void attack(Creature aAttacker, int aX, int aY) {
        boolean[][] splashRange = aAttacker.getSplashRange();
        for (int x = 0; x < splashRange.length; x++) {
            for (int y = 0; y < splashRange.length; y++) {
                if (splashRange[x][y]) {
                    BattleObject attackedCreature = board.get(aX + x - 1, aY + y - 1);
                    if (attackedCreature != null){
                       attack(aAttacker, board.get(aX + x - 1, aY + y - 1));
                    }
                }
            }
        }
    }

    /*void counterAttack(Creature aCounterAttacker, Creature aDefender ) {
        if (aDefender.canCounterAttack()) {
            int damageToDealInCounterAttack = aDefender.calculateDamage(aDefender, this);
            damageApplier.applyDamage(damageToDealInCounterAttack, aDefender);
            aDefender.counterAttackedInThisTurn();
        }
    }*/
}

