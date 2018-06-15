package hw4.pageobjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Selenide.actions;

/**
 * Created by Екатерина on 08.06.2018.
 */
public class Dates {
    private final String url = "https://epam.github.io/JDI/dates.html";
    @FindBy(css = ".ui-slider-handle")
    private ElementsCollection handles;
    @FindBy(css = ".uui-slider")
    private SelenideElement slider;
    @FindBy(css = ".logs > li")
    private ElementsCollection logCollection;

    public void setHandles(int from, int to) {
        setHandle(handles.get(0), from);
        setHandle(handles.get(1), to);
    }

    private void setHandle(SelenideElement handle, int value) {
        String widthPX = slider.getCssValue("width");
        double width = Double.parseDouble(widthPX.substring(0, widthPX.length() - 2));
        int current = Integer.parseInt(handle.getText());
        double oneStepInPixels = width / 100;
        int moveOn4 = (int) Math.round((value - current) * oneStepInPixels) - (int) oneStepInPixels;

        actions().dragAndDropBy(handle, moveOn4, 0).build().perform();
    }

    public void checkLogsValues(int from, int to) {
        logCollection.get(logCollection.size() - 2).should(matchText("\\d\\d:\\d\\d:\\d\\d" + ".*" + to + ".*"));
        logCollection.get(logCollection.size() - 1).should(matchText("\\d\\d:\\d\\d:\\d\\d" + ".*" + from + ".*"));
    }
}
