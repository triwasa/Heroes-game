package pl.sdk.artifacts;

import java.util.HashMap;

public class HeroEquipment {

    private HashMap<String, Artifact> equipment = new HashMap<>();

    void equip(Artifact artifact){
        if (equipment.containsKey(artifact.getSlotName())) {
            throw new IllegalStateException("Hero has got already item with same slot name");
        }
        else{
            equipment.put(artifact.getSlotName(), artifact);
        }
    }
}
