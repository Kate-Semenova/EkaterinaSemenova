package hw7and81.site.pages;

import com.epam.jdi.uitests.core.settings.JDISettings;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.ComboBox;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JComboBox;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import hw7and81.enums.*;
import hw7and81.site.sections.Result;
import hw7and81.site.sections.Summary;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

/**
 * Created by Ekaterina on 26.06.2018.
 */

public class MetalsColorsPage extends WebPage {
    @FindBy(id = "summary-block")
    public Summary summary;

    @JComboBox(
            root = @FindBy(css = "#elements-block"),
            list = @FindBy(css = ".checkbox")
    )
    public ComboBox<FourElements> elements;

    @JDropdown(
            root = @FindBy(css = "#colors"),
            expand = @FindBy(css = ".caret"),
            list = @FindBy(css = ".text")
    )
    public Dropdown<Colors> colors;

    @JDropdown(
            root = @FindBy(css = "#metals"),
            expand = @FindBy(css = ".caret"),
            list = @FindBy(css = ".text")
    )
    public Dropdown<Metals> metals;
    @JDropdown(
            root = @FindBy(css = "#salad-dropdown"),
            expand = @FindBy(css = ".caret"),
            list = @FindBy(css = ".checkbox")
    )
    public Dropdown<Vegetables> salad;

    @FindBy(css = "#submit-button")
    public Button submit;

    @FindBy(css = ".info-panel-body-result")
    public Result result;

    @Step
    public void submitChanges() {
        submit.click();
    }

    @Step
    public void selectOdd(String odd) {
        if (Odds.hasOdd(odd)) {
            summary.odds.select(odd);
        } else {
            loggerCanNotSelect(odd);

        }
    }

    @Step
    public void selectEven(String even) {
        if (Evens.hasEven(even)) {
            summary.evens.select(even);
        } else {
            loggerCanNotSelect(even);

        }
    }

    @Step
    public void selectColor(String color) {
        if (Colors.hasColor(color)) {
            colors.select(color);
        } else {
            loggerCanNotSelect(color);

        }
    }

    @Step
    public void selectMetal(String metal) {
        if (Metals.hasMetal(metal)) {
            metals.select(metal);
        } else {
            loggerCanNotSelect(metal);
        }
    }

    @Step
    public void selectElements(List<String> fourElements) {
        for (String element : fourElements
                ) {
            if (FourElements.hasElement(element)) {
                elements.select(element);
            } else {
                loggerCanNotSelect(element);
            }
        }
    }

    @Step
    public void selectElements(String[] fourElements) {
        for (String element : fourElements
                ) {
            if (FourElements.hasElement(element)) {
                elements.select(element);
            } else {
                loggerCanNotSelect(element);
            }
        }
    }

    @Step
    public void selectVegetables(List<String> vegetables) {
        //As it is checked by default
        salad.select("Vegetables");
        for (String vegetable : vegetables
                ) {
            if (Vegetables.hasVegetable(vegetable)) {
                //As it is checked by default
                salad.select(vegetable);
            } else {
                loggerCanNotSelect(vegetable);
            }
        }
    }

    @Step
    public void selectVegetables(String[] vegetables) {
        //As it is checked by default
        salad.select("Vegetables");

        for (String vegetable : vegetables
                ) {
            if (Vegetables.hasVegetable(vegetable)) {
                salad.select(vegetable);
            } else {
                loggerCanNotSelect(vegetable);
            }
        }
    }




    private void loggerCanNotSelect(String value) {
        JDISettings.logger.info("Can`t select '" + value + "'. Data mistake");
    }
}
