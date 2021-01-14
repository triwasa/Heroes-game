package pl.sdk.skills;

public class SkillFactory {

    private static String EXCEPTION_MESSEAGE = "There is no such skill";

    public static Skill createForTest(SkillStatistic skill){
        return new Skill(skill);
    }

    public Skill create(String aName) {
        switch (aName){
            case "offence 1":
                return new Skill(SkillStatistic.OFFENCE1);
            case "offence 2":
                return  new Skill(SkillStatistic.OFFENCE2);
            case "offence 3":
                return  new Skill(SkillStatistic.OFFENCE3);
            case "archery 1":
                return  new Skill(SkillStatistic.ARCHERY1);
            case "archery 2":
                return  new Skill(SkillStatistic.ARCHERY2);
            case "archery 3":
                return  new Skill(SkillStatistic.ARCHERY3);
            case "armourer 1":
                return  new Skill(SkillStatistic.ARMOURER1);
            case "armourer 2":
                return  new Skill(SkillStatistic.ARMOURER2);
            case "armourer 3":
                return  new Skill(SkillStatistic.ARMOURER3);
            case "leadership 1":
                return  new Skill(SkillStatistic.LEADERSHIP1);
            case "leadership 2":
                return  new Skill(SkillStatistic.LEADERSHIP2);
            case "leadership 3":
                return  new Skill(SkillStatistic.LEADERSHIP3);
            case "luck 1":
                return  new Skill(SkillStatistic.LUCK1);
            case "luck 2":
                return  new Skill(SkillStatistic.LUCK2);
            case "luck 3":
                return  new Skill(SkillStatistic.LUCK3);
            default:
                throw new IllegalArgumentException(EXCEPTION_MESSEAGE);
        }
    }

}

