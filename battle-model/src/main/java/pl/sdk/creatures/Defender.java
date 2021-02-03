package pl.sdk.creatures;

public interface Defender extends BattleObjectStatistic {
    DamageApplierIf getDamageApplier();
    boolean isAlive();
    int getCurrentHp();
    int getMaxHp();
    void currentHpAfterAttack(int currentHp);
    int getArmor();
    void amountAfterAttack(int aAmount);
    boolean isCreature();
    boolean isFortification();
}
