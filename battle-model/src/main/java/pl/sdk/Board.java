package pl.sdk;

import org.checkerframework.checker.units.qual.C;
import pl.sdk.creatures.Creature;
import pl.sdk.creatures.GuiTile;

import java.util.*;

import static pl.sdk.GameEngine.BOARD_HEIGHT;
import static pl.sdk.GameEngine.BOARD_WIDTH;

public class Board {


    private final Map<Point, GuiTile> map;

    public Board() {
        map = new HashMap<>();
    }

    void add(Point aPoint, GuiTile aCreature) {
        throwExceptionWhenIsOutsideMap(aPoint);
        throwExceptionIfTileIsTaken(aPoint);
        map.put(aPoint,aCreature);
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

    GuiTile get(int aX, int aY) {
        return map.get(new Point(aX,aY));
    }

    Point get(GuiTile aCreature){
        return map.keySet().stream().filter(p -> map.get(p).equals(aCreature)).findAny().get();
    }

    void move(GuiTile aCreature, Point aTargetPoint1){
        move(get(aCreature), aTargetPoint1);
    }

    void move(Point aSourcePoint, Point aTargetPoint1) {
        throwExceptionWhenIsOutsideMap(aTargetPoint1);
        throwExceptionIfTileIsTaken(aTargetPoint1);

        GuiTile creatureFromSourcePoint = map.get(aSourcePoint);
        map.remove(aSourcePoint);
        map.put(aTargetPoint1,creatureFromSourcePoint);
    }

    boolean canMove(GuiTile aCreature, int aX, int aY) {
        throwExceptionWhenIsOutsideMap(new Point(aX,aY));
        if (!map.containsValue(aCreature)){
            throw new IllegalStateException("Creature isn't in board");
        }
        Point currentPosition = get(aCreature);
        //Performance increase (we don't need to check the path to the point which is far away from Creature (more than MR))
        /*if(currentPosition.distance(new Point(aX, aY)) > aCreature.getMoveRange()) {
            return false;
        }*/
        return new GroundMovementStrategy().canMove(this, aCreature, new Point(aX,aY));
    }
}
