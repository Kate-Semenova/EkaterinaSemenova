package hw7and8.entities;

import com.epam.commons.DataClass;


public class User extends DataClass {
    public static final User PITER_CHALKOVSKII = new User("epam", "1234");

    private String name;
    private String password;

    public User(String login, String password) {
        this.name = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return name + ", " + password;
    }
}
