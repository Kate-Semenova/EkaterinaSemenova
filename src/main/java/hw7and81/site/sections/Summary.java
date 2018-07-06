package hw7and81.site.sections;

import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import hw7and81.enums.Evens;
import hw7and81.enums.Odds;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Ekaterina on 26.06.2018.
 */
public class Summary extends Section {
    @FindBy(css = "#odds-selector p")
    public RadioButtons<Odds> odds;

    @FindBy(css = "#even-selector p")
    public RadioButtons<Evens> evens;

    public void selectOdd(int number) {

        if (number != 0) {
            odds.select(Odds.getByValue(number));
        }
    }

    public void selectEven(int number) {
        if (number != 0) {
            evens.select(Evens.getByValue(number));
        }
    }

}
