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
            case "resistance 1":
                return  new EconomySkill(SkillStatistic.RESISTANCE1, 100);
            case "resistance 2":
                return  new EconomySkill(SkillStatistic.RESISTANCE2, 200);
            case "resistance 3":
                return  new EconomySkill(SkillStatistic.RESISTANCE3, 300);
            case "artillery 1":
                return  new EconomySkill(SkillStatistic.ARTILLERY1, 100);
            case "artillery 2":
                return  new EconomySkill(SkillStatistic.ARTILLERY2, 200);
            case "artillery 3":
                return  new EconomySkill(SkillStatistic.ARTILLERY3, 300);
            case "intelligence 1":
                return  new EconomySkill(SkillStatistic.INTELLIGENCE1, 100);
            case "intelligence 2":
                return  new EconomySkill(SkillStatistic.INTELLIGENCE2, 200);
            case "intelligence 3":
                return  new EconomySkill(SkillStatistic.INTELLIGENCE3, 300);
            case "wisdom 1":
                return  new EconomySkill(SkillStatistic.WISDOM1, 100);
            case "wisdom 2":
                return  new EconomySkill(SkillStatistic.WISDOM2, 200);
            case "wisdom 3":
                return  new EconomySkill(SkillStatistic.WISDOM3, 300);
            case "air magic 1":
                return  new EconomySkill(SkillStatistic.AIR_MAGIC1, 100);
            case "air magic 2":
                return  new EconomySkill(SkillStatistic.AIR_MAGIC2, 200);
            case "air magic 3":
                return  new EconomySkill(SkillStatistic.AIR_MAGIC3, 300);
            case "earth magic 1":
                return  new EconomySkill(SkillStatistic.EARTH_MAGIC1, 100);
            case "earth magic 2":
                return  new EconomySkill(SkillStatistic.EARTH_MAGIC2, 200);
            case "earth magic 3":
                return  new EconomySkill(SkillStatistic.EARTH_MAGIC3, 300);
            case "fire magic 1":
                return  new EconomySkill(SkillStatistic.FIRE_MAGIC1, 100);
            case "fire magic 2":
                return  new EconomySkill(SkillStatistic.FIRE_MAGIC2, 200);
            case "fire magic 3":
                return  new EconomySkill(SkillStatistic.FIRE_MAGIC3, 300);
            case "water magic 1":
                return  new EconomySkill(SkillStatistic.WATER_MAGIC1, 100);
            case "water magic 2":
                return  new EconomySkill(SkillStatistic.WATER_MAGIC2, 200);
            case "water magic 3":
                return  new EconomySkill(SkillStatistic.WATER_MAGIC3, 300);
            default:
                throw new IllegalArgumentException(EXCEPTION_MESSEAGE);
        }
    }

}
