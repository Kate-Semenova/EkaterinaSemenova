package hw6.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ekaterina on 28.07.2018.
 */
public enum HeaderMenu {
    HOME("HOME","index.html", "HOME PAGE"),
    CONTACT_FORM("CONTACT FORM", "contacts.html", "CONTACT FORM"),
    SERVICE("SERVICE","",""),
    SUPPORT("SUPPORT","support.html", "SUPPORT"),
    DATES("DATES","dates.html","DATES"),
    COMPLEX_TABLE("COMPLEX TABLE","complex-table.html","COMPLEX TABLE"),
    SIMPLE_TABLE("SIMPLE TABLE","simple-table.html","SIMPLE TABLE"),
    USER_TABLE("USER TABLE","user-table.html","USER TABLE"),
    TABLE_WITH_PAGES("TABLE WITH PAGES","table-pages.html","TABLE WITH PAGES"),
    DIFFERENT_ELEMENTS("DIFFERENT ELEMENTS","different-elements.html","DIFFERENT ELEMENT"),
    PERFORMANCE("PERFORMANCE","performance.html","SIMPLE TABLE"),
    METALS_N_COLORS("METALS & COLORS","metals-colors.html","METAL AND COLORS");


    public final String NAME;
    public final String URL;
    public final String TITTLE;

    public final static Map<String, HeaderMenu> MAP = new HashMap<>();
    static {
        for (HeaderMenu cell : HeaderMenu.values()) {
            MAP.put(cell.NAME, cell);
        }
    }

    HeaderMenu(String name, String url, String tittle) {
        this.NAME = name;
        this.URL = url;
        this.TITTLE = tittle;
    }

}
