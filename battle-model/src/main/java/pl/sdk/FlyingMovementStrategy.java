package pl.sdk;

import pl.sdk.creatures.GuiTile;

public class FlyingMovementStrategy implements MovementStrategy {
    @Override
    public boolean canMove(Board board, GuiTile aCreature, Point targetPoint) {
        Point currentPoint = board.get(aCreature);
        return currentPoint.distance(targetPoint) <= aCreature.getMoveRange();
    }
}
