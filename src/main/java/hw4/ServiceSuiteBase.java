package hw4;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;


/**
 * Created by Екатерина on 15.06.2018.
 */
public class ServiceSuiteBase {
    @BeforeSuite(alwaysRun = true)
    public void setUpConfigurations() {
        Configuration.browser = "chrome";
        //Configuration.browserVersion = "2.9";
        Configuration.screenshots = false;
        Configuration.timeout = 10000;
        Configuration.pollingInterval = 200;
        Configuration.collectionsPollingInterval = 350;
        Configuration.startMaximized = true;
    }

}
