package hw7and81.site;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import hw7and81.entities.User;
import hw7and81.enums.HeaderMenu;
import hw7and81.site.forms.LoginForm;
import hw7and81.site.pages.*;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static hw7and81.enums.HeaderMenu.Metals_n_Colors;

public class JDIExampleSite extends WebSite {

    @JPage(url = "/index.html", title = "Home Page")
    public static HomePage homePage;
    @JPage(url = "/metals-colors.html", title = "Metal and Colors")
    public static MetalsColorsPage metalsColorsPage;

    @FindBy(css = "#login-form")
    public static LoginForm loginForm;
    @FindBy(css = ".logout")
    public static Button logOut;
    @FindBy(css = ".nav")
    public static Menu<HeaderMenu> headerMenu;

    @FindBy(css = ".profile-photo")
    public static Label profilePhoto;


    @Step
    public static void login(User user) {
        profilePhoto.click();
        if (isNotLoggedIn()) {
            logOut.click();
            loginForm.loginAs(user);
        } else {
            loginForm.loginAs(user);
        }
    }

    @Step
    public static void openMetalsAndColors() {
        headerMenu.select(Metals_n_Colors);
    }

    public static boolean isNotLoggedIn() {
       return loginForm.isHidden();
    }


}
