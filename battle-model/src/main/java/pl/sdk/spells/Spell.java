package pl.sdk.spells;

import java.util.Objects;

public class Spell {


    private final String name;
    private final SpellEnum.typeOfSpell type;
    private final SpellEnum.durationOfSpell duration;
    private final SpellEnum.magicTypeOfSpell magicType;
    private final Integer level;
    private final SpellEnum techName;

    protected Spell(SpellEnum base){
        this.name = base.getName();
        this.techName = base;
        this.duration = base.getDuration();
        this.type = base.getType();
        this.magicType = base.getMagicType();
        this.level = base.getLevel();

    }
    @Override
    public boolean equals(Object o) {
        if (o instanceof Spell) {
            Spell spell = (Spell) o;
            return Objects.equals(spell.name, this.name);
        }
        return false;
    }

    public String getName(){
        return this.name;
    }

    public SpellEnum.typeOfSpell getType() {
        return this.type;
    }

    public int getLevel() {
        return this.level;
    }

    public SpellEnum getTechName() {
        return this.techName;
    }
}
