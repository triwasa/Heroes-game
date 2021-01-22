package pl.sdk.special_fields;


import pl.sdk.creatures.Creature;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "field")
@XmlAccessorType(XmlAccessType.FIELD)
public class Field {
    private boolean canStand;
    private boolean canAttack;
    private int fieldDamage;
    private double moveRange;
    private String name;

    public Field(){}

    public Field(boolean canStand, boolean canAttack, int damage, double moveRange, String name) {
        this.canStand = canStand;
        this.canAttack = canAttack;
        this.fieldDamage = damage;
        this.moveRange = moveRange;
        this.name = name;
    }

    public boolean getCanAttack() { return canAttack; }
    public boolean getCanStand() { return canStand; }
    public int getFieldDamage() { return fieldDamage; }
    private double getMoveRange() { return moveRange; }
    public String getName(){return name;}


}