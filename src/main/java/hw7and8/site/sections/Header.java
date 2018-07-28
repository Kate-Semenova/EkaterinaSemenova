package hw7and8.site.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import hw7and8.enums.HeaderMenu;
import hw7and8.site.forms.LoginForm;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Ekaterina on 28.07.2018.
 */
public class Header extends Section {
    @FindBy(css = "#login-form")
    public LoginForm loginForm;
    @FindBy(css = ".logout")
    public Button logOut;
    @FindBy(css = ".nav")
    public Menu<HeaderMenu> headerMenu;

    @FindBy(css = ".profile-photo")
    public Label profilePhoto;
}
