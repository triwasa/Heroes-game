package pl.sdk.skills;

public enum SkillStatistic implements SkillStatisticIf{

        OFFENCE1("Offence: basic","Offence", 1, "Inflicted hand-to-hand damage is increased by 10%"),
        OFFENCE2("Offence: advanced", "Offence",2, "Inflicted hand-to-hand damage is increased by 20%"),
        OFFENCE3("Offence: expert", "Offence",3, "Inflicted hand-to-hand damage is increased by 30%"),
        ARCHERY1("Archery: basic", "Archery",1, "Ranged attack damage is increased by 10%"),
        ARCHERY2("Archery: advanced", "Archery", 2, "Ranged attack damage is increased by 20%"),
        ARCHERY3("Archery: expert", "Archery",3, "Ranged attack damage is increased by 30%"),
        ARMOURER1("Armourer: basic", "Armourer",1, "Damage inflicted on troops is reduced by 5%"),
        ARMOURER2("Armourer: advanced", "Armourer",2, "Damage inflicted on troops is reduced by 10%"),
        ARMOURER3("Armourer: expert", "Armourer",3, "Damage inflicted on troops is reduced by 15%"),
        LEADERSHIP1("Leadership: basic", "Leadership",1, "+1 morale"),
        LEADERSHIP2("Leadership: advanced", "Leadership",2, "+2 morale"),
        LEADERSHIP3("Leadership: expert", "Leadership",3, "+3 morale"),
        LUCK1("Luck: basic","Luck",1, "+1 luck"),
        LUCK2("Luck: advanced", "Luck",2, "+2 luck"),
        LUCK3("Luck: expert", "Luck",3, "+3 luck");

        private final String name;
        private final String coreName;
        private final int tier;
        private final String description;

    SkillStatistic(String aName, String aCoreName, int aTier, String aDescription) {
            this.name = aName;
            this.coreName = aCoreName;
            this.tier = aTier;
            this.description = aDescription;
        }



        public String getName() {
            return name;
        }

        public String getCoreName() {
            return coreName;
        }

        public int getTier(){
            return tier;
        }

        public String getDescription(){
            return description;
        }

    }

