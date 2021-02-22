package pl.sdk.artifacts;

import org.junit.jupiter.api.Test;
import pl.sdk.hero.Hero;

import java.util.ArrayList;
import java.util.List;

import static pl.sdk.artifacts.ArtifactName.*;

public class ArtifactFactoryTest {
    private ArtifactFactory abstractFactory = new ArtifactFactory();
    private EconomyArtifactPrimaryFactory economyArtifactFactory = new EconomyArtifactPrimaryFactory();

    @Test
    void factoryShouldCreateArtifactsCorrectly(){
        List<EconomyArtifact> economyArtifacts = new ArrayList<>();
        List<AbstractArtifact> artifacts = new ArrayList<>();

        economyArtifacts.add(economyArtifactFactory.create(CENTAURS_AX));
        economyArtifacts.add(economyArtifactFactory.create(RING_OF_VITALITY));
        economyArtifacts.add(economyArtifactFactory.create(GARNITURE_OF_INTERFERENCE));
        economyArtifacts.add(economyArtifactFactory.create(NECKLACE_OF_SWIFTNESS));
        economyArtifacts.add(economyArtifactFactory.create(COLLAR_OF_CONJURING));
        economyArtifacts.add(economyArtifactFactory.create(ORB_OF_THE_FIRMAMENT));
        economyArtifacts.add(economyArtifactFactory.create(TOME_OF_AIR_MAGIC));
        economyArtifacts.add(economyArtifactFactory.create(SPELLBINDERS_HAT));

        economyArtifacts.forEach(economyArtifact ->
                artifacts.add(abstractFactory.create(economyArtifact.getName()))
        );
    }
}
