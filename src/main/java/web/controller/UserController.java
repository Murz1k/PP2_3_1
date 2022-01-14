package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.dao.UserDao;
import web.dao.UserDaoImpl;
import web.model.User;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserDao userDao;
    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/")
    public String showAllUser(Model model) {
        // получим всех людей из дао и сервиса и передадим на отображение
        List<User> userList = userDao.getAllUsers();
        model.addAttribute("users", userList);
        return "/showAllUser";
    }

    @GetMapping("/{id}") //сюда можем поместить любое число и оно вставится в аргументы этого метода
    public String show(@PathVariable("id") int id, Model model) {  // с помощью этой аннотации мы сможем вытащить id

        //получим однго человека по id из дао и сервиса и передадим на отображение

        return null;
    }

}
