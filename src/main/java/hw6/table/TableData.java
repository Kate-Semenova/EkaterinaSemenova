package hw6.table;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hw6.enums.Table;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ekaterina on 29.07.2018.
 */
public class TableData {
    private static TableData instance;
    private List<SelenideElement> NUMBERS = new ArrayList<>();
    private List<SelenideElement> TYPES = new ArrayList<>();
    private List<SelenideElement> USERS = new ArrayList<>();
    private List<SelenideElement> DESCRIPTIONS = new ArrayList<>();

    private TableData(ElementsCollection tableLines) {
        for (int i = 1; i < tableLines.size(); i++) {
            NUMBERS.add(tableLines.get(i).$$("td").get(Table.NUMBER.index));
            TYPES.add(tableLines.get(i).$$("td").get(Table.TYPE.index));
            USERS.add(tableLines.get(i).$$("td").get(Table.USER.index));
            DESCRIPTIONS.add(tableLines.get(i).$$("td").get(Table.DESCIPTION.index));
        }
    }

    public static TableData getInstance(ElementsCollection collection) {
        if (instance == null) {
            instance = new TableData(collection);
        }
        return instance;
    }


    public List<SelenideElement> getNUMBERS() {
        return NUMBERS;
    }

    public List<SelenideElement> getTYPES() {
        return TYPES;
    }

    public List<SelenideElement> getUSERS() {
        return USERS;
    }

    public List<SelenideElement> getDESCRIPTIONS() {
        return DESCRIPTIONS;
    }
}
