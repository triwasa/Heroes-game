package pl.sdk.creatures;

public class Wall implements Fortification {

    private int maxHp = 2;
    private int currentHp = 2;
    private int amount = 1;
    private int level = 1;



    public boolean isMovePossible() {
        return false;
    }


    public boolean isAttackPossible() {
        return false;
    }

    @Override
    public String getName() {
        return "Wall";
    }

    @Override
    public int getAmount() {
        if(currentHp > 0){
            return 1;
        }
        else return 0;
    }

    @Override
    public int getLevel() {
        return level;
    }


    public boolean isItObstacle() {
        return true;
    }


    public int getMoveRange() {
        return 0;
    }

    @Override
    public int getCurrentHp() {
        return currentHp;
    }

    @Override
    public int getMaxHp() {
        return maxHp;
    }


    public void applyDamage(int aDamageToApply) {
        int fullCurrentHp = currentHp - aDamageToApply;
        if (fullCurrentHp <= 0) {
            amount = 0;
            currentHp = 0;
        }
            else
        {
            currentHp = fullCurrentHp;
        }
    }

    @Override
    public void counterAttack(Attacker aDefender) {
        return;
    }

}
