package pl.sdk.spell;

public class EconomySpellFactory {

    public EconomySpell create(EconomySpellEnum ese){
        return new EconomySpell(ese.getName(), ese.getCost(), ese.getType(), ese.getLevel());
    }
}
