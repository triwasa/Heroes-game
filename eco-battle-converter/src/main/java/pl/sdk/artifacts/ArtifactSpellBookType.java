package pl.sdk.artifacts;

import pl.sdk.spells.Spell;

import java.util.List;

public class ArtifactSpellBookType extends ArtifactSpellBuff {
    private final String magicType;

    public ArtifactSpellBookType(ArtifactStatisticIf aStat, String aMagicType) {
        stats = aStat;
        this.magicType = aMagicType;
    }

    @Override
    void buffSpell(List<Spell> spells) {
        List<Spell> spellsToAdd = createSpells();
        spellsToAdd.forEach(spell -> {
            if(!spells.contains(spell)) {
                spells.add(spell);
            }});
    }

    private List<Spell> createSpells(){
        SpellsCreator spellsCreator = new SpellsCreator();
        return spellsCreator.createSpellsByMagicType(magicType);
    }
}
