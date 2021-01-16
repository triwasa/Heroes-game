package pl.sdk;

import pl.sdk.creatures.GuiTile;

public class GroundMovementStrategy implements MovementStrategy {
    @Override
    public boolean canMove(Board board, GuiTile aCreature, Point targetPoint) {
        return pathSearch().size <= aCreature.getMoveRange();
    }

}
