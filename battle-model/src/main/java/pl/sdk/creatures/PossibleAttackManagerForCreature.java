package pl.sdk.creatures;

public class PossibleAttackManagerForCreature implements PossbileAttackMangerIf {
    @Override
    public boolean canFortifficationAttack() {
        return false;
    }

    @Override
    public boolean canCreatureAttack() {
        return true;
    }
}
