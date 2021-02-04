package pl.sdk.creatures;


import com.google.common.collect.Range;

public class Catapult implements BattleObject {

    private CreatureStatisticIf stats;
    private int currentHp;
    private int level;
    private PossbileAttackMangerIf possibleAttacKManager;

    Catapult() {
        possibleAttacKManager = new PossbileAttackManagerForFortification();
    }


    @Override
    public AttackStrategy getAttackStrategy() {
        return null;
    }

    @Override
    public CalculateDamageStrategy getCalculateDamage() {
        return null;
    }

    @Override
    public Range<Integer> getDamage() {
        return null;
    }

    @Override
    public int getAttack() {
        return 0;
    }

    @Override
    public double getAttackRange() {
        return 0;
    }

    @Override
    public boolean canFortifficationAttack() {
        return possibleAttacKManager.canFortifficationAttack();
    }

    @Override
    public boolean canCreatureAttack() {
        return possibleAttacKManager.canCreatureAttack();
    }

    @Override
    public DamageApplierIf getDamageApplier() {
        return null;
    }

    @Override
    public void applyDamage(int damageToApply) {

    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public String getMovementType() {
        return null;
    }

    @Override
    public int getMoveRange() {
        return 0;
    }

    @Override
    public boolean isAlive() {
        return false;
    }

    @Override
    public int getCurrentHp() {
        return 0;
    }

    @Override
    public boolean[][] getSplashRange() {
        return new boolean[0][];
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getAmount() {
        return 0;
    }

    @Override
    public int getMaxHp() {
        return 0;
    }



    @Override
    public int getArmor() {
        return 0;
    }



    @Override
    public boolean isCreature() {
        return true;
    }

    @Override
    public boolean isFortification() {
        return false;
    }

    @Override
    public void counterAttack(BattleObject attacker) {

    }
}
