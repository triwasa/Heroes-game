package pl.sdk.creatures;

public class PossibleAttackManagerForCreature implements PossibleAttackManagerIf {
    @Override
    public boolean canFortificationAttack() {
        return false;
    }

    @Override
    public boolean canCreatureAttack() {
        return true;
    }
}
