package pl.sdk;

public class ShootingCreature extends Creature {

    ShootingCreature(){
        super();
    }

    ShootingCreature(CreatureStatistic aStats) {
        super(aStats);
    }

    @Override
    double getAttackRange() {
        return Double.MAX_VALUE;
    }

    @Override
    protected void counterAttack(Creature aDefender) {}

    public static final class Builder extends Creature.Builder {
        @Override
        protected Creature createInstance(CreatureStatistic aStats) {
            return new ShootingCreature(aStats);
        }
    }
}
