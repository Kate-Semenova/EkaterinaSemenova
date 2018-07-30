package hw6.table;

/**
 * Created by Ekaterina on 29.07.2018.
 */
public class TableLine {
    private String number;
    private String type;
    private String description;
    private String user;

    public TableLine(String number, String type, String description, String user) {
        this.number = number;
        this.type = type;
        this.description = description;
        this.user = user;
    }

    public String getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public String getUser() {
        return user;
    }

    public String getDescription() {
        return description;
    }

}
