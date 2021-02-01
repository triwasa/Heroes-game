package pl.sdk;

import pl.sdk.creatures.Creature;

import java.util.LinkedList;

public class GroundMovementStrategy implements MovementStrategy {
    public static final String GROUND = "GROUND";
    LinkedList<Point> pointsToGo = new LinkedList<>();

    @Override
    public boolean canMove(Board board, Creature aCreature, Point targetPoint) {
        pointsToGo = new PathSearch(board).pathSearch(board.get(aCreature), targetPoint);
            return distance(pointsToGo) <= aCreature.getMoveRange();
    }

    @Override
    public LinkedList<Point> getPath(Board board,Point aSourcePoint, Point aTargetPoint) {
        return new PathSearch(board).pathSearch(aSourcePoint,aTargetPoint);
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
