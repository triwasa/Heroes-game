package pl.sdk.creatures;

import com.google.common.collect.Range;


class ShootingCreatureDecorator implements Attacker {

    private final Attacker decorated;

    ShootingCreatureDecorator(Attacker aDecorated){
        decorated = aDecorated;
    }

    @Override
    public boolean isAlive() {
        return decorated.isAlive();
    }

    @Override
    public int getCurrentHp() {
        return decorated.getCurrentHp();
    }

    @Override
    public String getName() {
        return decorated.getName();
    }

    @Override
    public String getMovementType() {
        return decorated.getMovementType();
    }

    @Override
    public AttackStrategy getAttackStrategy() {
        return decorated.getAttackStrategy();
    }

    @Override
    public CalculateDamageStrategy getCalculateDamage() {
        return decorated.getCalculateDamage();
    }

    @Override
    public boolean[][] getSplashRange() {
        return decorated.getSplashRange();
    }

    @Override
    public int getMoveRange() {
        return decorated.getMoveRange();
    }
    
    @Override
    public int getAttack() {
        return decorated.getAttack();
    }

    @Override
    public int getArmor() {
        return decorated.getArmor();
    }

    @Override
    public Range<Integer> getDamage() {
        return decorated.getDamage();
    }

    @Override
    public int getAmount() {
        return decorated.getAmount();
    }


    @Override
    public String toString() {
        return decorated.toString();
    }

    @Override
    public double getAttackRange() {
        return Double.MAX_VALUE;
    }

    @Override
    public boolean canFortificationAttack() {
        return false;
    }

    @Override
    public boolean canCreatureAttack() {
        return false;
    }

    @Override
    public int getMaxHp() {
        return decorated.getMaxHp();
    }

}
