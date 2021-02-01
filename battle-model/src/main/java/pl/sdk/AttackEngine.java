package pl.sdk;

import pl.sdk.creatures.*;

public class AttackEngine {
    Board board;


    public AttackEngine(Board aBoard) {
        board = aBoard;
    }

    public void attack(BattleObject aAttacker, BattleObject aDefender) {
            aAttacker.getAttackStrategy().attack(aAttacker, aDefender);
    }

    public void attack(Creature aAttacker, int aX, int aY) {
        boolean[][] splashRange = aAttacker.getSplashRange();
        for (int x = 0; x < splashRange.length; x++) {
            for (int y = 0; y < splashRange.length; y++) {
                if (splashRange[x][y]) {
                    BattleObject attackedCreature = board.get(aX + x - 1, aY + y - 1);
                    if (attackedCreature != null){
                       attack(aAttacker,  attackedCreature);
                    }
                }
            }
        }
    }

    public boolean canAttack(CreatureAttacker attacker, Defender possibleDefender) {
        return possibleDefender.attackable(attacker);
    }
    public boolean canAttack(FortificationAttacker attacker, Defender possibleDefender) {
        return possibleDefender.attackable(attacker);
    }




}

