package pl.sdk.artifacts;

class Artifact {

    private final ArtifactStatisticIf stats;
    private int attack;
    private int defence;
    private int spellPower;
    private int knowledge;

    public Artifact(ArtifactStatisticIf aStats, int aAttackSkill, int aDefenceSkill, int aSpellPower, int aKnowledge) {
        this.stats = aStats;
        this.attack = aAttackSkill;
        this.defence = aDefenceSkill;
        this.spellPower = aSpellPower;
        this.knowledge = aKnowledge;
    }

    public String getSlotName() { return stats.getSlotName(); }

    public int getAttack() { return attack; }

    public int getDefence() { return defence; }

    public int getSpellPower() { return spellPower; }

    public int getKnowledge() { return knowledge; }
}
