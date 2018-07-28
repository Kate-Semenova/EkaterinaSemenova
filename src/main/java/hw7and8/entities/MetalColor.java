package hw7and8.entities;

import hw7and8.base.MetalColorsInterfaceTestsInit;
import hw7and8.utils.JSONReader;
import lombok.Getter;
import lombok.ToString;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import static com.epam.jdi.uitests.core.settings.JDISettings.logger;


/**
 * Created by Ekaterina on 27.06.2018.
 */
@ToString
@Getter
public class MetalColor {
    private int[] summary;
    private String[] elements;
    private String color;
    private String metals;
    private String[] vegetables;

    public final static MetalColor DEFAULT = new MetalColor("parametersForHW7.properties");
    public final static MetalColor[][] DEFAULT_FROM_JSON = JSONReader.getInstance().getDataFromJSON();

    public MetalColor(String file) {
        Properties properties = new Properties();
        logger.info("Read property " + file);
        try {
            properties.load(MetalColorsInterfaceTestsInit.class.getClassLoader().getResourceAsStream(file));
            logger.info("Initialising data from " + file);

            color = (properties.getProperty("color"));
            metals = (properties.getProperty("metal"));
            summary = new int[2];
            summary[0] = Integer.parseInt(properties.getProperty("odd"));
            summary[1] = Integer.parseInt(properties.getProperty("even"));
            String elementList = properties.getProperty("elements");

            elements = new String[elementList.split(", ").length];
            int i = 0;
            for (String elementName : elementList.split(", ")) {
                elements[i] = elementName;
                i++;
            }
            String vegetablesList = properties.getProperty("salad");
            vegetables = new String[vegetablesList.split(", ").length];
            i = 0;
            for (String vegetableName : vegetablesList.split(", ")) {
                vegetables[i] = vegetableName;
                i++;
            }
        } catch (IOException e) {
            logger.info("Cant initialise data from " + file);
        }
    }

    public int sum() {
        if (summary.length == 2) {
            return Arrays.stream(summary).sum();
        } else {
            return 3;
        }
    }


}
