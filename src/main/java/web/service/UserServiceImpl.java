package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

public class UserServiceImpl implements UserService{
@Autowired
private UserDao userDao;
    @Override
    public void addUser(User user) {

    }

    @Override
    public void updateUser(int id, User user) {

    }

    @Override
    public void removeUser(int id) {

    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
