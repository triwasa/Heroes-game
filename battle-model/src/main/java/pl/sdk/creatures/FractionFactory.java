package pl.sdk.creatures;

public class FractionFactory {

    public static final String CASTLE = "Castle";
    public static final String TOWER = "Tower";
    public static final String INFERNO = "Inferno";
    public static final String FORTRESS = "Fortress";
    public static final String RAMPART = "Rampart";
    public static final String DUNGEON = "Dungeon";
    public static final String STRONGHOLD = "Stronghold";
    public static final String NECROPOLIS = "Nectropolis";
    public static final String NEUTRAL = "Neutral";
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
