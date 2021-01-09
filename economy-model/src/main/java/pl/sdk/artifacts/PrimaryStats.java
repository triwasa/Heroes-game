package pl.sdk.artifacts;

public class PrimaryStats implements PrimaryStatisticIf{
    private int attack;
    private int defence;
    private int spellPower;
    private int knowledge;

    public PrimaryStats(int aAttack, int aDefence, int aSpellPower, int aKnowledge){
        this.attack = aAttack;
        this.defence = aDefence;
        this.spellPower = aSpellPower;
        this.knowledge = aKnowledge;
    }

    public int getAttack() { return attack; }

    public int getDefence() { return defence; }

    public int getSpellPower() { return spellPower; }

    public int getKnowledge() { return knowledge; }
}
