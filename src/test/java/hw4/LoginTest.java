package hw4;

import hw4.pageobjects.HomePage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static hw4.enums.User.PITER_CHAILOVSKII;

/**
 * Created by Ekaterina on 15.06.2018.
 */
public class LoginTest extends SuiteBase{
    private HomePage homePage;

    @Test
    public void loginTest() {
        homePage = page(HomePage.class);
        //1 Open test site by URL
        homePage.open();

        //2 Assert Browser title
        homePage.checkTitle();

        //3 Perform login
        homePage.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

        //4 Open through the header menu Service -> Dates Page
        homePage.openService();
        homePage.openDatesPage();
    }
}
