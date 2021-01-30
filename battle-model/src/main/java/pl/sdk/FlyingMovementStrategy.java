package pl.sdk;

import java.util.LinkedList;

public class FlyingMovementStrategy implements MovementStrategy {
    public static final String FLYING = "FLYING";
    @Override
    public boolean canMove(Board board, GuiTile aCreature, Point targetPoint) {
        Point currentPoint = board.get(aCreature);
        return currentPoint.distance(targetPoint) <= aCreature.getMoveRange();
    }

    @Override
    public LinkedList<Point> getPath(Board board, Point aSourcePoint, Point aTargetPoint) {
        return new LinkedList<>();
    }
}
