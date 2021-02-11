package pl.sdk.spells;

public enum SpellEnum {

    MAGIC_ARROW_AIR("Magic Arrow", durationOfSpell.INSTANT, typeOfSpell.ATTACK, magicTypeOfSpell.AIR, 1),
    BLESS("Bless", durationOfSpell.INSTANT, typeOfSpell.ATTACK, magicTypeOfSpell.WATER, 1 );

    public enum typeOfSpell{
        CURE, ATTACK, OTHER;

    }
    public enum durationOfSpell{
        INSTANT, ROUND, DAY;
    }

    public enum magicTypeOfSpell {
        AIR, WATER, FIRE, EARTH;
    }

    private String name;
    private durationOfSpell duration;
    private  typeOfSpell type;
    private magicTypeOfSpell magicType;
    private Integer level;


    private SpellEnum(String name, durationOfSpell duration, typeOfSpell type, magicTypeOfSpell magicType, Integer level){
        this.name = name;
        this.type = type;
        this.duration = duration;
        this.magicType = magicType;
        this.level = level;
    }

    public String getName() {
        return name;
    }
    public durationOfSpell getDuration(){
        return duration;
    }
    public typeOfSpell getType(){
            return type;
    }
    public magicTypeOfSpell getMagicType() {
            return magicType;
    }
    public Integer getLevel(){
        return level;
    }

}
