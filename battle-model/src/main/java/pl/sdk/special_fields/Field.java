package pl.sdk.special_fields;


import pl.sdk.creatures.BattleObject;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "field")
@XmlAccessorType(XmlAccessType.FIELD)
public class Field {
    private String fieldName;
    private boolean canStand;
    private boolean isGroundField;
    private boolean isFlyingField;
    private double moveRange;
    private String name;
    private FieldsApplyStrategy fieldsApplyStrategy;

    public Field(){}

    public Field(String name, boolean canStand, boolean isGroundField, boolean isFlyingField, double moveRange, FieldsApplyStrategy fieldsApplyStrategy) {
        this.fieldName = name;
        this.canStand = canStand;
        this.isGroundField = isGroundField;
        this.isFlyingField = isFlyingField;
        this.moveRange = moveRange;
        this.name = name;
        this.fieldsApplyStrategy = fieldsApplyStrategy;
    }

    public String getFieldName() { return fieldName; }
    public boolean canStand() { return canStand; }
    public boolean isGroundField() { return isGroundField; }
    public boolean isFlyingField() { return isFlyingField; }
    private double getMoveRange() { return moveRange; }
    public String getName(){return name;}

    public void apply(BattleObject creature) {
        fieldsApplyStrategy.apply(creature);
    }
}