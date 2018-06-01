package hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Екатерина on 28.05.2018.
 */
public class HomePageTextTest {
    private ChromeOptions options;
  //  private ;
    private String css = ".benefit-txt";
    private String url = "https://epam.github.io/JDI/index.html";

    @DataProvider(parallel = true)
    public Object[][] textInformation(){
        return new Object[][]{
                {0, "To include good practices\nand ideas from successful\nEPAM project"},
                {1,"To be flexible and\ncustomizable"},
                {2,"To be multiplatform"},
                {3,"Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"}
        };
    }
    @BeforeClass
    public void setUpConfigurs(){
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", "target");
        options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

    }
    @BeforeMethod
    public void before(){
    }

    @AfterMethod
    public void after(){
    }

    @Test (dataProvider = "textInformation")
    public void textTest(int i, String text){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);
        List<WebElement> imageAndTextDivs = driver.findElements(By.cssSelector(css));
        Assert.assertEquals(imageAndTextDivs.get(i).getText(), text);
        driver.close();

    }
}
