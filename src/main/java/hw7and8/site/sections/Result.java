package hw7and8.site.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import com.epam.web.matcher.testng.Assert;
import hw7and8.entities.MetalColor;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Arrays;

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


    @Step
    // TODO it will be better with loop
    public void checkTextInLog(MetalColor data) {
        String elements = Arrays.toString(data.getElements());
        String vegetables = Arrays.toString(data.getVegetables());
        Assert.areEquals(summaryResult.getText(), "Summary: " + data.sum());

        if (!data.getColor().equals("")) {
            Assert.areEquals(colorResult.getText(), "Color: " + data.getColor());
        } else {
            Assert.areEquals(colorResult.getText(), "Color: Colors");
        }
        if (!data.getMetals().equals("")) {
            Assert.areEquals(metalResult.getText(), "Metal: " + data.getMetals());
        } else {
            Assert.areEquals(metalResult.getText(), "Metal: Metals");
        }
        if (data.getVegetables().length != 0) {
            Assert.areEquals(saladResult.getText(), "Vegetables: " + vegetables.substring(1, vegetables.length() - 1));
        } else {
            Assert.areEquals(saladResult.getText(), "Vegetables: Vegetables");
        }

        if (data.getElements().length != 0) {
            Assert.areEquals(elementResult.getText(), "Elements: " + elements.substring(1, elements.length() - 1));
        }
    }
}
