package hw8r;

import hw7and81.base.MetalColorsInterfaceTestsInit;
import hw7and81.utils.JSONReader;
import hw7and81.utils.TestingData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.stream.Collectors;

import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static hw7and81.enums.Users.Piter_Chailovskii;
import static hw7and81.site.JDIExampleSite.*;

/**
 * Created by Ekaterina on 27.06.2018.
 */
public class MetalsColorsPageInterfaceWithDataTest extends MetalColorsInterfaceTestsInit {

    @Test(dataProvider = "getData")
    public void testMethod(TestingData data) throws FileNotFoundException {
        System.out.println(data);

    }

    @DataProvider
    public Object[][] getData() throws FileNotFoundException {
        JSONReader jsonReader = JSONReader.getInstance();
        return jsonReader.getDataFromJSON();
    }

    @Test(dataProvider = "getData")
    public void loginTest(TestingData data) {

        //Open Home Page
        homePage.open();
        //Login as user PITER CHAILOVSKII
        login(Piter_Chailovskii.getUser());
        homePage.checkOpened();

        //Open Metals & Colors page by Header menu
        openMetalsAndColors();
        metalsColorsPage.checkOpened();

        //Fill form Metals & Colors :
        initialiseValues(data);

        metalsColorsPage.summary.selectOdd(ODD);

        metalsColorsPage.summary.selectEven(EVEN);


        metalsColorsPage.selectElements(ELEMENTS);


        metalsColorsPage.selectColor(COLOR);

        metalsColorsPage.selectMetal(METAL);

        metalsColorsPage.selectVegetables(VEGETABLES);

        //Submit form Metals & Colors
        metalsColorsPage.submitChanges();

        //Result section contains certain data
        metalsColorsPage.result.checkTextInLog(data);


    }

    private void initialiseValues(TestingData data) {
        logger.info("Initialising data from " + JSONReader.FILE_NAME);

        COLOR = (data.getColor());
        METAL = (data.getMetals());
        if(data.getSummary().length == 0){
            ODD = 0;
            EVEN = 0;
        } else {
            ODD = (data.getSummary()[0]);
            EVEN = (data.getSummary()[1]);
        }

        ELEMENTS = Arrays.stream(data.getElements()).collect(Collectors.toList());
        VEGETABLES = Arrays.stream(data.getVegetables()).collect(Collectors.toList());

    }
}
