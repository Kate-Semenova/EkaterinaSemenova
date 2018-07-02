package hw7and8.entities;

import com.epam.commons.DataClass;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public class User extends DataClass {
    public String login;
    public String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
