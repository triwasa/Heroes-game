package pl.sdk;

import pl.sdk.creatures.GuiTile;

import java.util.LinkedList;

public class GroundMovementStrategy implements MovementStrategy {
    LinkedList<Point> pointsToGo = new LinkedList<>();

    @Override
    public boolean canMove(Board board, GuiTile aCreature, Point targetPoint) {
        pointsToGo = new PathSearch(board).pathSearch(board.get(aCreature), targetPoint);
        if(pointsToGo != null) {
            return distance(pointsToGo) <= aCreature.getMoveRange();
        }
        return false;
    }
    private double distance(LinkedList<Point> path) {
        double distance = 0;
        Point aPoint = path.get(0);
        for(Point aPoint1 : path) {
            distance = distance + aPoint.distance(aPoint1);
            aPoint = aPoint1;
        }
        return distance;
    }
}
