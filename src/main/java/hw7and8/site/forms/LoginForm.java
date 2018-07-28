package hw7and8.site.forms;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;
import hw7and8.entities.User;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends Form<User> {
    @FindBy(id = "Name")
    public TextField name;
    @FindBy(id = "Password")
    public TextField password;
    @Css(".btn-login")
    public Button enter;
}
