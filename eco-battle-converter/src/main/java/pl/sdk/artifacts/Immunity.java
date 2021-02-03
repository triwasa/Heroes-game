package pl.sdk.artifacts;

public class Immunity {
    private List<Spell> spells;

    protected void add(String aSpellName){
        Spell spell = createSpell(aSpellName);
        if(!spells.contains(spell)){
            spells.add(spell);
        }
        else{
            throw new IllegalArgumentException("Creature already have that spell immunity");
        }
    }

    protected Boolean checkImmunity(Spell aSpell){
        if(spells.contains(aSpell)){
            return true;
        }
        else{
            return false;
        }
    }

    private Spell createSpell(String spellName) {
        SpellFactory spellFactory = new SpellFactory();
        return spellFactory.create(spellName);
    }
}
