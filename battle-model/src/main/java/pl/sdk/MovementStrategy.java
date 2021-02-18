package pl.sdk;

import pl.sdk.creatures.BattleObject;
import pl.sdk.special_fields.Field;

import java.util.LinkedList;

public interface MovementStrategy {

    boolean canMove(Board board, BattleObject aCreature, Point targetPoint);
    LinkedList<Point> getPath(Board board,Point aSourcePoint, Point aTargetPoint);

}
