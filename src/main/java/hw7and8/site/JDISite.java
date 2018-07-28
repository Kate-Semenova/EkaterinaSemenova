package hw7and8.site;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import hw7and8.site.pages.HomePage;
import hw7and8.site.pages.MetalsColorsPage;

public class JDISite extends WebSite {
    @JPage(url = "/index.html", title = "Home Page")
    public static HomePage homePage;
    @JPage(url = "/metals-colors.html", title = "Metal and Colors")
    public static MetalsColorsPage metalsColorsPage;

}
