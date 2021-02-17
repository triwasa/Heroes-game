package pl.sdk;

import pl.sdk.creatures.BattleObject;
import pl.sdk.special_fields.Field;

import java.util.LinkedList;

public class FlyingMovementStrategy implements MovementStrategy {
    public static final String FLYING = "FLYING";
    @Override
    public boolean canMove(Board board, BattleObject aCreature, Point targetPoint) {
        Point currentPoint = board.get(aCreature);
        return currentPoint.distance(targetPoint) <= aCreature.getMoveRange();
    }

    @Override
    public LinkedList<Point> getPath(Board board, Point aSourcePoint, Point aTargetPoint) {
        return new LinkedList<>();
    }

    @Override
    public void accept(BattleObject battleObject, Field field) {
        field.getVisitor().visit(battleObject, this, field);
    }
}
