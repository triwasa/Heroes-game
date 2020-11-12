package pl.sdk;

public class BlockCounterAttackCreature extends Creature{

    public BlockCounterAttackCreature(CreatureStatistic aStats) {
        super(aStats);
    }

    @Override
    protected void counterAttack(Creature aDefender) {

    }

    public static final class Builder extends Creature.Builder{
        @Override
        protected Creature createInstance(CreatureStatistic aStats) {
            return new BlockCounterAttackCreature(aStats);
        }
    }
}
