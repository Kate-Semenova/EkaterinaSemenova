package hw7and81.enums;

import hw7and81.entities.User;

/**
 * Created by Ekaterina on 25.06.2018.
 */
public enum Users {
    Piter_Chailovskii("epam", "1234", "Piter Chailovskii");
    private String login;
    private String password;
    private String fullName;

    Users(String login, String password, String fullName) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
    }

    public User getUser() {
        return new User(this.login, this.password);
    }

    public String getFullName() {
        return fullName;
    }

}
