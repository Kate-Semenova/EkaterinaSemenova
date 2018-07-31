package hw7and8.site.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import com.epam.web.matcher.testng.Assert;
import hw7and8.entities.MetalColor;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import org.testng.Assert;

/**
 * Created by Ekaterina on 26.06.2018.
 */
public class Result extends Section {

    @FindBy(css = ".summ-res")
    public Label summaryResult;

    @FindBy(css = ".col-res")
    public Label colorResult;

    @FindBy(css = ".met-res")
    public Label metalResult;

    @FindBy(css = ".sal-res")
    public Label saladResult;

    @FindBy(css = ".elem-res")
    public Label elementResult;

    public List<Label> listOfLabels() {
        List<Label> l = new ArrayList<>();
        l.add(summaryResult);
        l.add(colorResult);
        l.add(metalResult);
        l.add(saladResult);
        l.add(elementResult);
        return l;
    }

    @Step
    // TODO it will be better with loop
    //like this?
    public void checkTextInLog(MetalColor data) {
        List<Label> list = listOfLabels();
        for (int i = 0; i < list.size(); i++) {
            Assert.areEquals(list.get(i).getText(), MetalColor.ListOfLog.values()[i].logText + data.listOfData().get(i));
        }
    }
}
