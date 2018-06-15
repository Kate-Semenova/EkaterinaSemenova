package hw4;

import com.codeborne.selenide.Configuration;
import hw4.pageobjects.Dates;
import hw4.pageobjects.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.page;
import static hw4.enums.User.PITER_CHAILOVSKII;

/**
 * Created by Ekaterina on 01.06.2018.
 */
public class ServicesInterfaceTest {
    private HomePage homePage;

    @DataProvider(parallel = true)
    public Object[][] textInformation() {
    Object[][] objects = new Object[160][1];
    {
        for(int j = 0; j < 161; j++){
            objects[j][0] = 56 + j;
        }}
        return objects;
    }

    @BeforeClass
    public void beforeSuite() {
        Configuration.browser = "chrome";
        Configuration.screenshots = false;
        Configuration.timeout = 10000;
        Configuration.pollingInterval = 200;
        Configuration.collectionsPollingInterval = 350;
        Configuration.startMaximized = true;

            homePage = page(HomePage.class);
    }

    @Test //(dataProvider = "textInformation")
    public void loginTest() {
        //1 Open test site by URL
        homePage.open();

        //2 Assert Browser title
        homePage.checkTitle();

        //3 Perform login
        homePage.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

        //4 Open through the header menu Service -> Dates Page
        homePage.openService();
        homePage.openDatesPage();
        Dates datesPage = page(Dates.class);
        //5 Range sliders

        int from  = 0;
        int to = 100;
        datesPage.setHandles(from, to);

        //6 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogsValues(from, to);


        close();
    }

}
