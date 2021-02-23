package pl.sdk.special_fields;

public class FieldsFactory {

    private static final String EXCEPTION_MESSAGE = "This field's name does not exist";

    public static Field create( String name ){
        switch (name) {
            case "Normal":
                return new Field(name, true, true, false, false, 0, 1);
            case "Lava":
                return new Field(name, true, true, false, true, 5, 0.5); //damage per round, +fire magic upgrade
            case "Stone":
                return new Field(name, false, true, false, false, 0, 0);
            case "Water":
                return new Field(name, true, true, false, false, 0, 0.6); //move range continue for 2 rounds, +water magic upgrade
            case "Poison":
                return new Field(name, true, true, true, true, 2, 0.8); //damage and range per round, continue for 3 rounds
            case "Mountain":
                return new Field(name, false, true, true, false, 0, 0);
            case "ThunderStorm":
                return new Field(name, true, false, true, true, 1, 0);
            default:
                throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }
}