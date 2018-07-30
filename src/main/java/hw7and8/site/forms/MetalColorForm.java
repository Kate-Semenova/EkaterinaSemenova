package hw7and8.site.forms;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.ComboBox;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JComboBox;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import hw7and8.entities.MetalColor;
import hw7and8.enums.metalcolor.Colors;
import hw7and8.enums.metalcolor.FourElements;
import hw7and8.enums.metalcolor.Metals;
import hw7and8.enums.metalcolor.Vegetables;
import hw7and8.site.sections.Summary;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Ekaterina on 26.07.2018.
 */
public class MetalColorForm extends Form<MetalColor> {
    @FindBy(id = "summary-block")
    public Summary summary;

    @JComboBox(
            root = @FindBy(css = "#elements-block"),
            list = @FindBy(css = "#elements-checklist p")
    )
    public ComboBox<FourElements> elements;

    @JDropdown(
            root = @FindBy(css = "#colors"),
            expand = @FindBy(css = ".caret"),
            list = @FindBy(css = ".text"),
            value = @FindBy(css = ".filter-option")
    )
    public Dropdown<Colors> color;

    @JDropdown(
            root = @FindBy(css = "#metals"),
            expand = @FindBy(css = ".caret"),
            list = @FindBy(css = ".text"),
            value = @FindBy(css = ".filter-option")
    )
    public Dropdown<Metals> metals;

    @JDropdown(
            root = @FindBy(css = "#salad-dropdown"),
            expand = @FindBy(css = ".caret"),
            list = @FindBy(css = ".checkbox")
    )
    public Dropdown<Vegetables> vegetables;

    @FindBy(css = "#submit-button")
    public Button submit;

    public void submitClick() {
        submit.click();
    }

    // TODO dou you read my comment about last data set ??
    public void fillForm(MetalColor metalColor) {

        summary.select(metalColor.getSummary());

        if (metalColor.getElements().length != 0) {
            for (String string : metalColor.getElements()
                    ) {
                elements.select(string);
            }
        }
        if (!metalColor.getColor().equals("")) {
            color.select(metalColor.getColor());
        }
        if (!metalColor.getMetals().equals("")) {
            metals.select(metalColor.getMetals());
        }

        if (metalColor.getVegetables().length != 0) {
            vegetables.select("Vegetables");
            for (String vegetable : metalColor.getVegetables()) {
                vegetables.select(vegetable);
            }
        }
    }
}
