package pl.sdk;

import pl.sdk.artifacts.ArtifactStatistic;
import pl.sdk.artifacts.EconomyArtifact;
import pl.sdk.artifacts.EconomyArtifactPrimaryFactory;
import pl.sdk.creatures.EconomyCreature;
import pl.sdk.hero.*;
import pl.sdk.skills.EconomySkill;
import pl.sdk.spell.EconomySpell;
import pl.sdk.hero.SpellShop;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class EconomyEngine {
    public static final String HERO_BOUGHT_CREATURE = "HERO_BOUGHT_CREATURE";
    public static final String ACTIVE_HERO_CHANGED = "ACTIVE_HERO_CHANGED";
    public static final String NEXT_ROUND = "NEXT_ROUND";
    public static final String HERO_BOUGHT_ARTIFACT = " HERO_BOUGHT_ARTIFACT";
    public static final String HERO_BOUGHT_SKILL = "HERO_BOUGHT_SKILL";
    public static final String HERO_BOUGHT_SPELL = "HERO_BOUGHT_SPELL";
    private final EconomyHero hero1;
    private final EconomyHero hero2;
    private EconomyHero activeHero;
    private final CreatureShop creatureShop = new CreatureShop();
    private final ArtifactShop artifactShop = new ArtifactShop();
    private final SkillShop skillShop = new SkillShop();
    private final SpellShop spellShop = new SpellShop();
    private int roundNumber;
    private final PropertyChangeSupport observerSupport;
    private final EconomyArtifactPrimaryFactory economyArtifactFactory = new EconomyArtifactPrimaryFactory();
    private List<EconomyArtifact> economyArtifactList;

    public EconomyEngine(EconomyHero aHero1, EconomyHero aHero2) {
        randomizeArtifactShop();
        hero1 = aHero1;
        hero2 = aHero2;
        activeHero = hero1;
        roundNumber = 1;
        observerSupport = new PropertyChangeSupport(this);
    }

    public void buy(EconomyCreature aEconomyCreature) {
        creatureShop.buy(activeHero,aEconomyCreature);
        observerSupport.firePropertyChange(HERO_BOUGHT_CREATURE, null, null);
    }

    public void buyArtifact(EconomyArtifact aArtifact) {
        artifactShop.buy(activeHero,aArtifact);
        observerSupport.firePropertyChange(HERO_BOUGHT_ARTIFACT, null, null);

    }

    public void buySkill(EconomySkill aSkill){
        skillShop.buy(activeHero,aSkill);
        observerSupport.firePropertyChange(HERO_BOUGHT_SKILL, null, null);
    }

    public void buySpell(EconomySpell aSpell){
        spellShop.buy(activeHero,aSpell);
        observerSupport.firePropertyChange(HERO_BOUGHT_SPELL, null, null);
    }

    public EconomyHero getActiveHero() {
        return activeHero;
    }

    public void pass() {
        if (activeHero == hero1){
            activeHero = hero2;
            observerSupport.firePropertyChange(ACTIVE_HERO_CHANGED, hero1, activeHero);
        }
        else{
            activeHero = hero1;
            observerSupport.firePropertyChange(ACTIVE_HERO_CHANGED, hero2, activeHero);
            endTurn();
        }
    }

    private void endTurn() {
        roundNumber += 1;
        hero1.addGold(2000*roundNumber);
        hero2.addGold(2000*roundNumber);
        randomizeArtifactShop();
        observerSupport.firePropertyChange(NEXT_ROUND, roundNumber - 1, roundNumber);
    }

    public void randomizeArtifactShop() {

        List<EconomyArtifact> economyArtifactsList = new ArrayList<>();
        Arrays.asList(ArtifactStatistic.values()).forEach(artifact -> economyArtifactsList.add(economyArtifactFactory.create(artifact.getTranslatedName())));
        Collections.shuffle(economyArtifactsList);
        economyArtifactList = economyArtifactsList
                .stream()
                .limit(5)
                .collect(Collectors.toList());
    }

    public List<EconomyArtifact> getEconomyArtifactList(){
        return List.copyOf(economyArtifactList);
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public void addObserver(String aPropertyName, PropertyChangeListener aObserver) {
        observerSupport.addPropertyChangeListener(aPropertyName, aObserver);
    }

    public EconomyHero getPlayer1() {
        //TODO make copy
        return hero1;
    }

    public EconomyHero getPlayer2() {
        //TODO make copy
        return hero2;
    }

}
