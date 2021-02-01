package pl.sdk.creatures;



public interface Fortification {

    DamageApplierIf getDamageApplier();
    boolean isAlive();
    int getLevel();
    int getCurrentHp();
    int getMaxHp();
    void currentHpAfterAttack(int currentHp);

}
