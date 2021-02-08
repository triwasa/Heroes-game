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
    void FactoryShouldCreateArtifactsCorrectly(){
        List<EconomyArtifact> economyArtifacts = new ArrayList<>();
        List<AbstractArtifact> artifacts = new ArrayList<>();

        economyArtifacts.add(economyArtifactFactory.create(CENTAURS_AX)); // primary
        economyArtifacts.add(economyArtifactFactory.create(RING_OF_VITALITY)); // health
        economyArtifacts.add(economyArtifactFactory.create(GARNITURE_OF_INTERFERENCE)); // speed
        economyArtifacts.add(economyArtifactFactory.create(NECKLACE_OF_SWIFTNESS)); // res
        economyArtifacts.add(economyArtifactFactory.create(COLLAR_OF_CONJURING)); // duration
        economyArtifacts.add(economyArtifactFactory.create(ORB_OF_THE_FIRMAMENT)); // dmg
        economyArtifacts.add(economyArtifactFactory.create(TOME_OF_AIR_MAGIC)); // type
        economyArtifacts.add(economyArtifactFactory.create(SPELLBINDERS_HAT)); // tier


        economyArtifacts.forEach(economyArtifact ->
                artifacts.add(abstractFactory.create(economyArtifact.getName()))
        );
    }
}
