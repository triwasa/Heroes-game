package pl.sdk.skills;

public class EconomySkill {

    private final SkillStatistic skill;
    private final int cost;

    EconomySkill(SkillStatistic aSkill, int aCost) {
        this.skill = aSkill;
        this.cost = aCost;
    }

    public int getCost(){
        return this.cost;
    }
    public SkillStatistic getStats() {return this.skill; }

    public String getName() {
        return "make me better";
    }

    public String getCoreName(){
        return "make me better";
    }

    public int getGoldCost() {
        return 0;
    }

    public Integer getLevel() {
        return null;
    }
}
