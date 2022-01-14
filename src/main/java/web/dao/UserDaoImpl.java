package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
    @PersistenceContext
    private EntityManager entityManager;

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
    @Transactional// при использовании транзакшинал, спринг берет на себя ответсвенность за открытие и закрытие сессии
    public List<User> getAllUsers() {// урок 070
       List<User> allUsers = entityManager.createQuery("select user from User user", User.class).getResultList();
        return allUsers;
    }
}
