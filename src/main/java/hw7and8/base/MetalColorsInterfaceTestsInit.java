package hw7and8.base;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import hw7and8.site.JDIExampleSite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.epam.jdi.uitests.core.settings.JDISettings.logger;

public class MetalColorsInterfaceTestsInit extends TestNGBase {

    public final static String PROPERTY = "parametersForHW7.properties";

    public static Properties properties;
    public static String COLOR;
    public static String METAL;
    public static int ODD;
    public static int EVEN;

    public static List<String> ELEMENTS = new ArrayList<>();
    public static List<String> VEGETABLES = new ArrayList<>();


    @BeforeSuite(alwaysRun = true)
    public static void setUp() throws IOException {
        WebSite.init(JDIExampleSite.class);
        logger.info("Run Tests");

    }


}
