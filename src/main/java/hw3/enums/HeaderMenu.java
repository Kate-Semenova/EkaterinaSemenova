package hw3.enums;

/**
 * Created by Ekaterina on 28.07.2018.
 */
public enum HeaderMenu {
    HOME("HOME"),
    CONTACT_FORM("CONTACT FORM"),
    SERVICE("SERVICE"),
    METALS_N_COLORS("METALS & COLORS");

    public final String value;

    HeaderMenu(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
