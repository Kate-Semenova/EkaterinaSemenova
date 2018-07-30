package hw8;

import hw7and8.base.MetalColorsInterfaceTestsInit;
import hw7and8.entities.MetalColor;
import hw7and8.entities.User;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static hw7and8.enums.HeaderMenu.METALS_N_COLORS;
import static hw7and8.site.JDISite.homePage;
import static hw7and8.site.JDISite.metalsColorsPage;

/**
 * Created by Ekaterina on 27.06.2018.
 */

public class MetalsColorsPageInterfaceWithDataTest extends MetalColorsInterfaceTestsInit {

    @DataProvider
    // TODO FNFE really ??
    public Object[][] getData() throws FileNotFoundException {
        return MetalColor.DEFAULT_FROM_JSON;
    }

    @Test(dataProvider = "getData")
    public void loginTest(MetalColor data) {

        //Open Home Page
        homePage.open();
        //Login as user PITER CHAILOVSKII
        homePage.login(User.PITER_CHALKOVSKII);
        homePage.checkOpened();

        //Open Metals & Colors page by Header menu
        // TODO you should create a method that can be used for opening any kind of page
        // TODO take  a look on class work
        homePage.header.headerMenu.select(METALS_N_COLORS);
        metalsColorsPage.checkOpened();

        //Fill form Metals & Colors :
        metalsColorsPage.fillForm(data);

        //Submit form Metals & Colors
        metalsColorsPage.submitChanges();

        //Result section contains certain data
        metalsColorsPage.result.checkTextInLog(data);
    }

}
