package hw7and81.site.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import com.epam.web.matcher.testng.Assert;
import hw7and81.utils.TestingData;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Arrays;
import java.util.List;

//import org.testng.Assert;

/**
 * Created by Ekaterina on 26.06.2018.
 */
public class Result extends Section {
    @FindBy(css = "li")
    public List<Label> listOfResults;

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

    //TODO make properties maybe
    private final static String LOGS[] = {"Summary: ", "Elements: ", "Color: ", "Metal: ", "Vegetables: "};

    @Step
    public void checkTextInLog(TestingData data) {
        String elements = Arrays.toString(data.getElements());
        String vegetables = Arrays.toString(data.getVegetables());
        Assert.areEquals(summaryResult.getText(),"Summary: " + data.sum() );
        Assert.areEquals(colorResult.getText(),"Color: " + data.getColor() );

        Assert.areEquals(metalResult.getText(),"Metal: " + data.getMetals() );
        Assert.areEquals(saladResult.getText(),"Vegetables: " + vegetables.substring(1, vegetables.length() - 1) );

        if (!data.getElements()[0].equals("Elements")) {
            Assert.areEquals(elementResult.getText(), "Elements: " + elements.substring(1, elements.length() - 1));
        }
    }
    @Step
    public void checkText(int ODD, int EVEN, List<String> ELEMENTS, String COLOR, String METAL, List<String> VEGETABLES) {

        String elementsStr = Arrays.toString(ELEMENTS.stream().toArray());
        elementsStr = elementsStr.substring(1, elementsStr.length() - 1);

        String vegetablesStr = Arrays.toString(VEGETABLES.stream().toArray());
        vegetablesStr = vegetablesStr.substring(1, vegetablesStr.length() - 1);

        String numberStr = String.valueOf(ODD + EVEN);

        String[] ends = {numberStr,
                elementsStr, COLOR, METAL, vegetablesStr};

        for (int i = 0; i < listOfResults.size(); i++) {
            Label log = listOfResults.get(i);
            Assert.assertEquals(log.getText(), LOGS[i] + ends[i]);
        }

    }

}
