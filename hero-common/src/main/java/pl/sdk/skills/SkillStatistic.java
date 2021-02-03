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
        LUCK3("Luck: expert", "Luck",3, "+3 luck"),
        RESISTANCE1("Resistance: basic", "Resistance",1, "5% chance of spell failure"),
        RESISTANCE2("Resistance: advanced", "Resistance",2, "10% chance of spell failure"),
        RESISTANCE3("Resistance: expert", "Resistance",3, "20% chance of spell failure"),
        ARTILLERY1("Artillery: basic", "Artillery", 1, "ballista's shots have 50% chance of dealing double damage"),
        ARTILLERY2("Artillery: advanced", "Artillery", 2, "ballista's shots have 75% chance of dealing double damage"),
        ARTILLERY3("Artillery: expert", "Artillery", 3, "ballista's shots deal double damage"),
        INTELLIGENCE1("Intelligence: basic", "Intelligence", 1, "maximum spell points increased by 25%"),
        INTELLIGENCE2("Intelligence: advanced", "Intelligence", 2, "maximum spell points increased by 25%"),
        INTELLIGENCE3("Intelligence: expert", "Intelligence", 3, "maximum spell points increased by 50%"),
        WISDOM1("Wisdom: basic", "Wisdom", 1, "hero can learn spells level 3 and below"),
        WISDOM2("Wisdom: advanced", "Wisdom", 2, "hero can learn spells level 4 and below"),
        WISDOM3("Wisdom: expert", "Wisdom", 3, "hero can learn all spells"),
        SORCERY1("Sorcery: basic", "Sorcery", 1, "effectiveness of cast spells is increased by 5%"),
        SORCERY2("Sorcery: advanced", "Sorcery", 2, "effectiveness of cast spells is increased by 5%"),
        SORCERY3("Sorcery: expert", "Sorcery", 3, "effectiveness of cast spells is increased by 5%"),
        BALLISTICS1("Ballistics: basic", "Ballistics", 1, "catapult does 1 shot with 60% chance to hit the intended wall. 50% chance for maximum damage. Until all seige walls are destroyed, chance to hit arrow towers or drawbridge is less than 60%."),
        BALLISTICS2("Ballistics: advanced", "Ballistics", 2, "same as basic but catapult does 2 shots per turn"),
        BALLISTICS3("Ballistics: expert", "Ballistics", 3, "two shots of maximum damage, each with 75% chance to hit the intended wall."),
        FIRSTAID1("First aid: basic", "First aid", 1, "first aid tent regenerates up to 50 health on top creature in a troop"),
        FIRSTAID2("First aid: advanced", "First aid", 2, "first aid tent regenerates up to 75 health on top creature in a troop"),
        FIRSTAID3("First aid: expert", "First aid", 3, "first aid tent regenerates up to 100 health on top creature in a troop"),
        EAGLEEYE1("Eagle Eye: basic", "Eagle Eye", 1, "hero has a 40% chance to learn spells of level 2 and below from enemy hero"),
        EAGLEEYE2("Eagle Eye: advanced", "Eagle Eye", 2, "hero has a 50% chance to learn spells of level 2 and below from enemy hero"),
        EAGLEEYE3("Eagle Eye: expert", "Eagle Eye", 3, "hero has a 60% chance to learn spells of level 2 and below from enemy hero"),
        AIR_MAGIC1("Air Magic: basic", "Air Magic", 1,"Air Magic spells are cast at the basic level"),
        AIR_MAGIC2("Air Magic: advanced", "Air Magic", 2,"Air Magic spells are cast at the advanced level"),
        AIR_MAGIC3("Air Magic: expert", "Air Magic", 3,"Air Magic spells are cast at the expert level"),
        EARTH_MAGIC1("Earth Magic: basic", "Earth Magic", 1,"Earth Magic spells are cast at the basic level"),
        EARTH_MAGIC2("Earth Magic: advanced", "Earth Magic", 2,"Earth Magic spells are cast at the advanced level"),
        EARTH_MAGIC3("Earth Magic: expert", "Earth Magic", 3,"Earth Magic spells are cast at the expert level"),
        FIRE_MAGIC1("Fire Magic: basic", "Fire Magic", 1,"Fire Magic spells are cast at the basic level"),
        FIRE_MAGIC2("Fire Magic: advanced", "Fire Magic", 2,"Fire Magic spells are cast at the advanced level"),
        FIRE_MAGIC3("Fire Magic: expert", "Fire Magic", 3,"Fire Magic spells are cast at the expert level"),
        WATER_MAGIC1("Fire Magic: basic", "Water Magic", 1,"Fire Magic spells are cast at the basic level"),
        WATER_MAGIC2("Fire Magic: advanced", "Water Magic", 2,"Water Magic spells are cast at the advanced level"),
        WATER_MAGIC3("Fire Magic: expert", "Water Magic", 3,"Water Magic spells are cast at the expert level");

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

