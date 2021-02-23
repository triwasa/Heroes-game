package pl.sdk;


import pl.sdk.creatures.BattleObject;
import pl.sdk.special_fields.Field;

import java.util.*;

public abstract class PathSearch {
    private LinkedList<Point> openlist;
    private Map<Point, Point> cameFrom;
    private Map<Point, Double> gScore;
    private Map<Point, Double> fScore;
    private Point current;
    private double tentative_gScore;
    private Board board;

    PathSearch(Board aBoard) {
         board = aBoard;
         openlist = new LinkedList<>();
         cameFrom = new HashMap<>();
         gScore = new HashMap<>();
         fScore = new HashMap<>();
    }

    private LinkedList<Point> reconstructPath() {
        LinkedList<Point> totalPath = new LinkedList<>();
        totalPath.add(current);
        while(cameFrom.containsKey(current)){
            current = cameFrom.get(current);
            totalPath.add(0,current);
        }
        return totalPath;
    }

    public LinkedList<Point> pathSearch(Point sourcePoint, Point targetPoint) {
        openlist.add(sourcePoint);
        gScore.put(sourcePoint, (double)0);
        fScore.put(sourcePoint, sourcePoint.distance(targetPoint));

        while(!openlist.isEmpty()) {
            current = getMinKey(fScore, openlist);

            if(current.equals(targetPoint)) {
                return reconstructPath();
            }

            openlist.remove(current);

            for(Point point : getNeighbor(current)){
                tentative_gScore = gScore.get(current) + current.distance(point);
                if(tentative_gScore < gScore.getOrDefault(point, (double)Integer.MAX_VALUE)) {
                    if (!cameFrom.containsKey(point)) {
                        cameFrom.put(point, current);
                    } else {
                        cameFrom.compute(point, (k, v) -> v = current);
                    }
                    if (!gScore.containsKey(point)) {
                        gScore.put(point, tentative_gScore);
                    } else {
                        gScore.compute(point, (k, v) -> v = tentative_gScore);
                    }
                    if (!fScore.containsKey(point)) {
                        fScore.put(point, gScore.get(point) + point.distance(targetPoint));
                    } else {
                        fScore.compute(point, (k, v) -> v = gScore.get(point) + point.distance(sourcePoint));
                    }
                    if(!openlist.contains(point)) {
                        openlist.add(point);
                    }
                }
            }
        }
        return new LinkedList<>();
    }
    private Point getMinKey(Map<Point, Double> map, LinkedList<Point> openlist) {
        Point minKey = null;
        double minValue = Integer.MAX_VALUE;
        for(Point key : openlist) {
            double value = map.getOrDefault(key, (double)Integer.MAX_VALUE);
            if(value < minValue) {
                minValue = value;
                minKey = key;
            }
        }
        return minKey;
    }

     abstract LinkedList<Point> getNeighbor(Point point);
}
