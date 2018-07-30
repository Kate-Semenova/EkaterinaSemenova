package hw3.po;

import hw3.enums.BenefitTexts;
import hw3.enums.CentralTexts;
import hw7and8.enums.HeaderMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

import static hw3.enums.Pages.HOME_PAGE;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Ekaterina on 01.06.2018.
 */
public class HomePage {
    private WebDriver driver;
    // TODO what bout enums ?
    private final String title = HOME_PAGE.title;
    @FindBy(css = ".profile-photo")
    private WebElement userIcon;
    @FindBy(css = "#Name")
    private WebElement loginInput;

    @FindBy(css = "#Password")
    private WebElement passwordInput;

    @FindBy(css = ".form-horizontal button[type = 'submit']")
    private WebElement submitButton;

    @FindBy(css = ".footer-content")
    private WebElement footer;

    @FindBy(css = ".nav > li")
    private List<WebElement> navigateBarElements;

    @FindBy(css = ".icons-benefit")
    private List<WebElement> images;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> texts;

    @FindBy(css = "[name = 'navigation-sidebar']")
    private WebElement sideBar;

    @FindBy(css = ".text-center")
    private List<WebElement> centerTexts;

    @FindBy(xpath = "//*[@class = 'main-content']//a[text() = 'JDI Github']")
    private WebElement jdiGithub;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to("https://epam.github.io/JDI/index.html");
    }

    public void logIn(String login, String password) {
        userIcon.click();
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        submitButton.click();
    }

    public void checkUserName(String text) {
        assertEquals(userIcon.getText(), text);
    }

    public void checkHomePageTitle() {
        assertEquals(driver.getTitle(), title);
    }

    public void checkFooterIsDisplayed() {
        assertTrue(footer.isDisplayed());
    }

    public void checkNavigationBar() {
        // TODO you have to create something for store the list of page's name
        // TODO it will be better with cycle...
        //DONE
        assertEquals(navigateBarElements.size(), 4);
        for (int i = 0; i < navigateBarElements.size(); i++) {
            assertEquals(navigateBarElements.get(i).getText(), HeaderMenu.values()[i].title);
        }
    }

    public void checkImagesOnIndexPage() {
        Assert.assertEquals(images.size(), 4);
        for (WebElement image : images) {
            assertTrue(image.isDisplayed());
        }
    }

    public void checkTexts() {
        Assert.assertEquals(texts.size(), 4);
        for (WebElement text : texts) {
            assertTrue(text.isDisplayed());
        }
        for (int i = 0; i < texts.size(); i++) {
            assertEquals(texts.get(i).getText(), BenefitTexts.values()[i].text);
        }
        // TODO same, 75 str
        //DONE
    }

    public void checkSideBar() {
        assertTrue(sideBar.isDisplayed());
    }


    public void checkTextsOnMainHeaderAreDisplayed() {
        assertEquals(centerTexts.size(), 3);
        for (WebElement text : centerTexts) {
            assertTrue(text.isDisplayed());
        }
    }

    public void checkTextsOnMainHeader() {
        // TODO same, 75 str
        //DONe
        for (int i = 0; i < centerTexts.size(); i++) {
            assertEquals(centerTexts.get(i).getText(), CentralTexts.values()[i].text);
        }
    }

    public void checkJDILink() {
        // TODO you should not get elements by indexes, that's really bad approach
        // TODO @FindBy required...
        //DONE
        assertEquals(jdiGithub.getAttribute("href"), "https://github.com/epam/JDI");
    }

}
