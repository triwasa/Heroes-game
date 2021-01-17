package pl.sdk;

import pl.sdk.creatures.GuiTile;

import java.util.LinkedList;

public class GroundMovementStrategy implements MovementStrategy {
    LinkedList<Point> pointsToGo = new LinkedList<>();
    @Override
    public boolean canMove(Board board, GuiTile aCreature, Point targetPoint) {
        pointsToGo = new PathSearch(board).pathSearch(board.get(aCreature), targetPoint);
        if(pointsToGo != null) {
            return pointsToGo.size() > aCreature.getMoveRange();
        }
        return false;
    }

}
