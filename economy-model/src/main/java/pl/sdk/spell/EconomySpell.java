package pl.sdk.spell;


public class EconomySpell {
    private final String name;
    private final Integer cost;
    private final EconomySpellEnum.typeOfSpell type;
    private final Integer level;


    public EconomySpell(String aName, Integer aCost, EconomySpellEnum.typeOfSpell aType, Integer aLevel) {
        this.name = aName;
        this.cost = aCost;
        this.type= aType;
        this.level = aLevel;
    }

    public Integer getCost() { return this.cost;}

    public String getName() { return this.name;}

    public String getType() { return this.type.name();}

    public Integer getLevel() { return this.level;}

}
