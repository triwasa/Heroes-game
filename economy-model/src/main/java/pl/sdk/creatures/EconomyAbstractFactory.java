package pl.sdk.creatures;

public abstract class EconomyAbstractFactory {

    public abstract EconomyCreature create(boolean aIsUpgraded, int aTier, int aAmount);

    public static final String CASTLE = "CASTLE";
    public static final String TOWER = "TOWER";
    public static final String INFERNO = "INFERNO";
    public static final String FORTRESS = "FORTRESS";
    public static final String RAMPART = "RAMPART";
    public static final String DUNGEON = "DUNGEON";
    public static final String STRONGHOLD = "STRONGHOLD";
    public static final String NECROPOLIS = "NECROPOLIS";
    public static final String NEUTRAL = "NEUTRAL";
    public static final String WARMACHINE = "WARMACHINE";
    private static final String EXCEPTION = "Fraction does not exist";

    public static EconomyAbstractFactory getFraction(String fraction) {
        switch (fraction) {
            case CASTLE:
                return new EconomyCastleFactory();
            case TOWER:
                return new EconomyTowerFactory();
            case INFERNO:
                return new EconomyInfernoFactory();
            case FORTRESS:
                return new EconomyFortressFactory();
            case RAMPART:
                return new EconomyRampartFactory();
            case DUNGEON:
                return new EconomyDungeonFactory();
            case STRONGHOLD:
                return new EconomyStrongholdFactory();
            case NECROPOLIS:
                return new EconomyNecropolisFactory();
            case NEUTRAL:
                return new EconomyNeutralFactory();
            case WARMACHINE:
                return new EconomyWarmachineFactory();
            default:
                throw new IllegalArgumentException(EXCEPTION);
        }
    }
}
