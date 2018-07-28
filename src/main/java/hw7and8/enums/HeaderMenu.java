package hw7and8.enums;

import lombok.Getter;

/**
 * Created by Ekaterina on 25.06.2018.
 */
@Getter
// TODO Code convention !
public enum HeaderMenu {
    HOME("Home"),
    CONTACT_FORM("Contact form"),
    SERVICE("Service"),
    METALS_N_COLORS("Metals & Colors");

    private final String value;

    HeaderMenu(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
