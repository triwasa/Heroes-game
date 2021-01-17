package pl.sdk;

import pl.sdk.creatures.Creature;
import pl.sdk.creatures.GuiTile;

public interface MovementStrategy {

    boolean canMove(Board board, GuiTile aCreature, Point targetPoint);
}
