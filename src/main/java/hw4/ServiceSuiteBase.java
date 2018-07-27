package hw4;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.WebDriverRunner.CHROME;


/**
 * Created by Екатерина on 15.06.2018.
 */
public class ServiceSuiteBase {
    @BeforeSuite(alwaysRun = true)
    public void setUpConfigurations() {
        // TODO this wont work for me, actually. Anyway, this should be configured via pom.xml
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        System.setProperty("selenide.browser", "Chrome");
        Configuration.screenshots = false;
        Configuration.timeout = 10000;
        Configuration.pollingInterval = 200;
        Configuration.collectionsPollingInterval = 350;
        Configuration.startMaximized = true;
    }

}
