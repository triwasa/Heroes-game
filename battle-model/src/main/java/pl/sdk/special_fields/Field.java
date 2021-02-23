package pl.sdk.special_fields;


import pl.sdk.creatures.BattleObject;
import pl.sdk.creatures.Creature;

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
    private boolean fieldCanAttack;
    private int fieldDamage;
    private double moveRange;
    private String name;

    public Field(){}

    public Field(String name, boolean canStand, boolean isGroundField, boolean isFlyingField, boolean fieldCanAttack, int damage, double moveRange) {
        this.fieldName = name;
        this.canStand = canStand;
        this.isGroundField = isGroundField;
        this.isFlyingField = isFlyingField;
        this.fieldCanAttack = fieldCanAttack;
        this.fieldDamage = damage;
        this.moveRange = moveRange;
        this.name = name;
    }

    public String getFieldName() { return fieldName; }
    public boolean canAttack() { return fieldCanAttack; }
    public boolean canStand() { return canStand; }
    public boolean isGroundField() { return isGroundField; }
    public boolean isFlyingField() { return isFlyingField; }
    public int getFieldDamage() { return fieldDamage; }
    private double getMoveRange() { return moveRange; }
    public String getName(){return name;}

    public void apply(BattleObject creature) {
        if (this.canAttack()) {
            creature.applyDamage(getFieldDamage());
        }
    }
}