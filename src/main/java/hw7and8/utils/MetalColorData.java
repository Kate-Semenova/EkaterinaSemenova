package hw7and8.utils;

import hw7and8.base.MetalColorsInterfaceTestsInit;
import hw7and8.entities.MetalColor;

import java.io.IOException;
import java.util.Properties;

import static com.epam.jdi.uitests.core.settings.JDISettings.logger;

/**
 * Created by Ekaterina on 30.07.2018.
 */
public class MetalColorData {
    public final static MetalColor DEFAULT = PropertyReader.getData("parametersForHW7.properties");
    // TODO No! Why don't you create especial file for store&loading data ? This should not be here...
    public final static MetalColor[][] DEFAULT_FROM_JSON = JSONReader.getInstance().getDataFromJSON();
}
