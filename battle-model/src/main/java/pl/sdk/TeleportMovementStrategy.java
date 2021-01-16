package pl.sdk;

public class TeleportMovementStrategy implements MovementStrategy {
    @Override
    public boolean canMove(Point currentPoint, Point targetPoint, int aMoveRange) {
        return currentPoint.distance(targetPoint) <= aMoveRange;
    }
}
