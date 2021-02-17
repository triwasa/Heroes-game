package pl.sdk.artifacts;

import java.util.HashMap;
import java.util.List;

public class HeroEquipment {

    private HashMap<String, EconomyArtifact> equipment = new HashMap<>();

    public void equip(EconomyArtifact artifact){
        if (equipment.containsKey(artifact.getSlotName())) {
            throw new IllegalStateException("Hero has got already item with same slot name");
        }
        else{
            equipment.put(artifact.getSlotName(), artifact);
        }
    }

    public List<EconomyArtifact> getArtifacts() {
        return List.copyOf(equipment.values());
    }

}
