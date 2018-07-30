package hw4.pageobjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import hw4.enums.HeaderMenu;
import hw4.enums.User;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.visible;
import static hw4.enums.Pages.HOME_PAGE;

/**
 * Created by Ekaterina on 01.06.2018.
 */
public class HomePage {
    @FindBy(css = ".profile-photo")
    private SelenideElement userIcon;

    @FindBy(css = "#Name")
    private SelenideElement loginInput;

    @FindBy(css = "#Password")
    private SelenideElement passwordInput;

    @FindBy(css = ".form-horizontal button[type = 'submit']")
    private SelenideElement submitButton;

    @FindBy(css = "a[href='dates.html']")
    private SelenideElement datesPageButton;

    @FindBy(css = ".dropdown-toggle")
    private SelenideElement serviceDropDown;

    @FindBy(css = "a[href='different-elements.html']")
    public SelenideElement differentElementsPageButton;

    @FindBy(css = ".logout")
    public SelenideElement logOut;

    @Step("Open Home Page")
    public void openHomePage() {
        Selenide.open(HOME_PAGE.url);
    }

    @Step("Check the title")
    public void checkTitle() {
        Assert.assertEquals(Selenide.title(), HOME_PAGE.title);
    }

    @Step("Login")
    public void login(User user) {
        userIcon.click();
        loginInput.sendKeys(user.login);
        passwordInput.sendKeys(user.password);
        submitButton.click();
    }

    @Step("Open page")
    public void openPage(HeaderMenu cell) {
        switch (cell) {
            case SERVICE: {
                clickCell(serviceDropDown);
                break;
            }
            case DATES: {
                openPage(HeaderMenu.SERVICE);
                clickCell(datesPageButton);
                break;
            }
            case DIFFERENT_ELEMENTS: {
                openPage(HeaderMenu.SERVICE);
                clickCell(differentElementsPageButton);
                break;
            }
        }
    }

    private void clickCell(SelenideElement pageButton) {
        pageButton.shouldBe(visible);
        pageButton.click();
    }
}
