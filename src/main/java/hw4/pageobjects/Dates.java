package hw4.pageobjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.actions;

/**
 * Created by Екатерина on 08.06.2018.
 */
public class Dates {
    @FindBy(css = ".ui-slider-handle")
    private ElementsCollection handles;
    @FindBy(css = ".uui-slider")
    private SelenideElement slider;
    @FindBy(css = ".logs li")
    private List<SelenideElement> logCollection;
    private int last = 1;


    @Step
    public void setHandles(int from, int to) {
        int previousFrom = Integer.parseInt(handles.get(0).getText());
        int previousTo = Integer.parseInt(handles.get(1).getText());
        if (previousFrom != previousTo) {
            if (previousTo < from) {
                setHandle(handles.get(1), to);
                setHandle(handles.get(0), from);
                last = 0;
                return;
            }
            if (previousFrom > to) {
                setHandle(handles.get(0), from);
                setHandle(handles.get(1), to);
                last = 1;
                return;
            }
            setHandle(handles.get(0), from);
            setHandle(handles.get(1), to);
            last = 1;
        } else {
            if (last == 0) {
                setHandle(handles.get(0), from);
                setHandle(handles.get(1), to);
                last = 1;
            }
            if (last == 1) {
                setHandle(handles.get(1), to);
                setHandle(handles.get(0), from);
                last = 0;
            }
        }
    }

    @Step
    public void checkLogsValues(int from, int to) {
        logCollection.get(Math.abs(last - 1)).shouldHave(text("Range 2(To):" + to + " link clicked"));
        logCollection.get(last).shouldHave(text("Range 2(From):" + from + " link clicked"));
    }

    private void setHandle(SelenideElement handle, int value) {
        String widthPX = slider.getCssValue("width");
        double width = Double.parseDouble(widthPX.substring(0, widthPX.length() - 2));
        int current = Integer.parseInt(handle.getText());
        double oneStepInPixels = width / 100;
        int moveOn4 = (int) Math.round((value - current) * oneStepInPixels) - (int) oneStepInPixels;

        actions().dragAndDropBy(handle, moveOn4, 0).build().perform();
    }
}
