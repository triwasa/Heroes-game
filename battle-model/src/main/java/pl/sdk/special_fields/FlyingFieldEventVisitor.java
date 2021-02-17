package pl.sdk.special_fields;

import pl.sdk.FlyingMovementStrategy;
import pl.sdk.GroundMovementStrategy;
import pl.sdk.TeleportMovementStrategy;
import pl.sdk.creatures.BattleObject;

public class FlyingFieldEventVisitor implements FieldVisitor{
    @Override
    public void visit(BattleObject aCreature, GroundMovementStrategy aMovementStrategy, Field field) {

    }

    @Override
    public void visit(BattleObject aCreature, FlyingMovementStrategy aMovementStrategy, Field field) {
        field.apply(aCreature);
    }

    @Override
    public void visit(BattleObject aCreature, TeleportMovementStrategy aMovementStrategy, Field field) {

    }
}
