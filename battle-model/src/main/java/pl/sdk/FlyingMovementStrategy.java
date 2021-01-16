package pl.sdk;

public class FlyingMovementStrategy implements MovementStrategy {
    @Override
    public boolean canMove(Point currentPoint, Point targetPoint, int aMoveRange) {
        return currentPoint.distance(targetPoint) <= aMoveRange;
    }
}
