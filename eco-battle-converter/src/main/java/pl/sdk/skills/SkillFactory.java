package pl.sdk.skills;

public class SkillFactory {

    private static String EXCEPTION_MESSEAGE = "There is no such skill";

    public Skill create(SkillStatistic stats) { return new Skill(stats); }

    public Skill create(String aName, int tier) {
        if (aName == SkillStatistic.OFFENCE1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new Skill(SkillStatistic.OFFENCE1);
                case 2:
                    return new Skill(SkillStatistic.OFFENCE2);
                case 3:
                    return new Skill(SkillStatistic.OFFENCE3);
            }
        } else if (aName == SkillStatistic.ARCHERY1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new Skill(SkillStatistic.ARCHERY1);
                case 2:
                    return new Skill(SkillStatistic.ARCHERY2);
                case 3:
                    return new Skill(SkillStatistic.ARCHERY3);
            }
        } else if (aName == SkillStatistic.ARMOURER1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new Skill(SkillStatistic.ARMOURER1);
                case 2:
                    return new Skill(SkillStatistic.ARMOURER2);
                case 3:
                    return new Skill(SkillStatistic.ARMOURER3);
            }
        } else if (aName == SkillStatistic.LEADERSHIP1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new Skill(SkillStatistic.LEADERSHIP1);
                case 2:
                    return new Skill(SkillStatistic.LEADERSHIP2);
                case 3:
                    return new Skill(SkillStatistic.LEADERSHIP3);
            }
        } else if (aName == SkillStatistic.LUCK1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new Skill(SkillStatistic.LUCK1);
                case 2:
                    return new Skill(SkillStatistic.LUCK2);
                case 3:
                    return new Skill(SkillStatistic.LUCK3);
            }
        } else if (aName == SkillStatistic.RESISTANCE1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new Skill(SkillStatistic.RESISTANCE1);
                case 2:
                    return new Skill(SkillStatistic.RESISTANCE2);
                case 3:
                    return new Skill(SkillStatistic.RESISTANCE3);
            }
        } else if (aName == SkillStatistic.WISDOM1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new Skill(SkillStatistic.WISDOM1);
                case 2:
                    return new Skill(SkillStatistic.WISDOM2);
                case 3:
                    return new Skill(SkillStatistic.WISDOM3);
            }
        } else if (aName == SkillStatistic.SORCERY1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new Skill(SkillStatistic.SORCERY1);
                case 2:
                    return new Skill(SkillStatistic.SORCERY2);
                case 3:
                    return new Skill(SkillStatistic.SORCERY3);
            }
        } else if (aName == SkillStatistic.ARTILLERY1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new Skill(SkillStatistic.ARTILLERY1);
                case 2:
                    return new Skill(SkillStatistic.ARTILLERY2);
                case 3:
                    return new Skill(SkillStatistic.ARTILLERY3);
            }
        } else if (aName == SkillStatistic.BALLISTICS1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new Skill(SkillStatistic.BALLISTICS1);
                case 2:
                    return new Skill(SkillStatistic.BALLISTICS2);
                case 3:
                    return new Skill(SkillStatistic.BALLISTICS3);
            }
        } else if (aName == SkillStatistic.FIRSTAID1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new Skill(SkillStatistic.FIRSTAID1);
                case 2:
                    return new Skill(SkillStatistic.FIRSTAID2);
                case 3:
                    return new Skill(SkillStatistic.FIRSTAID3);
            }
        } else if (aName == SkillStatistic.EAGLEEYE1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new Skill(SkillStatistic.EAGLEEYE1);
                case 2:
                    return new Skill(SkillStatistic.EAGLEEYE2);
                case 3:
                    return new Skill(SkillStatistic.EAGLEEYE3);
            }
        } else if (aName == SkillStatistic.AIR_MAGIC1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new Skill(SkillStatistic.AIR_MAGIC1);
                case 2:
                    return new Skill(SkillStatistic.AIR_MAGIC2);
                case 3:
                    return new Skill(SkillStatistic.AIR_MAGIC3);
            }
        } else if (aName == SkillStatistic.EARTH_MAGIC1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new Skill(SkillStatistic.EARTH_MAGIC1);
                case 2:
                    return new Skill(SkillStatistic.EARTH_MAGIC2);
                case 3:
                    return new Skill(SkillStatistic.EARTH_MAGIC3);
            }
        } else if (aName == SkillStatistic.FIRE_MAGIC1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new Skill(SkillStatistic.FIRE_MAGIC1);
                case 2:
                    return new Skill(SkillStatistic.FIRE_MAGIC2);
                case 3:
                    return new Skill(SkillStatistic.FIRE_MAGIC3);
            }
        } else if (aName == SkillStatistic.WATER_MAGIC1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new Skill(SkillStatistic.WATER_MAGIC1);
                case 2:
                    return new Skill(SkillStatistic.WATER_MAGIC2);
                case 3:
                    return new Skill(SkillStatistic.WATER_MAGIC3);
            }
        }
        throw new IllegalArgumentException(EXCEPTION_MESSEAGE);
    }

    public static Skill createForTest(String aName, int tier) {
        if (aName == SkillStatistic.OFFENCE1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new Skill(SkillStatistic.OFFENCE1);
                case 2:
                    return new Skill(SkillStatistic.OFFENCE2);
                case 3:
                    return new Skill(SkillStatistic.OFFENCE3);
            }
        } else if (aName == SkillStatistic.ARCHERY1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new Skill(SkillStatistic.ARCHERY1);
                case 2:
                    return new Skill(SkillStatistic.ARCHERY2);
                case 3:
                    return new Skill(SkillStatistic.ARCHERY3);
            }
        } else if (aName == SkillStatistic.ARMOURER1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new Skill(SkillStatistic.ARMOURER1);
                case 2:
                    return new Skill(SkillStatistic.ARMOURER2);
                case 3:
                    return new Skill(SkillStatistic.ARMOURER3);
            }
        } else if (aName == SkillStatistic.LEADERSHIP1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new Skill(SkillStatistic.LEADERSHIP1);
                case 2:
                    return new Skill(SkillStatistic.LEADERSHIP2);
                case 3:
                    return new Skill(SkillStatistic.LEADERSHIP3);
            }
        } else if (aName == SkillStatistic.LUCK1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new Skill(SkillStatistic.LUCK1);
                case 2:
                    return new Skill(SkillStatistic.LUCK2);
                case 3:
                    return new Skill(SkillStatistic.LUCK3);
            }
        } else if (aName == SkillStatistic.RESISTANCE1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new Skill(SkillStatistic.RESISTANCE1);
                case 2:
                    return new Skill(SkillStatistic.RESISTANCE2);
                case 3:
                    return new Skill(SkillStatistic.RESISTANCE3);
            }
        } else if (aName == SkillStatistic.ARCHERY1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new Skill(SkillStatistic.INTELLIGENCE1);
                case 2:
                    return new Skill(SkillStatistic.INTELLIGENCE2);
                case 3:
                    return new Skill(SkillStatistic.INTELLIGENCE3);
            }
        } else if (aName == SkillStatistic.WISDOM1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new Skill(SkillStatistic.WISDOM1);
                case 2:
                    return new Skill(SkillStatistic.WISDOM2);
                case 3:
                    return new Skill(SkillStatistic.WISDOM3);
            }
        } else if (aName == SkillStatistic.SORCERY1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new Skill(SkillStatistic.SORCERY1);
                case 2:
                    return new Skill(SkillStatistic.SORCERY2);
                case 3:
                    return new Skill(SkillStatistic.SORCERY3);
            }
        } else if (aName == SkillStatistic.ARTILLERY1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new Skill(SkillStatistic.ARTILLERY1);
                case 2:
                    return new Skill(SkillStatistic.ARTILLERY2);
                case 3:
                    return new Skill(SkillStatistic.ARTILLERY3);
            }
        } else if (aName == SkillStatistic.BALLISTICS1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new Skill(SkillStatistic.BALLISTICS1);
                case 2:
                    return new Skill(SkillStatistic.BALLISTICS2);
                case 3:
                    return new Skill(SkillStatistic.BALLISTICS3);
            }
        } else if (aName == SkillStatistic.FIRSTAID1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new Skill(SkillStatistic.FIRSTAID1);
                case 2:
                    return new Skill(SkillStatistic.FIRSTAID2);
                case 3:
                    return new Skill(SkillStatistic.FIRSTAID3);
            }
        } else if (aName == SkillStatistic.EAGLEEYE1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new Skill(SkillStatistic.EAGLEEYE1);
                case 2:
                    return new Skill(SkillStatistic.EAGLEEYE2);
                case 3:
                    return new Skill(SkillStatistic.EAGLEEYE3);
            }
        } else if (aName == SkillStatistic.AIR_MAGIC1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new Skill(SkillStatistic.AIR_MAGIC1);
                case 2:
                    return new Skill(SkillStatistic.AIR_MAGIC2);
                case 3:
                    return new Skill(SkillStatistic.AIR_MAGIC3);
            }
        } else if (aName == SkillStatistic.EARTH_MAGIC1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new Skill(SkillStatistic.EARTH_MAGIC1);
                case 2:
                    return new Skill(SkillStatistic.EARTH_MAGIC2);
                case 3:
                    return new Skill(SkillStatistic.EARTH_MAGIC3);
            }
        } else if (aName == SkillStatistic.FIRE_MAGIC1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new Skill(SkillStatistic.FIRE_MAGIC1);
                case 2:
                    return new Skill(SkillStatistic.FIRE_MAGIC2);
                case 3:
                    return new Skill(SkillStatistic.FIRE_MAGIC3);
            }
        } else if (aName == SkillStatistic.WATER_MAGIC1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new Skill(SkillStatistic.WATER_MAGIC1);
                case 2:
                    return new Skill(SkillStatistic.WATER_MAGIC2);
                case 3:
                    return new Skill(SkillStatistic.WATER_MAGIC3);
            }
        }
        else {
            throw new IllegalArgumentException(EXCEPTION_MESSEAGE);
        }
        return null;
    }
}
