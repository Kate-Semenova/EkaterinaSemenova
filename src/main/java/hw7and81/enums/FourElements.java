package hw7and81.enums;

/**
 * Created by Ekaterina on 26.06.2018.
 */
public enum FourElements {
    Water, Earth, Wind, Fire;

    public static boolean hasElement(String value) {
        switch (value) {
            case ("Water"): {
                return true;
            }
            case ("Earth"): {
                return true;
            }
            case ("Fire"): {
                return true;
            }
            case ("Wind"): {
                return true;
            }
            default: {
                return false;
            }
        }
    }
}
