package hw6.po;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hw6.enums.HeaderMenu;
import hw6.table.TableData;
import hw6.table.TableLine;
import hw6.enums.HeaderMenu;
import hw6.enums.Table;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.url;

/**
 * Created by Ekaterina on 05.07.2018.
 */
public class UserTable {
    @FindBy(css = "tbody > tr")
    private ElementsCollection tableLines;

    @FindBy(css = ".logs > li")
    private ElementsCollection logs;

    private SelenideElement changedVIP;
    private SelenideElement openedDropDown;
    private ElementsCollection dropDownOptions;

    public UserTable() {
        page(this);
    }

    @Step
    @Given("I am on User Table Page")
    public void check() {
        Assert.assertEquals(url(), "https://epam.github.io/JDI/" + HeaderMenu.USER_TABLE.URL);
    }

    @Step
    @Given("User Table Page's interface contains correct elements")
    public void checkElements() {
        tableLines.shouldHave(CollectionCondition.size(7));
    }

    public TableData table() {
        return TableData.getInstance(tableLines);
    }

    @Step
    @Then("User table contain correct values for numbers and users")
    // TODO this will be better with List<MyClass> varName
    public void checkValues(List<TableLine> varName) {
        // TODO you have to create method, that allow us to get the whole Users from table
        // TODO and compare them with expected lists of the Users...
        for (int i = 0; i < varName.size(); i++) {
            table().getNUMBERS().get(i).shouldHave(Condition.text(varName.get(i).getNumber()));
            table().getUSERS().get(i).shouldHave(Condition.text(varName.get(i).getUser()));
        }
    }

    @Step
    @When("I check Number and User columns of Users table")
    public void checkNumberUser() {
        tableLines.shouldHave(CollectionCondition.size(7));
    }

    @Step
    @Then("All cells of 'Description' column contains text")
    // TODO same
    //DONE
    public void checkDescription(List<TableLine> varName) {
        for (int i = 0; i < varName.size(); i++) {
            table().getNUMBERS().get(i).shouldHave(Condition.text(varName.get(i).getNumber()));
            table().getDESCRIPTIONS().get(i).shouldHave(Condition.text(varName.get(i).getDescription()));

        }
    }

    @Step
    @When("I check Description column of Users table")
    public void checkDescription() {
        tableLines.get(0).$$("th").get(Table.DESCIPTION.index).shouldBe(Condition.visible);
        for (int i = 1; i < tableLines.size(); i++) {
            tableLines.get(i).$$("td").get(Table.DESCIPTION.index).shouldBe(Condition.visible);

        }
    }

    @Step
    @When("I set 'vip' status to (.*)")
    public void setVIP(String name) {
        for (int i = 1; i < tableLines.size(); i++) {
            if (tableLines.get(i).$$("td").get(Table.USER.index).has(Condition.text(name))) {
                changedVIP = tableLines.get(i).$("[type='checkbox']");
                changedVIP.click();
            }
        }
    }

    @Step
    @Then("'Log' section shows a log row in format: FIELDNAME: condition changed to STATUS")
    public void checkLog() {
        String regex = "Vip: condition changed to " + changedVIP.is(Condition.checked);
        logs.get(0).should(Condition.matchText(regex));
    }

    @Step
    @When("I click on dropdown in column Type for user (.*)")
    public void clickOnDropDown(String name) {
        for (int i = 1; i < tableLines.size(); i++) {
            if (tableLines.get(i).$$("td").get(Table.USER.index).has(Condition.text(name))) {
                openedDropDown = tableLines.get(i).$("select");
                openedDropDown.click();
            }
        }
        dropDownOptions = openedDropDown.$$("option");
    }

    @Step
    @Then("droplist contains values")
    public void checkDropDownValues(List<String> options) {
        dropDownOptions.shouldHave(CollectionCondition.texts(options));
    }
}
