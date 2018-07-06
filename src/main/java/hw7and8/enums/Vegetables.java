package hw7and8.enums;

/**
 * Created by Ekaterina on 26.06.2018.
 */
public enum Vegetables {
    Cucumber, Tomato, Vegetables, Onion;

    public static boolean hasVegetable(String value) {
        switch (value) {
            case ("Cucumber"): {
                return true;
            }
            case ("Tomato"): {
                return true;
            }
            case ("Vegetables"): {
                return true;
            }
            case ("Onion"): {
                return true;
            }
            default: {
                return false;
            }
        }
    }
}
