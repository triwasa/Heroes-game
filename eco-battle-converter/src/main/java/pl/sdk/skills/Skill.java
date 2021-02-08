package pl.sdk.skills;


import pl.sdk.skills.SkillStatistic;

public class Skill {

    private SkillStatistic skillStat;

    Skill(SkillStatistic skill) {
        skillStat = skill;
    }

    public String getName(){ return skillStat.getName(); }

    public String getCoreName(){
        return skillStat.getCoreName();
    }

    public int getTier(){
        return skillStat.getTier();
    }

    public String getDescription(){ return skillStat.getDescription(); }

}
