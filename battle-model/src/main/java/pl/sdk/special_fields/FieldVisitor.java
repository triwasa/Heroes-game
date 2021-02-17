package pl.sdk.special_fields;

import pl.sdk.FlyingMovementStrategy;
import pl.sdk.GroundMovementStrategy;
import pl.sdk.TeleportMovementStrategy;
import pl.sdk.creatures.BattleObject;

public interface FieldVisitor {
    void visit(BattleObject aCreature, GroundMovementStrategy aMovementStrategy, Field field);
    void visit(BattleObject aCreature, FlyingMovementStrategy aMovementStrategy, Field field);
    void visit(BattleObject aCreature, TeleportMovementStrategy aMovementStrategy, Field field);
}
