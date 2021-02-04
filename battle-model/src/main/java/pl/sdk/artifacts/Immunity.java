package pl.sdk.artifacts;

import pl.sdk.spells.Spell;
import pl.sdk.spells.SpellEnum;
import pl.sdk.spells.SpellFactory;

import java.util.List;

public class Immunity {
    private List<Spell> spells;
    private int resistance;

    protected void addSingleImmunity(SpellEnum aSpellName){
        Spell spell = createSpell(aSpellName);
        if(!spells.contains(spell)){
            spells.add(spell);
        }
        else{
            throw new IllegalArgumentException("Creature already have that spell immunity");
        }
    }

    protected void addImmunitiesByTier(int aTier){
        // TODO think about in which module SpellsCreator should be
//        List<Spell> spellsByTier = SpellsCreator.createSpellsByTier(aTier);
//        spellsByTier.forEach(spell -> {
//            if(!spellsByTier.contains(spell)){
//                spellsByTier.add(spell);
//            }
//        });
    }

    protected void addImmunitiesByMagicType(String aMagicType){
        // TODO think about in which module SpellsCreator should be
//        List<Spell> spellsByTier = SpellsCreator.createSpellsByMagicType(aMagicType);
//        spellsByTier.forEach(spell -> {
//            if(!spellsByTier.contains(spell)){
//                spellsByTier.add(spell);
//            }
//        });
    }

    protected void addResistance(int aResistance){
        resistance += aResistance;
    }

    protected int getResistance(){
        int resistanceToReturn = resistance;
        return resistanceToReturn;
    }

    protected Boolean checkImmunity(Spell aSpell){
        return spells.contains(aSpell);
    }

    private Spell createSpell(SpellEnum spellName) {
        SpellFactory spellFactory = new SpellFactory();
        return spellFactory.create(spellName);
    }
}
