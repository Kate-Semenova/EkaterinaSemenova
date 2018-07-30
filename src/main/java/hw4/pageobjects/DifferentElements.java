package hw4.pageobjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hw4.enums.CheckBox;
import hw4.enums.Colors;
import hw4.enums.Radio;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

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
    public void selectCheckBoxes(CheckBox... checkBoxes) {
        for (CheckBox checkBox : checkBoxes) {
            selectCheckBox(checkBox);
        }
    }

    @Step
    public void shouldHasCorrectLogRowForCheckBoxes(CheckBox... checkBoxes) {
        for (int i = 0; i < checkBoxes.length; i++) {
            CheckBox checkBox = checkBoxes[checkBoxes.length - 1 - i];
            logCollection.get(i).shouldHave(text(checkBox.name + ": condition changed to "
                    + this.checkBoxes.get(checkBox.index).is(checked)));
        }
    }

    @Step
    public void shouldHasCorrectLogRowForRadio(Radio radio) {
        // TODO indexes. Is that really necessary do include lots of \\d here ???
        // TODO try to find another way, please...
        logCollection.get(0).shouldHave(text("metal: value changed to " + radio.name));
    }

    @Step
    public void shouldHasCorrectLogRowForDropDown(Colors dropDown) {
        // TODO same
        logCollection.get(0).shouldHave(text("Colors: value changed to "
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
    public void selectDropDown(Colors dropDownName) {
        dropDown.click();
        dropDownOptions.get(dropDownName.index).click();
    }
}
