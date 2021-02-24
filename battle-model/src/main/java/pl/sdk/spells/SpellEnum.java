package pl.sdk.spells;

public enum SpellEnum {

    MAGIC_ARROW_AIR("Magic Arrow", durationOfSpell.INSTANT, typeOfSpell.ATTACK, magicTypeOfSpell.AIR, 1),
    MAGIC_ARROW_AIR2("Magic Arrow", durationOfSpell.INSTANT, typeOfSpell.ATTACK, magicTypeOfSpell.AIR, 2),
    MAGIC_ARROW_AIR3("Magic Arrow", durationOfSpell.INSTANT, typeOfSpell.ATTACK, magicTypeOfSpell.AIR, 3),
    ICE_BOLD("Ice Bold", durationOfSpell.INSTANT, typeOfSpell.ATTACK, magicTypeOfSpell.WATER, 1),
    ICE_BOLD2("Ice Bold", durationOfSpell.INSTANT, typeOfSpell.ATTACK, magicTypeOfSpell.WATER, 1),
    ICE_BOLD3("Ice Bold", durationOfSpell.INSTANT, typeOfSpell.ATTACK, magicTypeOfSpell.WATER, 1),
    BLESS("Bless", durationOfSpell.ROUND, typeOfSpell.CANGESTATISTIC, magicTypeOfSpell.WATER, 1 ),
    BLESS2("Bless", durationOfSpell.ROUND, typeOfSpell.CANGESTATISTIC, magicTypeOfSpell.WATER, 2 ),
    BLESS3("Bless", durationOfSpell.AREA, typeOfSpell.CANGESTATISTIC, magicTypeOfSpell.WATER, 3),
    FROST_RING("Frost Ring", durationOfSpell.AREA, typeOfSpell.ATTACK, magicTypeOfSpell.WATER, 1),
    FROST_RING2("Frost Ring", durationOfSpell.AREA, typeOfSpell.ATTACK, magicTypeOfSpell.WATER, 2),
    FROST_RING3("Frost Ring", durationOfSpell.AREA, typeOfSpell.ATTACK, magicTypeOfSpell.WATER, 3),
    WEAKNESS("Weakness", durationOfSpell.INSTANT, typeOfSpell.CANGESTATISTIC, magicTypeOfSpell.WATER, 1),
    WEAKNESS2("Weakness", durationOfSpell.INSTANT, typeOfSpell.CANGESTATISTIC, magicTypeOfSpell.WATER, 2),
    WEAKNESS3("Weakness", durationOfSpell.AREA, typeOfSpell.CANGESTATISTIC, magicTypeOfSpell.WATER, 3);

    public enum typeOfSpell{
        CANGESTATISTIC, ATTACK;

    }
    public enum durationOfSpell{
        INSTANT, ROUND, AREA;
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
