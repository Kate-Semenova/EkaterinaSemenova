package hw4;

import hw4.enums.CheckBox;
import hw4.enums.DropDown;
import hw4.enums.Radio;
import hw4.pageobjects.DifferentElements;
import hw4.pageobjects.HomePage;
import org.testng.annotations.*;

import java.util.HashSet;
import java.util.Set;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.page;
import static hw4.enums.CheckBox.*;
import static hw4.enums.DropDown.*;
import static hw4.enums.Radio.SELEN;
import static hw4.enums.User.PITER_CHAILOVSKII;

/**
 * Created by Екатерина on 18.06.2018.
 */
public class DifferentElementsPageTest extends ServiceSuiteBase {
    private HomePage homePage;

    @DataProvider
    public Object[][] information() {

        return new Object[][]{
                {WATER, WIND},
                {SELEN},
                {YELLOW},
                {WATER, WIND}
        };
    }

    @BeforeClass(alwaysRun = true)
    public void login() {
        homePage = page(HomePage.class);
        //1 Open test site by URL
        homePage.open();

        //2 Assert Browser title
        homePage.checkTitle();

        //3 Perform login
        homePage.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

        //4 Open through the header menu Service -> Different Elements Page
        homePage.openService();
        homePage.openDifferentElementsPage();
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        //7 Close browser
        close();
    }

    @Test(dataProvider = "information")
    public void elementsTest(Object[] elements) throws InterruptedException {

        //5 Check interface on Different elements page, it contains all needed elements
        DifferentElements differentElementPage = page(DifferentElements.class);
        differentElementPage.shouldHasAllNeededElements();

        //6 Assert that there is Right Section
        differentElementPage.shouldHasRightSection();
        //7 Assert that there is Left Section
        differentElementPage.shouldHasLeftSection();

        //8 Select elements: checkBoxes, radio, dropdown, checkBoxes
        differentElementPage.select(elements);
        //9 Assert there is an individual log row
        // Thread.sleep(5000);
        differentElementPage.shouldHasCorrectLogRow(elements);
    }
}
