package skills;

import pl.sdk.skills.SkillStatistic;

public class SkillFactory {

    private static String EXCEPTION_MESSEAGE = "There is no such skill";

    public Skill create(SkillStatistic skillStats) {
        return new Skill(skillStats);
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
            case "resistance 1":
                return  new Skill(SkillStatistic.RESISTANCE1);
            case "resistance 2":
                return  new Skill(SkillStatistic.RESISTANCE2);
            case "resistance 3":
                return  new Skill(SkillStatistic.RESISTANCE3);
            case "artillery 1":
                return  new Skill(SkillStatistic.ARTILLERY1);
            case "artillery 2":
                return  new Skill(SkillStatistic.ARTILLERY2);
            case "artillery 3":
                return  new Skill(SkillStatistic.ARTILLERY3);
            case "intelligence 1":
                return  new Skill(SkillStatistic.INTELLIGENCE1);
            case "intelligence 2":
                return  new Skill(SkillStatistic.INTELLIGENCE1);
            case "intelligence 3":
                return  new Skill(SkillStatistic.INTELLIGENCE3);
            case "wisdom 1":
                return  new Skill(SkillStatistic.WISDOM1);
            case "wisdom 2":
                return  new Skill(SkillStatistic.WISDOM2);
            case "wisdom 3":
                return  new Skill(SkillStatistic.WISDOM3);
            case "sorcery 1":
                return  new Skill(SkillStatistic.SORCERY1);
            case "sorcery 2":
                return  new Skill(SkillStatistic.SORCERY2);
            case "sorcery 3":
                return  new Skill(SkillStatistic.SORCERY3);
            case "ballistics 1":
                return  new Skill(SkillStatistic.BALLISTICS1);
            case "ballistics 2":
                return  new Skill(SkillStatistic.BALLISTICS2);
            case "ballistics 3":
                return  new Skill(SkillStatistic.BALLISTICS3);
            case "first aid 1":
                return  new Skill(SkillStatistic.FIRSTAID1);
            case "first aid 2":
                return  new Skill(SkillStatistic.FIRSTAID2);
            case "first aid 3":
                return  new Skill(SkillStatistic.FIRSTAID3);
            case "eagle eye 1":
                return  new Skill(SkillStatistic.EAGLEEYE1);
            case "eagle eye 2":
                return  new Skill(SkillStatistic.EAGLEEYE2);
            case "eagle eye 3":
                return  new Skill(SkillStatistic.EAGLEEYE3);
            case "air magic 1":
                return  new Skill(SkillStatistic.AIR_MAGIC1);
            case "air magic 2":
                return  new Skill(SkillStatistic.AIR_MAGIC2);
            case "air magic 3":
                return  new Skill(SkillStatistic.AIR_MAGIC3);
            case "earth magic 1":
                return  new Skill(SkillStatistic.EARTH_MAGIC1);
            case "earth magic 2":
                return  new Skill(SkillStatistic.EARTH_MAGIC2);
            case "earth magic 3":
                return  new Skill(SkillStatistic.EARTH_MAGIC3);
            case "fire magic 1":
                return  new Skill(SkillStatistic.FIRE_MAGIC1);
            case "fire magic 2":
                return  new Skill(SkillStatistic.FIRE_MAGIC2);
            case "fire magic 3":
                return  new Skill(SkillStatistic.FIRE_MAGIC3);
            case "water magic 1":
                return  new Skill(SkillStatistic.WATER_MAGIC1);
            case "water magic 2":
                return  new Skill(SkillStatistic.WATER_MAGIC2);
            case "water magic 3":
                return  new Skill(SkillStatistic.WATER_MAGIC3);
            default:
                throw new IllegalArgumentException(EXCEPTION_MESSEAGE);
        }
    }

    public static Skill createForTest(String aName) {
        switch (aName) {
            case "offence 1":
                return new Skill(SkillStatistic.OFFENCE1);
            case "offence 2":
                return new Skill(SkillStatistic.OFFENCE2);
            case "offence 3":
                return new Skill(SkillStatistic.OFFENCE3);
            case "archery 1":
                return new Skill(SkillStatistic.ARCHERY1);
            case "archery 2":
                return new Skill(SkillStatistic.ARCHERY2);
            case "archery 3":
                return new Skill(SkillStatistic.ARCHERY3);
            case "armourer 1":
                return new Skill(SkillStatistic.ARMOURER1);
            case "armourer 2":
                return new Skill(SkillStatistic.ARMOURER2);
            case "armourer 3":
                return new Skill(SkillStatistic.ARMOURER3);
            case "leadership 1":
                return new Skill(SkillStatistic.LEADERSHIP1);
            case "leadership 2":
                return new Skill(SkillStatistic.LEADERSHIP2);
            case "leadership 3":
                return new Skill(SkillStatistic.LEADERSHIP3);
            case "luck 1":
                return new Skill(SkillStatistic.LUCK1);
            case "luck 2":
                return new Skill(SkillStatistic.LUCK2);
            case "luck 3":
                return new Skill(SkillStatistic.LUCK3);
            case "resistance 1":
                return new Skill(SkillStatistic.RESISTANCE1);
            case "resistance 2":
                return new Skill(SkillStatistic.RESISTANCE2);
            case "resistance 3":
                return new Skill(SkillStatistic.RESISTANCE3);
            case "artillery 1":
                return new Skill(SkillStatistic.ARTILLERY1);
            case "artillery 2":
                return new Skill(SkillStatistic.ARTILLERY2);
            case "artillery 3":
                return new Skill(SkillStatistic.ARTILLERY3);
            case "intelligence 1":
                return new Skill(SkillStatistic.INTELLIGENCE1);
            case "intelligence 2":
                return new Skill(SkillStatistic.INTELLIGENCE1);
            case "intelligence 3":
                return new Skill(SkillStatistic.INTELLIGENCE3);
            case "wisdom 1":
                return new Skill(SkillStatistic.WISDOM1);
            case "wisdom 2":
                return new Skill(SkillStatistic.WISDOM2);
            case "wisdom 3":
                return new Skill(SkillStatistic.WISDOM3);
            case "sorcery 1":
                return new Skill(SkillStatistic.SORCERY1);
            case "sorcery 2":
                return new Skill(SkillStatistic.SORCERY2);
            case "sorcery 3":
                return new Skill(SkillStatistic.SORCERY3);
            case "ballistics 1":
                return new Skill(SkillStatistic.BALLISTICS1);
            case "ballistics 2":
                return new Skill(SkillStatistic.BALLISTICS2);
            case "ballistics 3":
                return new Skill(SkillStatistic.BALLISTICS3);
            case "first aid 1":
                return new Skill(SkillStatistic.FIRSTAID1);
            case "first aid 2":
                return new Skill(SkillStatistic.FIRSTAID2);
            case "first aid 3":
                return new Skill(SkillStatistic.FIRSTAID3);
            case "eagle eye 1":
                return new Skill(SkillStatistic.EAGLEEYE1);
            case "eagle eye 2":
                return new Skill(SkillStatistic.EAGLEEYE2);
            case "eagle eye 3":
                return new Skill(SkillStatistic.EAGLEEYE3);
            case "air magic 1":
                return new Skill(SkillStatistic.AIR_MAGIC1);
            case "air magic 2":
                return new Skill(SkillStatistic.AIR_MAGIC2);
            case "air magic 3":
                return new Skill(SkillStatistic.AIR_MAGIC3);
            case "earth magic 1":
                return new Skill(SkillStatistic.EARTH_MAGIC1);
            case "earth magic 2":
                return new Skill(SkillStatistic.EARTH_MAGIC2);
            case "earth magic 3":
                return new Skill(SkillStatistic.EARTH_MAGIC3);
            case "fire magic 1":
                return new Skill(SkillStatistic.FIRE_MAGIC1);
            case "fire magic 2":
                return new Skill(SkillStatistic.FIRE_MAGIC2);
            case "fire magic 3":
                return new Skill(SkillStatistic.FIRE_MAGIC3);
            case "water magic 1":
                return new Skill(SkillStatistic.WATER_MAGIC1);
            case "water magic 2":
                return new Skill(SkillStatistic.WATER_MAGIC2);
            case "water magic 3":
                return new Skill(SkillStatistic.WATER_MAGIC3);
            default:
                throw new IllegalArgumentException(EXCEPTION_MESSEAGE);
        }
    }
}

