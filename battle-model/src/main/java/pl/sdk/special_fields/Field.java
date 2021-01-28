package pl.sdk.special_fields;


import pl.sdk.creatures.Creature;

public class Field {
    private String fieldName;
    private boolean canStand;
    private boolean fieldCanAttack;
    private int fieldDamage;
    private double moveRange;

    public Field(String name, boolean canStand, boolean fieldCanAttack, int damage, double moveRange) {
        this.fieldName = name;
        this.canStand = canStand;
        this.fieldCanAttack = fieldCanAttack;
        this.fieldDamage = damage;
        this.moveRange = moveRange;
    }

    public String getFieldName() { return fieldName; }
    public boolean getCanAttack() { return fieldCanAttack; }
    public boolean getCanStand() { return canStand; }
    public int getFieldDamage() { return fieldDamage; }
    private double getMoveRange() { return moveRange; }


}