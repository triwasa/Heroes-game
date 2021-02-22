
package pl.sdk.creatures;

public class FractionFactory {

    public static final String CASTLE = "CASTLE";
    public static final String TOWER = "TOWER";
    public static final String INFERNO = "INFERNO";
    public static final String FORTRESS = "FORTRESS";
    public static final String RAMPART = "RAMPART";
    public static final String DUNGEON = "DUNGEON";
    public static final String STRONGHOLD = "STRONGHOLD";
    public static final String NECROPOLIS = "NECROPOLIS";
    public static final String NEUTRAL = "NEUTRAL";
    public static final String WARMACHINE = "WARMACHINES";
    private static final String EXCEPTION = "Fraction does not exist";

    public static AbstractFactory getFraction(String fraction) {
        switch (fraction) {
            case CASTLE:
                return new CastleFactory();
            case TOWER:
                return new TowerFactory();
            case INFERNO:
                return new InfernoFactory();
            case FORTRESS:
                return new FortressFactory();
            case RAMPART:
                return new RampartFactory();
            case DUNGEON:
                return new DungeonFactory();
            case STRONGHOLD:
                return new StrongholdFactory();
            case NECROPOLIS:
                return new NecropolisFactory();
            case NEUTRAL:
                return new NeutralFactory();
            default:
                throw new IllegalArgumentException(EXCEPTION);
        }
    }
}

