package pl.sdk.creatures;

public class PossbileAttackManagerForCyclop implements PossibleAttackManagerIf {

    boolean canAttackAdvancedBallistics;
    PossbileAttackManagerForCyclop()
    @Override
    public boolean canFortificationAttack() {
        return false;
    }

    @Override
    public boolean canCreatureAttack() {
        return true;
    }
}
