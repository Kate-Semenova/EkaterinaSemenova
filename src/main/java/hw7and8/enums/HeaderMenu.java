package hw7and8.enums;

import lombok.Getter;

/**
 * Created by Ekaterina on 25.06.2018.
 */
@Getter
// TODO Code convention !
public enum HeaderMenu {
    HOME("HOME"),
    CONTACT_FORM("CONTACT FORM"),
    SERVICE("SERVICE"),
    METALS_N_COLORS("METALS & COLORS");

    public final String title;

    HeaderMenu(String value) {
        this.title = value;
    }

    @Override
    public String toString() {
        return title;
    }

    public static void main(String[] args) {
        for (HeaderMenu str : HeaderMenu.values()
                ) {

        }
    }
}
