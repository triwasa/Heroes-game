package pl.sdk;


import pl.sdk.creatures.GuiTile;

import java.util.*;

public class PathSearch {
    LinkedList<Point> openlist = new LinkedList<>();
    Map<Point, Point> cameFrom = new HashMap<>();
    Map<Point, Double> gScore = new HashMap<>();
    Map<Point, Double> fScore = new HashMap<>();
    Point current;
    double tentative_gScore;
    Board board;

    PathSearch(Board aBoard) {
        board = aBoard;
    }

    private LinkedList<Point> reconstructPath() {
        LinkedList<Point> totalPath = new LinkedList<>();
        totalPath.add(current);
        while(cameFrom.containsKey(current)){
            current = cameFrom.get(current);
            totalPath.add(current);
        }
        return totalPath;
    }

    public LinkedList<Point> pathSearch(Point sourcePoint, Point targetPoint) {
        openlist.add(sourcePoint);
        gScore.put(sourcePoint, (double)0);
        fScore.put(sourcePoint, sourcePoint.distance(targetPoint));
        while(!openlist.isEmpty()) {
            current = getMinKey(gScore);
            if(current.equals(targetPoint)) {
                return reconstructPath();
            }
            openlist.remove(current);
            for(Point point : getNeighbor(current)){
                tentative_gScore = gScore.get(current) + current.distance(point);
                if(tentative_gScore < gScore.getOrDefault(point, Double.MAX_VALUE)) {
                    if (cameFrom.containsKey(current)) {
                        cameFrom.put(point, current);
                    } else {
                        cameFrom.computeIfPresent(current, (k, v) -> v = current);
                    }
                    if (gScore.containsKey(point)) {
                        gScore.put(point, tentative_gScore);
                    } else {
                        gScore.computeIfPresent(point, (k, v) -> v = tentative_gScore);
                    }
                    if (fScore.containsKey(point)) {
                        fScore.put(point, gScore.get(point) + point.distance(targetPoint));
                    } else {
                        fScore.computeIfPresent(point, (k, v) -> v = gScore.get(point) + point.distance(sourcePoint));
                    }
                    if(!openlist.contains(point)) {
                        openlist.add(point);
                    }
                }
            }
        }
        return null;
    }
    private Point getMinKey(Map<Point, Double> map) {
        Point minKey = null;
        double minValue = Double.MAX_VALUE;
        for(Point key : map.keySet()) {
            double value = map.get(key);
            if(value < minValue) {
                minValue = value;
                minKey = key;
            }
        }
        return minKey;
    }

    private LinkedList<Point> getNeighbor(Point point) {
        LinkedList<Point> neighbor = new LinkedList<>();
        for(int i = 0; i <= 2; i++){
            for(int j = 0; j <=2; j++) {
                GuiTile tmp = board.get(point.getX() + 1 - i, point.getY() + 1 - j);
                if(tmp != null && !board.get(tmp).equals(point) && tmp.isMovePossible()) {
                    neighbor.add(new Point(point.getX() + 1 - i,point.getY() + 1 - j));
                }
            }
        }
        return neighbor;
    }

}
