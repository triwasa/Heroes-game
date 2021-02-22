package pl.sdk;

import pl.sdk.creatures.BattleObject;
import pl.sdk.special_fields.Field;

import java.util.LinkedList;
import java.util.List;

public class TeleportMovementStrategy implements MovementStrategy {

    public static final String TELEPORT = "TELEPORT";
    @Override
    public boolean canMove(Board board, BattleObject aCreature, Point targetPoint) {
        Point currentPoint = board.get(aCreature);
        return currentPoint.distance(targetPoint) <= aCreature.getMoveRange();
    }

    @Override
    public LinkedList<Point> getPath(Board board, Point aSourcePoint, Point aTargetPoint) {
        return (LinkedList<Point>) List.of(aSourcePoint, aTargetPoint);
    }

    @Override
    public void move(BattleObject aCreature, Point aTargetPoint, Board board) {
        Point aSourcePoint = board.get(aCreature);
        List<Point> pathToGo = getPath(board, aSourcePoint, aTargetPoint);
    }


}
