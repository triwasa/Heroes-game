package pl.sdk.hero;

import pl.sdk.artifacts.EconomyArtifact;


public class ArtifactShop {

    public void buy(EconomyHero aHero, EconomyArtifact aArtifact){
        aHero.substractGold(aArtifact.getGoldCost());
        try{
            aHero.addArtifact(aArtifact);
        }catch (Exception e){
            aHero.addGold(aArtifact.getGoldCost());
            throw new IllegalStateException("Hero can't buy artifact");
        }
    }
}
