package pl.sdk;

import pl.sdk.creatures.BattleObject;
import pl.sdk.special_fields.Field;

import java.util.LinkedList;
import java.util.List;

public class GroundMovementStrategy implements MovementStrategy {
    public static final String GROUND = "GROUND";
    LinkedList<Point> pointsToGo = new LinkedList<>();

    @Override
    public boolean canMove(Board board, BattleObject aCreature, Point targetPoint) {
        pointsToGo = new GroundPathSearch(board).pathSearch(board.get(aCreature), targetPoint);
            return distance(pointsToGo) <= aCreature.getMoveRange();
    }

    @Override
    public LinkedList<Point> getPath(Board board,Point aSourcePoint, Point aTargetPoint) {
        return new GroundPathSearch(board).pathSearch(aSourcePoint,aTargetPoint);
    }


    public void move(BattleObject aCreature, Point aTargetPoint, Board board) {
        List<Point> path = getPath(board, board.get(aCreature), aTargetPoint);
        path.remove(0);
        for(Point point : path) {
//            if(board.getField(point.getX(),point.getY()).isGroundField()) {
//                Field field = board.getField(point.getX(), point.getY());
//                field.apply(aCreature);
//            }
        }
    }

    //might be moved to other class like "MovePath" or smh
    private double distance(LinkedList<Point> path) {
        if(path.size() == 0 ){
            return Integer.MAX_VALUE;
        }
        double distance = 0;
        Point aPoint = path.get(0);
        for(Point aPoint1 : path) {
            distance = distance + aPoint.distance(aPoint1);
            aPoint = aPoint1;
        }
        return distance;
    }
}
