package pl.sdk.skill;

import com.google.common.collect.Range;

public enum SkillEnum{

    OFFENCE1("Offence: basic","Offence", 1, "Inflicted hand-to-hand damage is increased by 10%",1),
    OFFENCE2("Offence: advanced", "Offence",2, "Inflicted hand-to-hand damage is increased by 20%",1),
    OFFENCE3("Offence: expert", "Offence",3, "Inflicted hand-to-hand damage is increased by 30%",1),
    ARCHERY1("Archery: basic", "Archery",1, "Ranged attack damage is increased by 10%",1),
    ARCHERY2("Archery: advanced", "Archery", 2, "Ranged attack damage is increased by 20%",1),
    ARCHERY3("Archery: expert", "Archery",3, "Ranged attack damage is increased by 30%",1),
    ARMOURER1("Armourer: basic", "Armourer",1, "Damage inflicted on troops is reduced by 5%",1),
    ARMOURER2("Armourer: advanced", "Armourer",2, "Damage inflicted on troops is reduced by 10%",1),
    ARMOURER3("Armourer: expert", "Armourer",3, "Damage inflicted on troops is reduced by 15%",1),

    LUCK1("Luck: basic","Luck",1, "+1 luck",1),
    LUCK2("Luck: advanced", "Luck",2, "+2 luck",1),
    LUCK3("Luck: expert", "Luck",3, "+3 luck",1);

    private final String name;
    private final String coreName;
    private final int tier;
    private final String description;
    private final int cost;

    SkillEnum(String aName, String aCoreName, int aTier, String aDescription, int aCost) {
        name = aName;
        coreName = aCoreName;
        tier = aTier;
        description = aDescription;
        cost = aCost;
    }

    public String getName() {
        return name;
    }

    public String getCoreName() {
        return coreName;
    }

    public int getTier(){
        return tier;
    }

    public String getDescription(){
        return description;
    }

    public int getCost(){
        return cost;
    }
}
