package pl.sdk.artifacts;

import pl.sdk.spells.Spell;

import java.util.List;

public class ArtifactSpellBookTier extends ArtifactSpellBuff {
    private final int tier;

    public ArtifactSpellBookTier(ArtifactStatistic aStat, int aTier) {
        stats = aStat;
        this.tier = aTier;
    }

    @Override
    void buffSpell(List<Spell> spells) {
        List<Spell> spellsToAdd = createSpells();
        spellsToAdd.forEach(spell -> {
            if(!spells.contains(spell)) {
                spells.add(spell);
            }});
    }

    private List<Spell> createSpells() {
        SpellsCreator spellsCreator = new SpellsCreator();
        return spellsCreator.createSpellsByTier(tier);
    }
}
