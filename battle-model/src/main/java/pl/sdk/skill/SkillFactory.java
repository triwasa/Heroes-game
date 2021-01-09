package pl.sdk.skill;

public class SkillFactory {

    public static Skill createForTest(SkillEnum skill){
        return new Skill(skill.getName(), skill.getCoreName(), skill.getTier(), skill.getDescription(), skill.getCost());
    }

    public Skill create(SkillEnum skill){
        return new Skill(skill.getName(), skill.getCoreName(), skill.getTier(), skill.getDescription(), skill.getCost());
    }
}
