package pl.sdk.spells;

public class SpellFactory {

    private static final String EXCEPTION_MESSAGE = "There is no spell with that name";

    public Spell create(SpellEnum recipeForSpell){
        return new Spell(recipeForSpell);
    }


}
