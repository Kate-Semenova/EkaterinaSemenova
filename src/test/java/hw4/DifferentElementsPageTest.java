package hw4;

import hw4.pageobjects.DifferentElements;
import hw4.pageobjects.HomePage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listeners.FailesTestAttachmentListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.page;
import static hw4.enums.CheckBox.WATER;
import static hw4.enums.CheckBox.WIND;
import static hw4.enums.DropDown.YELLOW;
import static hw4.enums.Radio.SELEN;
import static hw4.enums.User.PITER_CHAILOVSKII;

/**
 * Created by Ekaterina on 18.06.2018.
 */
@Feature("Home page, Different Element Page")
@Story("Login and check interface")
@Listeners({FailesTestAttachmentListener.class})
public class DifferentElementsPageTest extends ServiceSuiteBase {
    private HomePage homePage;
    private DifferentElements differentElementPage;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        homePage = page(HomePage.class);
        differentElementPage = page(DifferentElements.class);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        close();
        //OPERATIONS WITH BROWSERS ARE IN ANNOTATIONS
    }

    @Test
    public void elementsTest() {
        //1 Open test site by URL
        homePage.openHomePage();

        //2 Assert Browser title
        homePage.checkTitle();

        //3 Perform login
        // TODO why don't you pass just a PITER_CHAILOVSKII to this method ??
        homePage.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

        //4 Open through the header menu Service -> Different Elements Page
        // TODO this will be better with parameter.
        // TODO you have to create one single method that allow us to opne any kind of pages...
        homePage.openService();
        homePage.openDifferentElementsPage();

        //5 Check interface on Different elements page, it contains all needed elements
        differentElementPage.shouldHasAllNeededElements();

        //6 Assert that there is Right Section
        differentElementPage.shouldHasRightSection();

        //7 Assert that there is Left Section
        differentElementPage.shouldHasLeftSection();


        //8. Select checkboxes
        differentElementPage.selectCheckBoxes(WATER, WIND);
        //9 Assert there is an individual log row
        differentElementPage.shouldHasCorrectLogRowForCheckBoxes(WATER, WIND);

        //10 Select radio
        differentElementPage.selectRadio(SELEN);
        //11 Assert there is an individual log row
        differentElementPage.shouldHasCorrectLogRowForRadio(SELEN);

        //12 Select dropdown
        differentElementPage.selectDropDown(YELLOW);
        //13 Assert there is an individual log row
        differentElementPage.shouldHasCorrectLogRowForDropDown(YELLOW);

        //14 Select checkBoxes
        differentElementPage.selectCheckBoxes(WATER, WIND);
        //15 Assert there is an individual log row
        differentElementPage.shouldHasCorrectLogRowForCheckBoxes(WATER, WIND);
    }
}
