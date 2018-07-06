package hw7r;


import hw7and81.base.MetalColorsInterfaceTestsInit;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static hw7and81.enums.Users.Piter_Chailovskii;
import static hw7and81.site.JDIExampleSite.*;

public class MetalsColorsInterfaceTest extends MetalColorsInterfaceTestsInit {

    @Test
    public void setValuesTest() {
        //Open Home Page
        homePage.open();
        //Login as user PITER CHAILOVSKII
        login(Piter_Chailovskii.getUser());
        homePage.checkOpened();

        //Open Metals & Colors page by Header menu
        openMetalsAndColors();
        metalsColorsPage.checkOpened();

        //Fill form Metals & Colors :
        initialiseData();

        metalsColorsPage.summary.selectOdd(ODD);
        metalsColorsPage.summary.selectEven(EVEN);

        metalsColorsPage.selectElements(ELEMENTS);

        metalsColorsPage.selectColor(COLOR);

        metalsColorsPage.selectMetal(METAL);

        metalsColorsPage.selectVegetables(VEGETABLES);

        //Submit form Metals & Colors
        metalsColorsPage.submitChanges();

        //Result section contains certain data
        metalsColorsPage.result.checkText(ODD, EVEN, ELEMENTS, COLOR, METAL, VEGETABLES);
    }

    private void initialiseData() {
        properties = new Properties();
        logger.info("Read properties from " + PROPERTY);
        try {
            logger.info("Read property " + PROPERTY);
            properties.load(MetalColorsInterfaceTestsInit.class.getClassLoader().getResourceAsStream(PROPERTY));

            logger.info("Initialising data from " + PROPERTY);

            COLOR = (properties.getProperty("color"));
            METAL = (properties.getProperty("metal"));
            ODD = Integer.parseInt(properties.getProperty("odd"));
            EVEN = Integer.parseInt(properties.getProperty("even"));
            String elementList = properties.getProperty("elements");
            for (String elementName : elementList.split(", ")) {
                ELEMENTS.add((elementName));
            }
            String vegetablesList = properties.getProperty("salad");
            for (String vegetableName : vegetablesList.split(", ")) {
                VEGETABLES.add((vegetableName));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
