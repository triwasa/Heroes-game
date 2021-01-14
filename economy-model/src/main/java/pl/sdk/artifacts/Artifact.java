package pl.sdk.artifacts;

public class Artifact {

    private final ArtifactStatisticIf stats;
    private int attackSkill;
    private int defenceSkill;
    private int spellPower;
    private int knowledge;

    public Artifact(ArtifactStatisticIf aStats, int aAttackSkill, int aDefenceSkill, int aSpellPower, int aKnowledge) {
        this.stats = aStats;
        this.attackSkill = aAttackSkill;
        this.defenceSkill = aDefenceSkill;
        this.spellPower = aSpellPower;
        this.knowledge = aKnowledge;
    }

    public String getSlotName() { return stats.getSlotName(); }

    public int getAttackSkill() { return attackSkill; }

    public int getDefenceSkill() { return defenceSkill; }

    public int getSpellPower() { return spellPower; }

    public int getKnowledge() { return knowledge; }
}