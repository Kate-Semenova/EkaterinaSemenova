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
    private final String URL = "https://epam.github.io/JDI/";
    @FindBy(css = ".profile-photo")
    private SelenideElement userIcon;

    @FindBy(css = "#Name")
    private SelenideElement loginInput;

    @FindBy(css = "#Password")
    private SelenideElement passwordInput;

    @FindBy(css = ".form-horizontal button[type = 'submit']")
    private SelenideElement submitButton;

    @FindBy(css = "a[href='dates.html']") //TODO need to be normal
    private SelenideElement datesPageButton;

    @FindBy(css = ".dropdown-toggle")
    private SelenideElement serviceDropDown;

    @FindBy(css = "a[href='different-elements.html']")
    SelenideElement differentElementsPageButton;

    public void open() {
        Selenide.open(URL);
    }

    public void checkTitle() {
        Assert.assertEquals(Selenide.title(), "Home Page");
    }

    public void login(String login, String password) {
        userIcon.click();
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        submitButton.click();
    }

    public void openService() {
        serviceDropDown.shouldBe(visible);
        serviceDropDown.click();
    }

    public void openDatesPage() {
        openPage(datesPageButton);
    }

    public void openDifferentElementsPage() {
        openPage(differentElementsPageButton);
    }

    private void openPage(SelenideElement pageButton){
        pageButton.shouldBe(visible);
        pageButton.click();
    }
}
