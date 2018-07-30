package hw3.enums;

/**
 * Created by Ekaterina on 28.07.2018.
 */
public enum Pages {
    HOME_PAGE("Home Page"),
    CONTACT_FORM("Contact form"),
    SERVICE("Service"),
    METALS_N_COLORS("Metals & Colors");

    public final String title;

    Pages(String title) {
        this.title = title;
    }
}
