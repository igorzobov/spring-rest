package app.service;

import app.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User show(long id);

    void save(User user);

    void update(User user);

    User getUserById(long id);

    void delete(long id);

    User getUserByName(String s);
}
