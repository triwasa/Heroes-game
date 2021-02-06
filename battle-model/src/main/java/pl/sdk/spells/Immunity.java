package pl.sdk.artifacts;

import pl.sdk.spells.Spell;
import pl.sdk.spells.SpellEnum;
import pl.sdk.spells.SpellFactory;

import java.util.List;

public class Immunity {
    private List<Spell> spells;

    protected void add(SpellEnum aSpellName){
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

    private Spell createSpell(SpellEnum spellName) {
        SpellFactory spellFactory = new SpellFactory();
        return spellFactory.create(spellName);
    }
}
