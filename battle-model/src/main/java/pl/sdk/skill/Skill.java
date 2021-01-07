package pl.sdk.skill;

public class Skill {

    private final String name;
    private final String coreName;
    private final int tier;
    private final String description;
    private final int cost;

    Skill(String aName, String aCoreName, int aTier, String aDescription, int aCost) {
        name = aName;
        coreName = aCoreName;
        tier = aTier;
        description = aDescription;
        cost = aCost;
    }

}
