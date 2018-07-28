package hw7and8.enums;

import hw7and8.entities.User;

/**
 * Created by Ekaterina on 25.06.2018.
 */
public enum Users {
    //  code convention !!
    // *** made upper case
    PITER_CHAILOVSKII("epam", "1234", "Piter Chailovskii");
    public String login;
    public String password;
    private String fullName;

    Users(String login, String password, String fullName) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
    }

    // TODO What is this ? Is that make sense to create NEW instance of user in case if we already have instance of user ?
    //Can`t get it. The User class should extend DataClass. But i like using enams for users` data6 so decided to gothis way
    //would like to know the best practise. Of course i can make a "final static" variable in the User class
    //SO THAT IS WHAT I HAVE DONE - MADE CONSTANT IN User.class

    public User getUser() {
        return new User(this.login, this.password);
    }

    public String getFullName() {
        return fullName;
    }

}
