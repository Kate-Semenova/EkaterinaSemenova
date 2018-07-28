package hw7and8.site.sections;

import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import hw7and8.enums.metalcolor.Evens;
import hw7and8.enums.metalcolor.Odds;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Ekaterina on 26.06.2018.
 */
public class Summary extends Section {
    @FindBy(css = "#odds-selector p")
    public RadioButtons<Odds> odds;

    @FindBy(css = "#even-selector p")
    public RadioButtons<Evens> evens;


    public void select(int... integers) {
        if (integers.length == 2) {
            odds.select(Odds.getByValue(integers[0]));
            evens.select(Evens.getByValue(integers[1]));
        }
    }

}
