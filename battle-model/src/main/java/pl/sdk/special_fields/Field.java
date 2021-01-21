package pl.sdk.special_fields;


import pl.sdk.creatures.Creature;

public class Field {
    private boolean canStand;
    private boolean canAttack;
    private int fieldDamage;
    private double moveRange;

    public Field(boolean canStand, boolean canAttack, int damage, double moveRange) {
        this.canStand = canStand;
        this.canAttack = canAttack;
        this.fieldDamage = damage;
        this.moveRange = moveRange;
    }

    public boolean getCanAttack() { return canAttack; }
    public boolean getCanStand() { return canStand; }
    public int getFieldDamage() { return fieldDamage; }
    private double getMoveRange() { return moveRange; }


}