package org.sda.java26.repository;

import org.sda.java26.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private static UserRepository INSTANCE = new UserRepository();

    private List<User> users;

    private UserRepository() {
        users = new ArrayList<>();
    }

    public static UserRepository getInstance() {
        return INSTANCE;
    }

    // find - oczekujemy wiele elementów (liste)
    // get - oczekujemy jednego elementu

    public List<User> findUsers(){
        return users;
    }

    public void saveUser(User user){
        users.add(user);
    }

    public User getByLogin(String login) {
        return users
                .stream()
                .filter(user -> user.getLogin().equals(login))
                .findFirst()
                .orElse(null);
    }
}
