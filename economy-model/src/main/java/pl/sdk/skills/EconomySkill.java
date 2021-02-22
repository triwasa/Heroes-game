package pl.sdk.skills;

public class EconomySkill {

    private final SkillStatistic skill;
    private final int cost;

    EconomySkill(SkillStatistic aSkill, int aCost) {
        this.skill = aSkill;
        this.cost = aCost;
    }

    public SkillStatistic getStats() {return this.skill; }

    public String getName() {
        return skill.getName();
    }

    public String getCoreName(){
        return skill.getCoreName();
    }

    public int getGoldCost() {
        return this.cost;
    }

    public Integer getLevel() {
        return skill.getTier();
    }
}
