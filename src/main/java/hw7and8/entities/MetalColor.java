package hw7and8.entities;

import hw7and8.base.MetalColorsInterfaceTestsInit;
import hw7and8.utils.JSONReader;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import static com.epam.jdi.uitests.core.settings.JDISettings.logger;


/**
 * Created by Ekaterina on 27.06.2018.
 */
@ToString
@Getter
@Setter
public class MetalColor {
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

    public List<String> listOfData() {
        List<String> strings = new ArrayList<>();
        strings.add(Integer.toString(sum()));
        strings.add(color);
        strings.add(metals);
        strings.add(Arrays.toString(vegetables).substring(1, Arrays.toString(vegetables).length() - 1));
        strings.add(Arrays.toString(elements).substring(1, Arrays.toString(elements).length() - 1));

        return strings;
    }

    public enum ListOfLog {
        SUMMARY("Summary: "),
        COLOR("Color: "),
        METAL("Metal: "),
        VEGETABLES("Vegetables: "),
        ELEMENTS("Elements: ");

        public final String logText;

        ListOfLog(String logText) {
            this.logText = logText;
        }
    }
}
