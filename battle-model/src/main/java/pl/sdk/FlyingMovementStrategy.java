package pl.sdk;

import pl.sdk.creatures.BattleObject;
import pl.sdk.special_fields.Field;

import java.util.LinkedList;
import java.util.List;

public class FlyingMovementStrategy implements MovementStrategy {
    public static final String FLYING = "FLYING";
    @Override
    public boolean canMove(Board board, BattleObject aCreature, Point targetPoint) {
        Point currentPoint = board.get(aCreature);
        return currentPoint.distance(targetPoint) <= aCreature.getMoveRange();
    }

    @Override
    public LinkedList<Point> getPath(Board board, Point aSourcePoint, Point aTargetPoint) {
        return new LinkedList<>();
    }

    @Override
    public void move(BattleObject aCreature, Point aTargetPoint, Board board) {
        List<Point> path = getPath(board, board.get(aCreature), aTargetPoint);
        path.remove(0);
        for(Point point : path) {
            if(!board.getField(point.getX(),point.getY()).isGroundField()) {
                Field field = board.getField(point.getX(), point.getY());
            }
       }
        board.getGroundField(aTargetPoint.getX(),aTargetPoint.getY());
    }



}
