package hw4.pageobjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.visible;

/**
 * Created by Екатерина on 01.06.2018.
 */
public class HomePage {
    private final String url = "https://epam.github.io/JDI/";
    @FindBy(css = ".profile-photo")
    private SelenideElement userIcon;

    @FindBy(css = "#Name")
    private SelenideElement loginInput;

    @FindBy(css = "#Password")
    private SelenideElement passwordInput;

    @FindBy(css = ".form-horizontal button[type = 'submit']")
    private SelenideElement submitButton;

    public void open(){
        Selenide.open(url);
    }
    public void checkTitle(){
        Assert.assertEquals(Selenide.title(), "Home Page");
    }
    public void login(String login, String password){
        userIcon.click();
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        submitButton.click();
    }
    @FindBy(css = ".dropdown-toggle")
    private SelenideElement serviceDropDown;
    public void openService() {
        serviceDropDown.shouldBe(visible);
        serviceDropDown.click();
    }

    @FindBy(css = "a[href='dates.html']") //TODO need to be normal
    private SelenideElement datesPageButton;

    public void openDatesPage() {
        datesPageButton.shouldBe(visible);
        datesPageButton.click();
    }
}
