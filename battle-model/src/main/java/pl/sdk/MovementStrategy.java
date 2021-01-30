package pl.sdk;

import java.util.LinkedList;

public interface MovementStrategy {

    boolean canMove(Board board, GuiTile aCreature, Point targetPoint);
    LinkedList<Point> getPath(Board board,Point aSourcePoint, Point aTargetPoint);
}
