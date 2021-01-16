package pl.sdk;

import pl.sdk.creatures.Creature;

public interface MovementStrategy {

    boolean canMove(Point currentPoint, Point targetPoint, int aMoveRange);
}
