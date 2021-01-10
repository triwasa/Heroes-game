package pl.sdk.artifacts;

import java.util.HashMap;
import java.util.List;

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

    List<Artifact> getArtifacts() {
        return List.copyOf(equipment.values());
    }

    int getAttack() {
        int sum = 0;
        for (Artifact artifact : equipment.values()){
            sum += artifact.getAttack();
        }
        return sum;
    }

    int getDefence() {
        int sum = 0;
        for (Artifact artifact : equipment.values()){
            sum += artifact.getDefence();
        }
        return sum;
    }

    int getSpellPower() {
        int sum = 0;
        for (Artifact artifact : equipment.values()){
            sum += artifact.getSpellPower();
        }
        return sum;
    }

    int getKnowledge() {
        int sum = 0;
        for (Artifact artifact : equipment.values()){
            sum += artifact.getKnowledge();
        }
        return sum;
    }
}
