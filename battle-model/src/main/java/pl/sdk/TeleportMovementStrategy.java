package pl.sdk;

import pl.sdk.creatures.GuiTile;

import java.util.LinkedList;

public class TeleportMovementStrategy implements MovementStrategy {
    public static final String TELEPORT = "TELEPORT";
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
