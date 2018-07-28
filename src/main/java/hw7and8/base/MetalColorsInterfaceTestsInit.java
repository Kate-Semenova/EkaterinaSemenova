package hw7and8.base;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import hw7and8.site.JDISite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

import static com.epam.jdi.uitests.core.settings.JDISettings.logger;

// TODO This is not an interface obviously
// TODO you should not store data here
public class MetalColorsInterfaceTestsInit extends TestNGBase {

    @BeforeSuite(alwaysRun = true)
    public static void setUp() throws IOException {
        WebSite.init(JDISite.class);
        logger.info("Run Tests");
    }
}
