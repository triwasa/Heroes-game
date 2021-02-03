package pl.sdk.creatures;

public class PossibleAttackManagerForMachine implements PossibleAttackManagerIf {
    @Override
    public boolean canFortificationAttack() {
        return true;
    }

    @Override
    public boolean canCreatureAttack() {
        return false;
    }
}
