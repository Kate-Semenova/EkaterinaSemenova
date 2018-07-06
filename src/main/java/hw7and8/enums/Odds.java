package hw7and8.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ekaterina on 26.06.2018.
 */
public enum Odds {
    ONE("1"), THREE("3"), FIVE("5"), SEVEN("7");
    private static final Map<String, Odds> ODDS_MAP = new HashMap<String, Odds>();

    static {
        for (Odds odds : values()) {
            ODDS_MAP.put(odds.value, odds);
        }
    }

    public String value;

    Odds(String value) {
        this.value = value;
    }

    public static Odds getByValue(int value) {
        return ODDS_MAP.get(Integer.toString(value));
    }

    public static boolean hasOdd(String value) {
        switch (value) {
            case ("ONE"): {
                return true;
            }
            case ("THREE"): {
                return true;
            }
            case ("FIVE"): {
                return true;
            }
            case ("SEVEN"): {
                return true;
            }

            default: {
                return ODDS_MAP.containsKey(value);
            }
        }
    }
}
