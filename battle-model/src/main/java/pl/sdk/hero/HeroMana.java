package pl.sdk.hero;
import java.lang.Math;

public class HeroMana {
    private double mana;
    
    public HeroMana(int heroKnowledge) {
        mana = (double) heroKnowledge * 10.0;
    }

    public void increaseMana(int value) {
        mana += (double) value * 10.0;
    }

    public void increaseManaPercent(double percent) {
        mana = mana + (mana * percent);
    }
    
    public int getMana() {
        return (int) Math.round(mana);
    }
}
