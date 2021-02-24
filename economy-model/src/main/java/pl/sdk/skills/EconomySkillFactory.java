package pl.sdk.skills;

public class EconomySkillFactory {

    private static String EXCEPTION_MESSEAGE = "There is no such economy skill";

    public EconomySkill create(String aName, int tier) {
                    if (aName == SkillStatistic.OFFENCE1.getCoreName()) {
                        switch (tier) {
                            case 1:
                                return new EconomySkill(SkillStatistic.OFFENCE1, 100);
                            case 2:
                                return new EconomySkill(SkillStatistic.OFFENCE2, 200);
                            case 3:
                                return new EconomySkill(SkillStatistic.OFFENCE3, 300);
                        }
                    } else if (aName == SkillStatistic.ARCHERY1.getCoreName()) {
                        switch (tier) {
                            case 1:
                                return new EconomySkill(SkillStatistic.ARCHERY1, 100);
                            case 2:
                                return new EconomySkill(SkillStatistic.ARCHERY2, 200);
                            case 3:
                                return new EconomySkill(SkillStatistic.ARCHERY3, 300);
                        }
                    } else if (aName == SkillStatistic.ARMOURER1.getCoreName()) {
                        switch (tier) {
                            case 1:
                                return new EconomySkill(SkillStatistic.ARMOURER1, 100);
                            case 2:
                                return new EconomySkill(SkillStatistic.ARMOURER2, 200);
                            case 3:
                                return new EconomySkill(SkillStatistic.ARMOURER3, 300);
                        }
                    } else if (aName == SkillStatistic.LEADERSHIP1.getCoreName()) {
                        switch (tier) {
                            case 1:
                                return new EconomySkill(SkillStatistic.LEADERSHIP1, 100);
                            case 2:
                                return new EconomySkill(SkillStatistic.LEADERSHIP2, 200);
                            case 3:
                                return new EconomySkill(SkillStatistic.LEADERSHIP3, 300);
                        }
                    } else if (aName == SkillStatistic.LUCK1.getCoreName()) {
                        switch (tier) {
                            case 1:
                                return new EconomySkill(SkillStatistic.LUCK1, 100);
                            case 2:
                                return new EconomySkill(SkillStatistic.LUCK2, 200);
                            case 3:
                                return new EconomySkill(SkillStatistic.LUCK3, 300);
                        }
                    } else if (aName == SkillStatistic.RESISTANCE1.getCoreName()) {
                        switch (tier) {
                            case 1:
                                return new EconomySkill(SkillStatistic.RESISTANCE1, 100);
                            case 2:
                                return new EconomySkill(SkillStatistic.RESISTANCE2, 200);
                            case 3:
                                return new EconomySkill(SkillStatistic.RESISTANCE3, 300);
                        }
                    } else if (aName == SkillStatistic.INTELLIGENCE1.getCoreName()) {
                        switch (tier) {
                            case 1:
                                return new EconomySkill(SkillStatistic.INTELLIGENCE1, 100);
                            case 2:
                                return new EconomySkill(SkillStatistic.INTELLIGENCE2, 200);
                            case 3:
                                return new EconomySkill(SkillStatistic.INTELLIGENCE3, 300);
                        }
                    } else if (aName == SkillStatistic.WISDOM1.getCoreName()) {
                        switch (tier) {
                            case 1:
                                return new EconomySkill(SkillStatistic.WISDOM1, 100);
                            case 2:
                                return new EconomySkill(SkillStatistic.WISDOM2, 200);
                            case 3:
                                return new EconomySkill(SkillStatistic.WISDOM3, 300);
                        }
                    } else if (aName == SkillStatistic.SORCERY1.getCoreName()) {
                        switch (tier) {
                            case 1:
                                return new EconomySkill(SkillStatistic.SORCERY1, 100);
                            case 2:
                                return new EconomySkill(SkillStatistic.SORCERY2, 200);
                            case 3:
                                return new EconomySkill(SkillStatistic.SORCERY3, 300);
                        }
                    } else if (aName == SkillStatistic.ARTILLERY1.getCoreName()) {
                        switch (tier) {
                            case 1:
                                return new EconomySkill(SkillStatistic.ARTILLERY1, 100);
                            case 2:
                                return new EconomySkill(SkillStatistic.ARTILLERY2, 200);
                            case 3:
                                return new EconomySkill(SkillStatistic.ARTILLERY3, 300);
                        }
                    } else if (aName == SkillStatistic.BALLISTICS1.getCoreName()) {
                        switch (tier) {
                            case 1:
                                return new EconomySkill(SkillStatistic.BALLISTICS1, 100);
                            case 2:
                                return new EconomySkill(SkillStatistic.BALLISTICS2, 200);
                            case 3:
                                return new EconomySkill(SkillStatistic.BALLISTICS3, 300);
                        }
                    } else if (aName == SkillStatistic.FIRSTAID1.getCoreName()) {
                        switch (tier) {
                            case 1:
                                return new EconomySkill(SkillStatistic.FIRSTAID1, 100);
                            case 2:
                                return new EconomySkill(SkillStatistic.FIRSTAID2, 200);
                            case 3:
                                return new EconomySkill(SkillStatistic.FIRSTAID3, 300);
                        }
                    } else if (aName == SkillStatistic.EAGLEEYE1.getCoreName()) {
                        switch (tier) {
                            case 1:
                                return new EconomySkill(SkillStatistic.EAGLEEYE1, 100);
                            case 2:
                                return new EconomySkill(SkillStatistic.EAGLEEYE2, 200);
                            case 3:
                                return new EconomySkill(SkillStatistic.EAGLEEYE3, 300);
                        }
                    } else if (aName == SkillStatistic.AIR_MAGIC1.getCoreName()) {
                        switch (tier) {
                            case 1:
                                return new EconomySkill(SkillStatistic.AIR_MAGIC1, 100);
                            case 2:
                                return new EconomySkill(SkillStatistic.AIR_MAGIC2, 200);
                            case 3:
                                return new EconomySkill(SkillStatistic.AIR_MAGIC3, 300);
                        }
                    } else if (aName == SkillStatistic.EARTH_MAGIC1.getCoreName()) {
                        switch (tier) {
                            case 1:
                    return new EconomySkill(SkillStatistic.EARTH_MAGIC1, 100);
                case 2:
                    return new EconomySkill(SkillStatistic.EARTH_MAGIC2, 200);
                case 3:
                    return new EconomySkill(SkillStatistic.EARTH_MAGIC3, 300);
            }
        } else if (aName == SkillStatistic.FIRE_MAGIC1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new EconomySkill(SkillStatistic.FIRE_MAGIC1, 100);
                case 2:
                    return new EconomySkill(SkillStatistic.FIRE_MAGIC2, 200);
                case 3:
                    return new EconomySkill(SkillStatistic.FIRE_MAGIC3, 300);
            }
        } else if (aName == SkillStatistic.WATER_MAGIC1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new EconomySkill(SkillStatistic.WATER_MAGIC1, 100);
                case 2:
                    return new EconomySkill(SkillStatistic.WATER_MAGIC2, 200);
                case 3:
                    return new EconomySkill(SkillStatistic.WATER_MAGIC3, 300);
            }
        }
        throw new IllegalArgumentException(EXCEPTION_MESSEAGE);
    }

    public static EconomySkill createForTest(String aName, int tier) {
        if (aName == SkillStatistic.OFFENCE1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new EconomySkill(SkillStatistic.OFFENCE1, 100);
                case 2:
                    return new EconomySkill(SkillStatistic.OFFENCE2, 200);
                case 3:
                    return new EconomySkill(SkillStatistic.OFFENCE3, 300);
            }
        } else if (aName == SkillStatistic.ARCHERY1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new EconomySkill(SkillStatistic.ARCHERY1, 100);
                case 2:
                    return new EconomySkill(SkillStatistic.ARCHERY2, 200);
                case 3:
                    return new EconomySkill(SkillStatistic.ARCHERY3, 300);
            }
        } else if (aName == SkillStatistic.ARMOURER1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new EconomySkill(SkillStatistic.ARMOURER1, 100);
                case 2:
                    return new EconomySkill(SkillStatistic.ARMOURER2, 200);
                case 3:
                    return new EconomySkill(SkillStatistic.ARMOURER3, 300);
            }
        } else if (aName == SkillStatistic.LEADERSHIP1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new EconomySkill(SkillStatistic.LEADERSHIP1, 100);
                case 2:
                    return new EconomySkill(SkillStatistic.LEADERSHIP2, 200);
                case 3:
                    return new EconomySkill(SkillStatistic.LEADERSHIP3, 300);
            }
        } else if (aName == SkillStatistic.LUCK1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new EconomySkill(SkillStatistic.LUCK1, 100);
                case 2:
                    return new EconomySkill(SkillStatistic.LUCK2, 200);
                case 3:
                    return new EconomySkill(SkillStatistic.LUCK3, 300);
            }
        } else if (aName == SkillStatistic.RESISTANCE1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new EconomySkill(SkillStatistic.RESISTANCE1, 100);
                case 2:
                    return new EconomySkill(SkillStatistic.RESISTANCE2, 200);
                case 3:
                    return new EconomySkill(SkillStatistic.RESISTANCE3, 300);
            }
        } else if (aName == SkillStatistic.INTELLIGENCE1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new EconomySkill(SkillStatistic.INTELLIGENCE1, 100);
                case 2:
                    return new EconomySkill(SkillStatistic.INTELLIGENCE2, 200);
                case 3:
                    return new EconomySkill(SkillStatistic.INTELLIGENCE3, 300);
            }
        } else if (aName == SkillStatistic.WISDOM1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new EconomySkill(SkillStatistic.WISDOM1, 100);
                case 2:
                    return new EconomySkill(SkillStatistic.WISDOM2, 200);
                case 3:
                    return new EconomySkill(SkillStatistic.WISDOM3, 300);
            }
        } else if (aName == SkillStatistic.SORCERY1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new EconomySkill(SkillStatistic.SORCERY1, 100);
                case 2:
                    return new EconomySkill(SkillStatistic.SORCERY2, 200);
                case 3:
                    return new EconomySkill(SkillStatistic.SORCERY3, 300);
            }
        } else if (aName == SkillStatistic.ARTILLERY1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new EconomySkill(SkillStatistic.ARTILLERY1, 100);
                case 2:
                    return new EconomySkill(SkillStatistic.ARTILLERY2, 200);
                case 3:
                    return new EconomySkill(SkillStatistic.ARTILLERY3, 300);
            }
        } else if (aName == SkillStatistic.BALLISTICS1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new EconomySkill(SkillStatistic.BALLISTICS1, 100);
                case 2:
                    return new EconomySkill(SkillStatistic.BALLISTICS2, 200);
                case 3:
                    return new EconomySkill(SkillStatistic.BALLISTICS3, 300);
            }
        } else if (aName == SkillStatistic.FIRSTAID1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new EconomySkill(SkillStatistic.FIRSTAID1, 100);
                case 2:
                    return new EconomySkill(SkillStatistic.FIRSTAID2, 200);
                case 3:
                    return new EconomySkill(SkillStatistic.FIRSTAID3, 300);
            }
        } else if (aName == SkillStatistic.EAGLEEYE1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new EconomySkill(SkillStatistic.EAGLEEYE1, 100);
                case 2:
                    return new EconomySkill(SkillStatistic.EAGLEEYE2, 200);
                case 3:
                    return new EconomySkill(SkillStatistic.EAGLEEYE3, 300);
            }
        } else if (aName == SkillStatistic.AIR_MAGIC1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new EconomySkill(SkillStatistic.AIR_MAGIC1, 100);
                case 2:
                    return new EconomySkill(SkillStatistic.AIR_MAGIC2, 200);
                case 3:
                    return new EconomySkill(SkillStatistic.AIR_MAGIC3, 300);
            }
        } else if (aName == SkillStatistic.EARTH_MAGIC1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new EconomySkill(SkillStatistic.EARTH_MAGIC1, 100);
                case 2:
                    return new EconomySkill(SkillStatistic.EARTH_MAGIC2, 200);
                case 3:
                    return new EconomySkill(SkillStatistic.EARTH_MAGIC3, 300);
            }
        } else if (aName == SkillStatistic.FIRE_MAGIC1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new EconomySkill(SkillStatistic.FIRE_MAGIC1, 100);
                case 2:
                    return new EconomySkill(SkillStatistic.FIRE_MAGIC2, 200);
                case 3:
                    return new EconomySkill(SkillStatistic.FIRE_MAGIC3, 300);
            }
        } else if (aName == SkillStatistic.WATER_MAGIC1.getCoreName()) {
            switch (tier) {
                case 1:
                    return new EconomySkill(SkillStatistic.WATER_MAGIC1, 100);
                case 2:
                    return new EconomySkill(SkillStatistic.WATER_MAGIC2, 200);
                case 3:
                    return new EconomySkill(SkillStatistic.WATER_MAGIC3, 300);
            }
        }
        throw new IllegalArgumentException(EXCEPTION_MESSEAGE);
    }
    public EconomySkill listAllSkill(int a,int tier){
        if (a == 1) {
            switch (tier) {
                case 1:
                    return new EconomySkill(SkillStatistic.OFFENCE1, 100);
                case 2:
                    return new EconomySkill(SkillStatistic.OFFENCE2, 200);
                case 3:
                    return new EconomySkill(SkillStatistic.OFFENCE3, 300);
            }
        } else if (a == 2) {
            switch (tier) {
                case 1:
                    return new EconomySkill(SkillStatistic.ARCHERY1, 100);
                case 2:
                    return new EconomySkill(SkillStatistic.ARCHERY2, 200);
                case 3:
                    return new EconomySkill(SkillStatistic.ARCHERY3, 300);
            }
        } else if (a == 3) {
            switch (tier) {
                case 1:
                    return new EconomySkill(SkillStatistic.ARMOURER1, 100);
                case 2:
                    return new EconomySkill(SkillStatistic.ARMOURER2, 200);
                case 3:
                    return new EconomySkill(SkillStatistic.ARMOURER3, 300);
            }
        } else if (a == 4) {
            switch (tier) {
                case 1:
                    return new EconomySkill(SkillStatistic.LEADERSHIP1, 100);
                case 2:
                    return new EconomySkill(SkillStatistic.LEADERSHIP2, 200);
                case 3:
                    return new EconomySkill(SkillStatistic.LEADERSHIP3, 300);
            }
        } else if (a == 5) {
            switch (tier) {
                case 1:
                    return new EconomySkill(SkillStatistic.LUCK1, 100);
                case 2:
                    return new EconomySkill(SkillStatistic.LUCK2, 200);
                case 3:
                    return new EconomySkill(SkillStatistic.LUCK3, 300);
            }
        } else if (a == 6) {
            switch (tier) {
                case 1:
                    return new EconomySkill(SkillStatistic.RESISTANCE1, 100);
                case 2:
                    return new EconomySkill(SkillStatistic.RESISTANCE2, 200);
                case 3:
                    return new EconomySkill(SkillStatistic.RESISTANCE3, 300);
            }
        } else if (a == 7) {
            switch (tier) {
                case 1:
                    return new EconomySkill(SkillStatistic.INTELLIGENCE1, 100);
                case 2:
                    return new EconomySkill(SkillStatistic.INTELLIGENCE2, 200);
                case 3:
                    return new EconomySkill(SkillStatistic.INTELLIGENCE3, 300);
            }
        } else if (a == 8) {
            switch (tier) {
                case 1:
                    return new EconomySkill(SkillStatistic.WISDOM1, 100);
                case 2:
                    return new EconomySkill(SkillStatistic.WISDOM2, 200);
                case 3:
                    return new EconomySkill(SkillStatistic.WISDOM3, 300);
            }
        } else if (a == 9) {
            switch (tier) {
                case 1:
                    return new EconomySkill(SkillStatistic.SORCERY1, 100);
                case 2:
                    return new EconomySkill(SkillStatistic.SORCERY2, 200);
                case 3:
                    return new EconomySkill(SkillStatistic.SORCERY3, 300);
            }
        } else if (a == 10) {
            switch (tier) {
                case 1:
                    return new EconomySkill(SkillStatistic.ARTILLERY1, 100);
                case 2:
                    return new EconomySkill(SkillStatistic.ARTILLERY2, 200);
                case 3:
                    return new EconomySkill(SkillStatistic.ARTILLERY3, 300);
            }
        } else if (a == 11) {
            switch (tier) {
                case 1:
                    return new EconomySkill(SkillStatistic.BALLISTICS1, 100);
                case 2:
                    return new EconomySkill(SkillStatistic.BALLISTICS2, 200);
                case 3:
                    return new EconomySkill(SkillStatistic.BALLISTICS3, 300);
            }
        } else if (a == 12) {
            switch (tier) {
                case 1:
                    return new EconomySkill(SkillStatistic.FIRSTAID1, 100);
                case 2:
                    return new EconomySkill(SkillStatistic.FIRSTAID2, 200);
                case 3:
                    return new EconomySkill(SkillStatistic.FIRSTAID3, 300);
            }
        } else if (a == 13) {
            switch (tier) {
                case 1:
                    return new EconomySkill(SkillStatistic.EAGLEEYE1, 100);
                case 2:
                    return new EconomySkill(SkillStatistic.EAGLEEYE2, 200);
                case 3:
                    return new EconomySkill(SkillStatistic.EAGLEEYE3, 300);
            }
        } else if (a == 14) {
            switch (tier) {
                case 1:
                    return new EconomySkill(SkillStatistic.AIR_MAGIC1, 100);
                case 2:
                    return new EconomySkill(SkillStatistic.AIR_MAGIC2, 200);
                case 3:
                    return new EconomySkill(SkillStatistic.AIR_MAGIC3, 300);
            }
        } else if (a == 15) {
            switch (tier) {
                case 1:
                    return new EconomySkill(SkillStatistic.EARTH_MAGIC1, 100);
                case 2:
                    return new EconomySkill(SkillStatistic.EARTH_MAGIC2, 200);
                case 3:
                    return new EconomySkill(SkillStatistic.EARTH_MAGIC3, 300);
            }
        } else if (a == 16) {
            switch (tier) {
                case 1:
                    return new EconomySkill(SkillStatistic.FIRE_MAGIC1, 100);
                case 2:
                    return new EconomySkill(SkillStatistic.FIRE_MAGIC2, 200);
                case 3:
                    return new EconomySkill(SkillStatistic.FIRE_MAGIC3, 300);
            }
        } else if (a == 17) {
            switch (tier) {
                case 1:
                    return new EconomySkill(SkillStatistic.WATER_MAGIC1, 100);
                case 2:
                    return new EconomySkill(SkillStatistic.WATER_MAGIC2, 200);
                case 3:
                    return new EconomySkill(SkillStatistic.WATER_MAGIC3, 300);
            }
        }
        throw new IllegalArgumentException(EXCEPTION_MESSEAGE);
    }
}


