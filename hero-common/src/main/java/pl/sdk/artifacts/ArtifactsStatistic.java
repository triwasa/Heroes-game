package pl.sdk.artifacts;

enum ArtifactsStatistic implements ArtifactsStatisticIf {
    ;


    private final String name;
    private final int attackSkill;
    private final int defenceSkill;
    private final int spellPower;
    private final int knowledge;
    private final String rarity;

    ArtifactsStatistic(String aName, int aAttackSkill, int aDefenceSkill, int aSpellPower, int aKnowledge, String aRarity) {
        this.name = aName;
        this.attackSkill = aAttackSkill;
        this.defenceSkill = aDefenceSkill;
        this.spellPower = aSpellPower;
        this.knowledge = aKnowledge;
        this.rarity = aRarity;
    }

    public String getTranslatedName() { return name; }

    public int getAttackSkill() { return attackSkill; }

    public int getDefenceSkill() { return defenceSkill; }

    public int getSpellPower() { return spellPower; }

    public int getKnowledge() { return knowledge; }

    public String getRarity() { return rarity; }
}
