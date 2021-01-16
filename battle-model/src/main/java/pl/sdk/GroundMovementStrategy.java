package pl.sdk;

public class GroundMovementStrategy implements MovementStrategy {
    @Override
    public boolean canMove(Point currentPoint, Point targetPoint, int aMoveRange) {
        return false;
    }
}
