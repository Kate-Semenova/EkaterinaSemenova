package hw7and8.site.pages;

import hw7and8.entities.MetalColor;
import hw7and8.site.forms.MetalColorForm;
import hw7and8.site.sections.Result;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Ekaterina on 26.06.2018.
 */

public class MetalsColorsPage extends Page {
    @FindBy(className = "form")
    private MetalColorForm metalColorForm;

    @FindBy(css = ".info-panel-body-result")
    public Result result;

    @Step
    public void submitChanges() {
        metalColorForm.submitClick();
    }

    @Step
    public void fillForm(MetalColor metalColor) {
        metalColorForm.fillForm(metalColor);
    }

}
