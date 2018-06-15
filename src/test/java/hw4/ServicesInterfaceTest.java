package hw4;

import hw4.pageobjects.Dates;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;

/**
 * Created by Ekaterina on 01.06.2018.
 */
public class ServicesInterfaceTest extends SuiteBase {
    private Dates datesPage;

    @DataProvider
    public Object[][] information() {
        return new Object[][]{
                {0, 100},
                {0, 0},
                {100, 100},
                {30, 70}
        };
    }

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        datesPage = page(Dates.class);
    }

    @Test(dataProvider = "information")
    public void sliderTest(int from, int to) {

        //5 Range sliders
        datesPage.setHandles(from, to);

        //6 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogsValues(from, to);

    }
}
