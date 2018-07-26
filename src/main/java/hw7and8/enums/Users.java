package hw7and8.enums;

import hw7and8.entities.User;

/**
 * Created by Ekaterina on 25.06.2018.
 */
public enum Users {
    // TODO code convention !!
    Piter_Chailovskii("epam", "1234", "Piter Chailovskii");
    private String login;
    private String password;
    private String fullName;

    Users(String login, String password, String fullName) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
    }

    // TODO What is this ? Is that make sense to create NEW instance of user in case if we already have instance of user ?
    public User getUser() {
        return new User(this.login, this.password);
    }

    public String getFullName() {
        return fullName;
    }

}
