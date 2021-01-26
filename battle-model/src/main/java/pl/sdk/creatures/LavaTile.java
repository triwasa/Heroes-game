package pl.sdk.creatures;

public class LavaTile implements GuiTile {


    final private String name = "Lava";

    public LavaTile()
    {}
    @Override
    public boolean isMovePossible() {
        return false;
    }

    @Override
    public boolean isAttackPossible() {
        return false;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAmount() {
        return 0;
    }

    @Override
    public boolean isItObstacle() {
        return true;
    }

    @Override
    public int getMoveRange() {
        return 0;
    }

    @Override
    public String getMovementType() {
        return "null";
    }


}