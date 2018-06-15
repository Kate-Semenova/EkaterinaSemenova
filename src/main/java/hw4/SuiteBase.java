package hw4;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.close;

/**
 * Created by Екатерина on 15.06.2018.
 */
public class SuiteBase {
    @BeforeSuite(alwaysRun = true)
    public void setUpConfigurations() {
        Configuration.browser = "chrome";
        Configuration.screenshots = false;
        Configuration.timeout = 10000;
        Configuration.pollingInterval = 200;
        Configuration.collectionsPollingInterval = 350;
        Configuration.startMaximized = true;
    }
    @AfterSuite(alwaysRun = true)
    public void closeBrowser(){
        //7 Close browser
        close();
    }
}
