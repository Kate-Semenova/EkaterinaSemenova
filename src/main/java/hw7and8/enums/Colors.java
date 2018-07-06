package hw7and8.enums;

/**
 * Created by Ekaterina on 26.06.2018.
 */
public enum Colors {
    Red,
    Green,
    Blue,
    Yellow;

    public static boolean hasColor(String value) {
        switch (value) {
            case ("Red"): {
                return true;
            }
            case ("Green"): {
                return true;
            }
            case ("Blue"): {
                return true;
            }
            case ("Yellow"): {
                return true;
            }
            default: {
                return false;
            }
        }
    }
}
