package hw6.po;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hw6.enums.HeaderMenu;
import hw6.enums.Services;
import hw6.enums.User;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.title;
import static hw6.enums.HeaderMenu.SERVICE;

/**
 * Created by Ekaterina on 01.06.2018.
 */
public class HomePage {
    @FindBy(css = ".sub")
    private SelenideElement serviceLeftDropDown;

    @FindBy(css = "a[href='user-table.html']")
    private SelenideElement userTablePageButton;

    @FindBy(css = ".profile-photo")
    private SelenideElement userIcon;
    @FindBy(css = "#Name")
    private SelenideElement loginInput;

    @FindBy(css = "#Password")
    private SelenideElement passwordInput;

    @FindBy(css = ".form-horizontal button[type = 'submit']")
    private SelenideElement submitButton;

    @FindBy(css = ".dropdown-toggle")
    private SelenideElement serviceHeader;

    @FindBy(css = "a[href='different-elements.html']")
    private SelenideElement differentElementsPageButton;

    @FindBy(css = ".benefit-icon")
    private ElementsCollection icons;

    @FindBy(css = ".benefit-txt")
    private ElementsCollection textsBellow;
    @FindBy(css = ".main-content > [class*='main']")
    private ElementsCollection textsAbove;

    @FindBy(css = ".logout")
    private SelenideElement logOut;

    @FindBy(css = ".dropdown-menu")
    private SelenideElement serviceHeaderDropDown;

    @FindBy(css = ".fa-caret-down")
    private SelenideElement serviceLeft;

    public HomePage() {
        page(this);
    }

    @Step
    @Given("I am on Home Page")
    public void openHomePage() {
        Selenide.open("https://epam.github.io/JDI/" + HeaderMenu.HOME.URL);
    }

    @Step
    @Then("The title is correct")
    public void checkTitle() {
        Assert.assertEquals(Selenide.title().toUpperCase(), HeaderMenu.HOME.TITTLE);
    }

    @Step("Login")
    @Given("I am logged in as (.*)")
    public void login(String userName) {
        User user = User.getUserByName(userName);
        userIcon.click();
        if (isLoggedIn()) {
            logOut.click();
        }
        loginInput.sendKeys(user.login);
        passwordInput.sendKeys(user.password);
        submitButton.click();
    }

    @Step
    @Then("The user name is (.*)")
    public void checkUserName(String name) {
        userIcon.shouldHave(text(name));
    }

    @Step
    @Then("The interface on Home page, contains all needed elements") //4 - pictures, 4 texts under them, 2 text above
    public void checkAllElements() {
        icons.shouldHaveSize(4);
        textsBellow.shouldHaveSize(4);
        textsAbove.shouldHaveSize(2);
    }

    @Step
    @When("I click on Service subcategory in the (.*)")
    public void clickServiceHeader(String position) {
        if (position.equals("header")) {
            clickCell(serviceHeader);
        }
        if (position.equals("left")) {
            clickCell(serviceLeft);
        }
    }

    private void clickCell(SelenideElement pageButton) {
        pageButton.shouldBe(visible);
        pageButton.click();
    }


    @Step
    @Then("(.+) drop down contains options")
    public void checkTheOptions(String position) {
        SelenideElement dropDown = null;

        if (position.equals("Header")) {
            dropDown = serviceHeaderDropDown;
        }
        if (position.equals("Left")) {
            dropDown = serviceLeftDropDown;
        }
        // TODO NPE ?
        // TODO whats happen if dropDown == null ?
        if (dropDown != null && dropDown.is(visible)) {
            for (SelenideElement element : dropDown.$$("li")) {
                element.shouldBe(visible);
            }
            List<String> texts = Arrays.stream(Services.values()).map(service -> service.text).collect(Collectors.toList());
            dropDown.$$("li").shouldHave(texts(texts));
        } else {
            throw new IllegalArgumentException("Check the value in step definition");
        }
    }

    @Step()
    @Given("I open (.*) Page through the header menu")
    public void openPage(String pageName) {
        HeaderMenu cell = HeaderMenu.MAP.get(pageName.toUpperCase());
        switch (cell) {
            case SERVICE: {
                clickCell(serviceHeader);
                break;
            }
            case USER_TABLE: {
                openPage(SERVICE.NAME);
                clickCell(userTablePageButton);
                break;
            }
            case DIFFERENT_ELEMENTS: {
                openPage(SERVICE.NAME);
                clickCell(differentElementsPageButton);
                break;
            }
        }
    }

    private boolean isLoggedIn() {
        return !loginInput.isDisplayed();
    }
}
