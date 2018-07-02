package hw7and8.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ekaterina on 26.06.2018.
 */
public enum Evens {
    TWO("2"), FOUR("4"), SIX("6"), EIGHT("8");
    private static final Map<String, Evens> EVENS_MAP = new HashMap<String, Evens>();

    static {
        for (Evens evens : values()) {
            EVENS_MAP.put(evens.value, evens);
        }
    }

    public String value;

    Evens(String value) {
        this.value = value;
    }

    public static Evens getByValue(int value) {
        return EVENS_MAP.get(Integer.toString(value));
    }

    public static boolean hasEven(String value) {
        return EVENS_MAP.containsKey(value);
    }
}
