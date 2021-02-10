package pl.sdk.hero;

public class HeroMana {
    private double mana;
    
    public HeroMana(int heroKnowledge) {
        mana = heroKnowledge * 10;
    }

    public void increaseMana(int value) {
        mana += value * 10;
    }

    public void increaseManaPercent(double percent) {
        mana = mana + (mana * percent);
    }
    
    public int getMana() {
        return (int) Math.round(mana);
    }
}
