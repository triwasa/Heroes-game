package pl.sdk.creatures;

public interface BattleObjectStatistic {

    String getName();
    int getAmount();
    int getMaxHp();
    int getCurrentHp();
    boolean[][] getSplashRange();
    DamageApplierIf getDamageApplier();
}
