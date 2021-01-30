package pl.sdk.special_fields;


import pl.sdk.creatures.Creature;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "field")
@XmlAccessorType(XmlAccessType.FIELD)
public class Field {
    private String fieldName;
    private boolean canStand;
    private boolean fieldCanAttack;
    private int fieldDamage;
    private double moveRange;
    private String name;

    public Field(){}


    public Field(String name, boolean canStand, boolean fieldCanAttack, int damage, double moveRange) {
        this.fieldName = name;
        this.canStand = canStand;
        this.fieldCanAttack = fieldCanAttack;
        this.fieldDamage = damage;
        this.moveRange = moveRange;
        this.name = name;
    }

    public String getFieldName() { return fieldName; }
    public boolean getCanAttack() { return fieldCanAttack; }
    public boolean getCanStand() { return canStand; }
    public int getFieldDamage() { return fieldDamage; }
    private double getMoveRange() { return moveRange; }
    public String getName(){return name;}


}