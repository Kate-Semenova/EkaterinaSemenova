package hw7and8.utils;

import hw7and8.base.MetalColorsInterfaceTestsInit;
import hw7and8.entities.MetalColor;

import java.io.IOException;
import java.util.Properties;

import static com.epam.jdi.uitests.core.settings.JDISettings.logger;

/**
 * Created by Ekaterina on 27.07.2018.
 */
public class PropertyReader {
    private MetalColor metalColor;

    private PropertyReader(String fileName) {
        Properties properties = new Properties();
        logger.info("Read property " + fileName);
        try {
            properties.load(MetalColorsInterfaceTestsInit.class.getClassLoader().getResourceAsStream(fileName));
            logger.info("Initialising data from " + fileName);
            MetalColor metalColor = new MetalColor();
            metalColor.setColor(properties.getProperty("color"));
            metalColor.setMetals(properties.getProperty("metal"));
            int[] summary = new int[2];
            summary[0] = Integer.parseInt(properties.getProperty("odd"));
            summary[1] = Integer.parseInt(properties.getProperty("even"));
            metalColor.setSummary(summary);
            String elementList = properties.getProperty("elements");
            String[] elements = new String[elementList.split(", ").length];
            int i = 0;
            for (String elementName : elementList.split(", ")) {
                elements[i] = elementName;
                i++;
            }
            metalColor.setElements(elements);
            String vegetablesList = properties.getProperty("salad");
            String[] vegetables = new String[vegetablesList.split(", ").length];
            i = 0;
            for (String vegetableName : vegetablesList.split(", ")) {
                vegetables[i] = vegetableName;
                i++;
            }
            metalColor.setVegetables(vegetables);
            this.metalColor = metalColor;
        } catch (IOException e) {
            logger.info("Cant initialise data from " + fileName);
        }
    }
    public static MetalColor getData(String fileName){
        return new PropertyReader(fileName).metalColor;
    }
}
