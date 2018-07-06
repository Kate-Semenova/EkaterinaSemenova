package hw7and81.enums;

/**
 * Created by Ekaterina on 26.06.2018.
 */
public enum Metals {
    Gold, Silver, Bronze, Selen;

    public static boolean hasMetal(String value) {
        switch (value) {
            case ("Gold"): {
                return true;
            }
            case ("Silver"): {
                return true;
            }
            case ("Bronze"): {
                return true;
            }
            case ("Selen"): {
                return true;
            }
            default: {
                return false;
            }
        }
    }
}
