package pl.sdk;

import org.checkerframework.checker.units.qual.C;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.GuiTile;
import pl.sdk.special_fields.Field;
import pl.sdk.special_fields.FieldsFactory;

import java.util.*;

import static pl.sdk.GameEngine.BOARD_HEIGHT;
import static pl.sdk.GameEngine.BOARD_WIDTH;

public class Board {

    private final Map<Point, GuiTile> map;

    // added for special fields
    private final Map<Point, Field> fieldsMap;

    public Board() {
        map = new HashMap<>();

        // added for special fields
        fieldsMap = new HashMap<>();
    }

    void add(Point aPoint, GuiTile aCreature) {
        throwExceptionWhenIsOutsideMap(aPoint);
        throwExceptionIfTileIsTaken(aPoint);


        // added for special fields
        throwExceptionIfCanNotStand(aPoint);

        map.put(aPoint,aCreature);

    }

    // added for special fields
    public void add(Point aPoint, Field aField) {
        throwExceptionWhenIsOutsideMap(aPoint);
        throwExceptionIfTileIsTaken(aPoint);
        fieldsMap.put(aPoint,aField);
    }

    public Map<Point, GuiTile> getMap() {
        return map;
    }

    public Map<Point,Field> getFieldsMap()
    {
        return fieldsMap;
    }

    void removeAll() {
        map.clear();
    }


    void removeAllFields() {
        fieldsMap.clear();
    }

    void remove(Point aPoint)
    {
        if(map.get(aPoint).isItObstacle()) map.remove(aPoint);

    }

    void removeField(Point point) {
        if(!fieldsMap.get(point).equals("Normal")) fieldsMap.remove(point);
}

    private void throwExceptionIfTileIsTaken(Point aPoint) {
        if (isTileTaken(aPoint)) {
            throw new IllegalArgumentException("Tile isn't empty");
        }
    }

    boolean isTileTaken(Point aPoint) {
        return map.containsKey(aPoint);
    }

    boolean isTileTakenByField(Point aPoint)
    {
        return  fieldsMap.containsKey(aPoint);
    }

    private void throwExceptionWhenIsOutsideMap(Point aPoint) {
        if (aPoint.getX() < 0 || aPoint.getX() > BOARD_WIDTH || aPoint.getY() < 0 || aPoint.getY() > BOARD_HEIGHT) {
            throw new IllegalArgumentException("You are trying to works outside the map");
        }
    }

    // added for special fields
    boolean canStand(Point aPoint) {
        return getField(aPoint.getX(), aPoint.getY()).getCanStand();
    }
    // added for special fields
    private void throwExceptionIfCanNotStand(Point aPoint) {
        if (!canStand(aPoint)) {
            throw new IllegalArgumentException("Can not stand here!");
        }
    }

    GuiTile get(int aX, int aY) {
        return map.get(new Point(aX, aY));
    }

    Point get(GuiTile aCreature) {
        return map.keySet().stream().filter(p -> map.get(p).equals(aCreature)).findAny().get();
    }


    // added for special fields
    Field getField(int aX, int aY) {
        return fieldsMap.getOrDefault(new Point(aX, aY), FieldsFactory.create("Normal"));
    }

    void move(GuiTile aCreature, Point aTargetPoint1){
        move(get(aCreature), aTargetPoint1);
    }

    void move(Point aSourcePoint, Point aTargetPoint1) {
        throwExceptionWhenIsOutsideMap(aTargetPoint1);
        throwExceptionIfTileIsTaken(aTargetPoint1);
        throwExceptionIfCanNotStand(aTargetPoint1);

        MovementStrategy movementStrategy = getMovementStrategy(get(aSourcePoint.getX(), aSourcePoint.getY()));
        LinkedList<Point> pathToGo = movementStrategy.getPath(this, aSourcePoint, aTargetPoint1);

        GuiTile creatureFromSourcePoint = map.get(aSourcePoint);
        map.remove(aSourcePoint);
        map.put(aTargetPoint1, creatureFromSourcePoint);
    }

    boolean canMove(GuiTile aCreature, int aX, int aY) {
        throwExceptionWhenIsOutsideMap(new Point(aX, aY));
        if (!map.containsValue(aCreature)) {
            throw new IllegalStateException("Creature isn't in board");
        }

        //Performance increase (we don't need to check the path to the point which is far away from Creature (more than MR))
        /*if(currentPosition.distance(new Point(aX, aY)) > aCreature.getMoveRange()) {
            return false;
        }*/
       MovementStrategy movementStrategy = getMovementStrategy(aCreature);
       return movementStrategy.canMove(this,aCreature, new Point(aX, aY));
    }

    MovementStrategy getMovementStrategy(GuiTile aCreature) {
        switch (aCreature.getMovementType().toUpperCase()) {
            case GroundMovementStrategy.GROUND:
                return new GroundMovementStrategy();
            case FlyingMovementStrategy.FLYING:
                return new FlyingMovementStrategy();
            case TeleportMovementStrategy.TELEPORT:
                return new TeleportMovementStrategy();
        }
        throw new IllegalArgumentException("No such movementType");

    }
}
