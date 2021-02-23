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
    private FlyFieldOptions canFly;
    private boolean fieldCanAttack;
    private int fieldDamage;
    private double moveRange;
    private String name;

    public Field(){}


    public Field(String name, boolean canStand, FlyFieldOptions canFly, boolean fieldCanAttack, int damage, double moveRange) {
        this.fieldName = name;
        this.canStand = canStand;
        this.canFly = canFly;
        this.fieldCanAttack = fieldCanAttack;
        this.fieldDamage = damage;
        this.moveRange = moveRange;
        this.name = name;
    }

    public String getFieldName() { return fieldName; }
    public boolean canAttack() { return fieldCanAttack; }
    public boolean canStand() { return canStand; }
    public FlyFieldOptions canFly() { return canFly; }
    public int getFieldDamage() { return fieldDamage; }
    private double getMoveRange() { return moveRange; }
    public String getName(){return name;}


}