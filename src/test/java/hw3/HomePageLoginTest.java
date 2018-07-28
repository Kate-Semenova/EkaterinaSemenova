package hw3;

import hw2.ex3.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * Created by Ekaterina on 01.06.2018.
 */
public class HomePageLoginTest extends TestBase {
    private HomePage homePage;

    // TODO dou you have a chance to read IDEA warning ?
    private ChromeOptions options;
    private WebDriver driver;

    // TODO you should not ini WebDriver here...
    @BeforeMethod
    public void setUpMethod() {
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("download.default_directory", "target");

        options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        driver = new ChromeDriver();
        homePage = PageFactory.initElements(driver, HomePage.class);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void close() {
        driver.close();
    }

    @Test
    // TODO thats not really gooad approach to pass vars by xml parameters, but OKAY...
    @Parameters({"login", "password", "name"})
    public void shouldPerformLoggingInCorrectly(String login, String password, String name) {

        // TODO this is completely prohibited to pass driver in PO method !!
        // TODO you can just create appropriate constructor and store link of the driver there.
        //2 Open test site by URL
        homePage.open(driver);

        //3 Assert Browser title
        homePage.checkHomePageTitle(driver);

        //4 Perform login
        homePage.logIn(login, password);

        //5 Assert User name in the left-top side of screen that user is logged in
        homePage.checkUserName(name);

        //6 Assert Browser title
        homePage.checkHomePageTitle(driver);

        //7 Assert that there are 4 items on the header section are displayed and they have proper texts
        homePage.checkNavigationBar();

        //8 Assert that there are 4 images on the Index Page and they are displayed
        homePage.checkImagesOnIndexPage();

        //9 Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePage.checkTexts();

        //10 Assert a text of the main header
        homePage.checkTextsOnMainHeaderAreDisplayed();

        //11 Assert a text of the sub header
        homePage.checkTextsOnMainHeader();

        //12 Assert that JDI GITHUB is a link and has a proper URL
        homePage.checkJDILink();

        //13 Assert that there is Left Section
        homePage.checkSideBar();

        //14 Assert that there is Footer.
        homePage.checkFooterIsDisplayed();
    }

}
