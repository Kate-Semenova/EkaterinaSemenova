package hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;

import static org.testng.Assert.*;

/**
 * Created by Екатерина on 23.05.2018.
 */
public class HomePageTest {
    @Test
    public void loginTest() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", "target");

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        WebDriver driver = new ChromeDriver();
        WebDriver.Window window = driver.manage().window();
        window.maximize();

        //2 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/");


        //3 Assert Browser title
        checkTitle(driver, "Home Page");

        //4 Perform login
        WebElement userIcon = driver.findElement(By.cssSelector(".profile-photo"));
        userIcon.click();
        driver.findElement(By.cssSelector("#Name")).sendKeys("epam");
        driver.findElement(By.cssSelector("#Password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".form-horizontal button[type = 'submit']")).click();

        //5 Assert User name in the left-top side of screen that user is logged in
        WebElement userName = driver.findElement(By.cssSelector(".profile-photo span"));
        assertEquals(userName.getText(), "PITER CHAILOVSKII");

        //6 Assert Browser title
        checkTitle(driver, "Home Page");

        //7 Assert that there are 4 items on the header section are displayed and they have proper texts
        WebElement navigateBar = driver.findElement(By.cssSelector(".uui-navigation"));
        WebElement element = navigateBar.findElement(By.cssSelector("[href='index.html']"));
        assertEquals(element.getText(), "HOME");
        element = navigateBar.findElement(By.cssSelector("[href='contacts.html']"));
        assertEquals(element.getText(), "CONTACT FORM");
        element = navigateBar.findElement(By.cssSelector("[class='dropdown']"));
        assertEquals(element.getText(), "SERVICE");
        element = navigateBar.findElement(By.cssSelector("[href='metals-colors.html']"));
        assertEquals(element.getText(), "METALS & COLORS");

        //8 Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> images = driver.findElements(By.cssSelector(".icons-benefit"));
        for (WebElement image : images) {
            assertTrue(image.isDisplayed());
        }

        //9 Assert that there are 4 texts on the Index Page under icons and they have proper text

        List<WebElement> texts = driver.findElements(By.cssSelector(".benefit-txt"));
        for (WebElement text : texts) {
            assertTrue(text.isDisplayed());
        }
        assertEquals(texts.get(0).getText(), "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");
        assertEquals(texts.get(1).getText(), "To be flexible and\n" +
                "customizable");
        assertEquals(texts.get(2).getText(), "To be multiplatform");
        assertEquals(texts.get(3).getText(), "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");

        //10 Assert a text of the main header
        // & 11 Assert a text of the sub header
        List<WebElement> centerTexts = driver.findElements(By.cssSelector(".text-center"));
        for (WebElement text : centerTexts) {
            assertTrue(text.isDisplayed());
        }
        assertEquals(centerTexts.get(0).getText(), "EPAM FRAMEWORK WISHES…");
        assertEquals(centerTexts.get(1).getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");
        assertEquals(centerTexts.get(2).getText(), "JDI GITHUB");

        //12 Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(centerTexts.get(2).findElement(By.cssSelector("a"))
                .getAttribute("href"), "https://github.com/epam/JDI");

        //13 Assert that there is Left Section
        assertTrue(driver.findElement(By.cssSelector("[name = 'navigation-sidebar']")).isDisplayed());

        //14 Assert that there is Footer.
        assertTrue(driver.findElement(By.cssSelector(".footer-content")).isDisplayed());
        //15 Close Browser
        driver.close();
    }

    public void checkTitle(WebDriver driver, String title) {
        assertEquals(driver.getTitle(), title);
    }
}
