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
        Configuration.browser = CHROME;
        Configuration.screenshots = false;
        Configuration.timeout = 10000;
        Configuration.pollingInterval = 200;
        Configuration.collectionsPollingInterval = 350;
        Configuration.startMaximized = true;
    }

}
