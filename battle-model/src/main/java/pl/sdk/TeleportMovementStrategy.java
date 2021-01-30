package pl.sdk;

import java.util.LinkedList;
import java.util.List;

public class TeleportMovementStrategy implements MovementStrategy {
    public static final String TELEPORT = "TELEPORT";
    @Override
    public boolean canMove(Board board, GuiTile aCreature, Point targetPoint) {
        Point currentPoint = board.get(aCreature);
        return currentPoint.distance(targetPoint) <= aCreature.getMoveRange();
    }

    @Override
    public LinkedList<Point> getPath(Board board, Point aSourcePoint, Point aTargetPoint) {
        return (LinkedList<Point>) List.of(aSourcePoint);
    }
}
