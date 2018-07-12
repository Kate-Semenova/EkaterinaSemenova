package hw4.pageobjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.eo.Se;
import hw4.enums.CheckBox;
import hw4.enums.DropDown;
import hw4.enums.Radio;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.codeborne.selenide.Condition.*;

/**
 * Created by Екатерина on 18.06.2018.
 */
public class DifferentElements {
    @FindBy(css = ".label-checkbox > input")
    private ElementsCollection checkBoxes;

    @FindBy(css = ".label-radio")
    private ElementsCollection radios;

    @FindBy(css = ".colors > [class = uui-form-element]")
    private SelenideElement dropDown;

    @FindBy(css = ".main-content-hg > [class = 'uui-button']")
    private ElementsCollection buttons;

    @FindBy(css = ".right-fix-panel")
    private SelenideElement rightSection;

    @FindBy(css = ".mCSB_vertical")
    private SelenideElement leftSection;

    @FindBy(css = "option")
    private ElementsCollection dropDownOptions;

    @FindBy(css = ".logs li")
    private List<SelenideElement> logCollection;

    public void shouldHasAllNeededElements() {
        checkBoxes.shouldHaveSize(4);
        radios.shouldHaveSize(4);
        dropDown.shouldBe(visible);
        buttons.shouldHaveSize(2);
    }

    @Step
    public void shouldHasLeftSection() {
        leftSection.shouldBe(visible);
    }

    @Step
    public void shouldHasRightSection() {
        rightSection.shouldBe(visible);
    }

    @Step
    public void selectElement(Object... elements) {

        if (elements[0] instanceof DropDown) {
            selectDropDown((DropDown) elements[0]);
        }
        if (elements[0] instanceof Radio) {
            selectRadio((Radio) elements[0]);
        }

    }

    @Step
    public void selectCheckBoxes(CheckBox... checkBoxes) {
        for (CheckBox checkBox : checkBoxes) {
            selectCheckBox(checkBox);
        }
    }

    @Step
    public void shouldHasCorrectLogRowForCheckBoxes(CheckBox... checkBoxes) {
        for (int i = 0; i < checkBoxes.length; i++) {
            CheckBox checkBox = checkBoxes[checkBoxes.length - 1 - i];
            logCollection.get(i).should(matchText("\\d\\d:\\d\\d:\\d\\d "
                    + checkBox.name + ": condition changed to "
                    + this.checkBoxes.get(checkBox.index).is(checked)));
        }
    }

    @Step
    public void shouldHasCorrectLogRowForRadio(Radio radio) {

        logCollection.get(0).should(matchText("\\d\\d:\\d\\d:\\d\\d metal: value changed to "
                + radio.name));
    }
    @Step
    public void shouldHasCorrectLogRowForDropDown(DropDown dropDown) {

        logCollection.get(0).should(matchText("\\d\\d:\\d\\d:\\d\\d Colors: value changed to "
                + dropDown.name));
    }

    private void selectCheckBox(CheckBox checkBoxName) {
        checkBoxes.get(checkBoxName.index).click();
    }

    @Step
    public void selectRadio(Radio radio) {
        radios.get(radio.index).click();
    }

    @Step
    public void selectDropDown(DropDown dropDownName) {
        dropDown.click();
        dropDownOptions.get(dropDownName.index).click();
    }
}
