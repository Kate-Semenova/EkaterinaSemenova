package hw7and8.site.pages;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import hw7and8.entities.User;
import hw7and8.site.sections.Header;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Ekaterina on 27.07.2018.
 */
public class  Page extends WebPage {
    @FindBy(css = "header")
    public Header header;

    @Step
    public void login(User user) {
        header.profilePhoto.click();
        if (isNotLoggedIn()) {
            header.logOut.click();
        }
        header.loginForm.loginAs(user);
    }

    public boolean isNotLoggedIn() {
        return header.loginForm.isHidden();
    }
}
