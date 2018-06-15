package hw4.enums;

/**
 * Created by Екатерина on 08.06.2018.
 */
public enum User {
    PITER_CHAILOVSKII("epam", "1234", "PITER CHAILOVSKII");
    public String login;
    public String password;
    public String name;

    User(String login, String password, String name) {
        this.name = name;
        this.login = login;
        this.password = password;
    }
}
