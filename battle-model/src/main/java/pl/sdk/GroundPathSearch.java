package pl.sdk;

import pl.sdk.creatures.BattleObject;
import pl.sdk.special_fields.Field;

import java.util.LinkedList;

public class GroundPathSearch extends PathSearch {

    Board board;

    GroundPathSearch(Board aBoard) {
        super(aBoard);
        board = aBoard;
    }

    @Override
    LinkedList<Point> getNeighbor(Point point) {
        LinkedList<Point> neighborsList = new LinkedList<>();
        for(int i = 0; i <= 2; i++){
            for(int j = 0; j <=2; j++) {
                Point neighbor = new Point(point.getX() + 1 - i, point.getY() + 1 - j);
                BattleObject tmp = board.get(point.getX() + 1 - i, point.getY() + 1 - j);
                Field field = board.getField(point.getX() + 1 - i, point.getY() + 1 - j);
                if(neighbor.getX() < 0 || neighbor.getX() > GameEngine.BOARD_WIDTH
                        || neighbor.getY() < 0
                        || neighbor.getY() > GameEngine.BOARD_HEIGHT
                        || neighbor.equals(point)) {
                    continue;
                }
                if(tmp != null) {
                    continue;
                }
                else if(field.canStand()) {
                    neighborsList.add(neighbor);
                }
            }
        }
        return neighborsList;
    }

}
