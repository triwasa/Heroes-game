package pl.sdk;

import pl.sdk.creatures.BattleObject;
import pl.sdk.special_fields.Field;

import java.util.LinkedList;
import java.util.List;

public class FlyingMovementStrategy implements MovementStrategy {
    public static final String FLYING = "FLYING";
    LinkedList<Point> pointsToGo = new LinkedList<>();

    @Override
    public boolean canMove(Board board, BattleObject aCreature, Point targetPoint) {
        pointsToGo = new FlyingPathSearch(board).pathSearch(board.get(aCreature), targetPoint);
        int modifiedMoveRange = modifyMoveRange(pointsToGo, aCreature);
        return board.distance(pointsToGo) <= modifiedMoveRange && board.getField(targetPoint.getX(),targetPoint.getY()).getCanStand();
    }

    @Override
    public LinkedList<Point> getPath(Board board, Point aSourcePoint, Point aTargetPoint) {
        return new FlyingPathSearch(board).pathSearch(aSourcePoint,aTargetPoint);
    }

    @Override
    public void move(BattleObject aCreature, Point aTargetPoint, Board board) {
        List<Point> path = getPath(board, board.get(aCreature), aTargetPoint);
        path.remove(0);
        for(Point point : path) {
            Field field = board.getField(point.getX(), point.getY());
            if(field.isFlyingField()) {
                field.apply(aCreature);
            }
       }

    }




}
