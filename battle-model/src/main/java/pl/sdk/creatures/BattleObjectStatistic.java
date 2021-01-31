package pl.sdk.creatures;

public interface BattleObjectStatistic {

    String getName();
    int getAmount();
    int getMaxHp();
    int getLevel();
    int getCurrentHp();
    boolean isAlive();
    boolean[][] getSplashRange();
    DamageApplierIf getDamageApplier();
}
