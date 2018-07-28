package hw7;


import hw7and8.base.MetalColorsInterfaceTestsInit;
import hw7and8.entities.MetalColor;
import hw7and8.entities.User;
import org.testng.annotations.Test;

import static hw7and8.enums.HeaderMenu.METALS_N_COLORS;
import static hw7and8.site.JDISite.homePage;
import static hw7and8.site.JDISite.metalsColorsPage;

public class MetalsColorsInterfaceTest extends MetalColorsInterfaceTestsInit {
    @Test
    public void setValuesTest() {
        //Open Home Page
        homePage.open();

        //Login as user PITER CHAILOVSKII
        homePage.login(User.PITER_CHALKOVSKII);
        homePage.checkOpened();

        //Open Metals & Colors page by Header menu
        homePage.header.headerMenu.select(METALS_N_COLORS);
        metalsColorsPage.checkOpened();

        //Fill form Metals & Colors :
        // TODO you should use Entity Driving Testing approach !!
        // DONE ***okey, somehow never thought of metalcolor as a form.
        metalsColorsPage.fillForm(MetalColor.DEFAULT);

        //Submit form Metals & Colors
        metalsColorsPage.submitChanges();

        //Result section contains certain data
        metalsColorsPage.result.checkTextInLog(MetalColor.DEFAULT);
        // !TODO
    }
}
