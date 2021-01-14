package pl.sdk.skills;

public class EconomySkillFactory {

    private static String EXCEPTION_MESSEAGE = "There is no such skill";


    public EconomySkill create(String aName) {
        switch (aName){
            case "offence 1":
                return  new EconomySkill(SkillStatistic.OFFENCE1, 100);
            case "offence 2":
                return  new EconomySkill(SkillStatistic.OFFENCE2, 200);
            case "offence 3":
                return  new EconomySkill(SkillStatistic.OFFENCE3, 300);
            case "archery 1":
                return  new EconomySkill(SkillStatistic.ARCHERY1, 100);
            case "archery 2":
                return  new EconomySkill(SkillStatistic.ARCHERY2, 200);
            case "archery 3":
                return  new EconomySkill(SkillStatistic.ARCHERY3, 300);
            case "armourer 1":
                return  new EconomySkill(SkillStatistic.ARMOURER1, 100);
            case "armourer 2":
                return  new EconomySkill(SkillStatistic.ARMOURER2, 200);
            case "armourer 3":
                return  new EconomySkill(SkillStatistic.ARMOURER3, 300);
            case "leadership 1":
                return  new EconomySkill(SkillStatistic.LEADERSHIP1, 100);
            case "leadership 2":
                return  new EconomySkill(SkillStatistic.LEADERSHIP2, 200);
            case "leadership 3":
                return  new EconomySkill(SkillStatistic.LEADERSHIP3, 300);
            case "luck 1":
                return  new EconomySkill(SkillStatistic.LUCK1, 100);
            case "luck 2":
                return  new EconomySkill(SkillStatistic.LUCK2, 200);
            case "luck 3":
                return  new EconomySkill(SkillStatistic.LUCK3, 300);
            default:
                throw new IllegalArgumentException(EXCEPTION_MESSEAGE);
        }
    }

}
