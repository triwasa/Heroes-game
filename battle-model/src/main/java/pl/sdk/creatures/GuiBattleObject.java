package pl.sdk.creatures;

import pl.sdk.Point;

public interface GuiBattleObject extends BattleObject {
    String getName();
    boolean canMove(Point point);
    boolean canAttack(Point point);
    int getAmount();
}
