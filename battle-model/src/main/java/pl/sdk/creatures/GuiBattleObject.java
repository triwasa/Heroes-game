package pl.sdk.creatures;

import pl.sdk.Point;

public interface GuiBattleObject {
    String getName();
    boolean canMove(Point point);
    boolean canAttack(Point point);
    int getAmount();
}
