package pl.sdk;

import pl.sdk.creatures.Creature;

import java.util.LinkedList;

public interface MovementStrategy {

    boolean canMove(Board board, Creature aCreature, Point targetPoint);
    LinkedList<Point> getPath(Board board,Point aSourcePoint, Point aTargetPoint);
}
