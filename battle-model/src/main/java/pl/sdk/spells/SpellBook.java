package pl.sdk.spells;

import pl.sdk.Hero;

import java.util.HashMap;

public class SpellBook {
    private HashMap<Spell, Integer> spellBook = new HashMap<Spell, Integer>();
    private Hero owner = new Hero();

    public SpellBook(Hero hero){
        owner = hero;
    }

    public HashMap<Spell, Integer> getSpellBook(){
        return spellBook;
    }

    boolean contains(Spell spell) {
        return getSpellOfName(spell.getName()) != null;
    }

    public void addSpell(Spell spell){
        if(contains(spell)){
            spellBook.put(getSpellOfName(spell.getName()), spellBook.get(getSpellOfName(spell.getName()))+1);
        }
        else {
            spellBook.put(spell, 1);
        }
    }

    public void removeSpell(Spell spell){
        if(contains(spell)){
            spellBook.put(getSpellOfName(spell.getName()), getUsesOfSpell(getSpellOfName(spell.getName())) -1);
            if(getUsesOfSpell(getSpellOfName(spell.getName()))==0){
                spellBook.remove(getSpellOfName(spell.getName()));
            }
        }
    }
    public Integer getSize(){
        return spellBook.size();
    }

    public Spell getSpellOfName(String name){
        for(Spell i: spellBook.keySet()){
            if(i.getName().equals(name)){
                return i;
            }
        }
        return null;
    }


    public int getUsesOfSpell(Spell spell) {
        return this.spellBook.get(getSpellOfName(spell.getName()));
    }
}
