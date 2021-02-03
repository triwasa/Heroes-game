package pl.sdk;


import pl.sdk.creatures.*;

public class AttackEngine {
    Board board;


    public AttackEngine(Board aBoard) {
        board = aBoard;
    }

    private void attack(BattleObject aAttacker, BattleObject aDefender) {
            aAttacker.getAttackStrategy().attack(aAttacker, aDefender);
    }

    public void attack(BattleObject aAttacker, int aX, int aY) {
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

    public boolean canAttack(Attacker attacker, Defender possibleDefender) {
        if(possibleDefender.isCreature()) {
            return attacker.canCreatureAttack();
        }
        if(possibleDefender.isFortification()) {
            return attacker.canFortifficationAttack();
        }
        throw new IllegalArgumentException();
    }




}

