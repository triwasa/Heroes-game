package pl.sdk.creatures;

import pl.sdk.MovementStrategy;

public interface BattleObjectStatistic {

    boolean isAlive();
    String getName();
    int getArmor();
    int getAmount();
    int getMaxHp();
    int getCurrentHp();
    boolean[][] getSplashRange();
    int getLevel();
    String getMovementType();
    int getMoveRange();
}
