package pl.sdk.creatures;

public class PossibleAttackManagerForMachine implements PossibleAttackManagerIf {
    @Override
    public boolean canFortificationAttack(Fortification fortification) {
        return true;
    }

    @Override
    public boolean canCreatureAttack() {
        return false;
    }
}
