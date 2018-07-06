package hw7and81.entities;

import com.epam.commons.DataClass;


public class User extends DataClass {
    public String login;
    public String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
