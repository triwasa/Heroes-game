package pl.sdk;

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
    void add(Point aPoint, Field aField) {
        throwExceptionWhenIsOutsideMap(aPoint);
        throwExceptionIfTileIsTaken(aPoint);
        fieldsMap.put(aPoint,aField);
    }

    public Map<Point, GuiTile> getMap() {
        return map;
    }

    void removeAll() {
        map.clear();
    }
    void remove(Point aPoint)
    {
        if(map.get(aPoint).isItObstacle()) map.remove(aPoint);
    }

    private void throwExceptionIfTileIsTaken(Point aPoint) {
        if (isTileTaken(aPoint)){
            throw new IllegalArgumentException("Tile isn't empty");
        }
    }

    boolean isTileTaken(Point aPoint) {
        return map.containsKey(aPoint);
    }

    private void throwExceptionWhenIsOutsideMap(Point aPoint) {
        if (aPoint.getX() < 0 || aPoint.getX() > BOARD_WIDTH || aPoint.getY() < 0 || aPoint.getY() > BOARD_HEIGHT ) {
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
        return map.get(new Point(aX,aY));
    }

    Point get(GuiTile aCreature){
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

        // added for special fields
        throwExceptionIfCanNotStand(aTargetPoint1);

        GuiTile creatureFromSourcePoint = map.get(aSourcePoint);
        map.remove(aSourcePoint);
        map.put(aTargetPoint1,creatureFromSourcePoint);
    }

    boolean canMove(GuiTile aCreature, int aX, int aY) {
        throwExceptionWhenIsOutsideMap(new Point(aX,aY));
        if (!map.containsValue(aCreature)){
            throw new IllegalStateException("Creature isn't in board");
        }

        // added for special fields
        if (!canStand(new Point(aX, aY))) {
            return false;
        }

        Point currentPosition = get(aCreature);
        double distance = currentPosition.distance(new Point(aX,aY));
        return distance <= aCreature.getMoveRange() && !isTileTaken(new Point(aX,aY));
    }
}
