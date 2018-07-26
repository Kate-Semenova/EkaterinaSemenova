package hw7and8.enums;

import lombok.Getter;

/**
 * Created by Ekaterina on 25.06.2018.
 */
@Getter
// TODO Code convention !
public enum HeaderMenu {
    Home("Home"),
    Contact_form("Contact form"),
    Service("Service"),
    Metals_n_Colors("Metals & Colors");

    private String value;

    HeaderMenu(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
