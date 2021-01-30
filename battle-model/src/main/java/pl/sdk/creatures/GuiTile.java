package pl.sdk.creatures;

public interface GuiTile {

    boolean isMovePossible();

    boolean isAttackPossible();

    String getName();

    int getAmount();

    boolean isItObstacle();

    int getMoveRange();

    String getMovementType();
}
