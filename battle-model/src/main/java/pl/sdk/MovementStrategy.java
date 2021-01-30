package pl.sdk;

import pl.sdk.creatures.Creature;
import pl.sdk.creatures.GuiTile;

import java.util.LinkedList;

public interface MovementStrategy {

    boolean canMove(Board board, GuiTile aCreature, Point targetPoint);
    LinkedList<Point> getPath(Board board,Point aSourcePoint, Point aTargetPoint);
}
