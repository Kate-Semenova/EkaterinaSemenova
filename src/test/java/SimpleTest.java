import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Observable;

/**
 * Created by Екатерина on 18.05.2018.
 */
public class SimpleTest {

    @Test
    public void simpleSeleniumTest(){
        System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", "target");

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        WebDriver driver = new ChromeDriver();

        WebDriver.Window window = driver.manage().window();
        window.maximize();
        //Evaluate Expretion часто используется для отлова противного бага
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");

        Assert.assertEquals(driver.getTitle(), "Index Page");
        String Url = "https://jdi-framework.github.io/tests/index.htm";
        Assert.assertEquals(driver.getCurrentUrl(), Url);

        WebElement userIcon = driver.findElement(By.cssSelector(".fa-user"));
        userIcon.click();
        driver.findElement(By.cssSelector("#Login")).sendKeys("epam");
        driver.findElement(By.cssSelector("#Password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".form-horizontal button[type = 'submit']")).click();

        WebElement userName = driver.findElement(By.cssSelector(".profile-photo span"));
        Assert.assertEquals(userName.getText(), "PITER CHAILOVSKII");
        driver.close();
    }
}
