package hw4;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;


/**
 * Created by Екатерина on 15.06.2018.
 */
public class ServiceSuiteBase {
    @BeforeSuite(alwaysRun = true)
    public void setUpConfigurations() {
        // TODO this wont work for me, actually. Anyway, this should be configured via pom.xml
        //Sorry for wrong path
        //ANYWAY these "setProperty" things were done to prevent io.github.bonigarcia.wdm.WebDriverManagerException
        //It occurred after I started to work with JDI in the same project
        //Without JDI dependencies I would normally use Configuration.browser = CHROME;
        //It was the only way I have found to make my tests work right away
        //THANK YOU for your suggestion
        //System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");
        //System.setProperty("selenide.browser", "Chrome");
        Configuration.browser = "chrome";
        Configuration.screenshots = false;
        Configuration.timeout = 10000;
        Configuration.pollingInterval = 200;
        Configuration.collectionsPollingInterval = 350;
        Configuration.startMaximized = true;
    }

}
