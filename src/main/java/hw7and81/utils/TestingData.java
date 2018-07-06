package hw7and81.utils;

import lombok.ToString;

import java.util.Arrays;

/**
 * Created by Ekaterina on 27.06.2018.
 */
@ToString
public class TestingData {
    public int[] getSummary() {
        return summary;
    }

    private int[] summary;
    private String[] elements;
    private String color;
    private String metals;
    private String[] vegetables;

    public int sum() {
        if (summary.length == 2) {
            return Arrays.stream(summary).sum();
        } else {
            return 3;
        }
    }

    public String getColor() {
        if (color.equals("") || color == null) {
            return "Colors";
        } else {
            return color;
        }
    }

    public String getMetals() {
        if (metals.equals("") || metals == null) {
            return "Metals";
        } else {
            return metals;
        }
    }

    public String[] getElements() {
        if (!Arrays.equals(elements, new String[0]) && elements != null) {
            return elements;
        } else {
            return new String[]{"Elements"};

        }
    }

    public String[] getVegetables() {
        if (Arrays.equals(vegetables, new String[0]) || vegetables == null) {
            return new String[]{"Vegetables"};
        } else {
            return vegetables;
        }
    }

}
