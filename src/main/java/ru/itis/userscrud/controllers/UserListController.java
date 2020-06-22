package ru.itis.userscrud.controllers;

import com.google.common.collect.Collections2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;
import ru.itis.userscrud.models.User;
import ru.itis.userscrud.services.UserService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/userlist")
public class UserListController {
    @Autowired
    UserService userService;

    @GetMapping
    public String getUsers(ModelMap map) {
        map.put("users", userService.getAllUsers());
        return "userlist";
    }

    @GetMapping("/endless")
    public String giveFirstUsers(ModelMap map) {
        User user = new User(1, "some@email.com", "qwerty", "UK", 'f', LocalDate.now());
        map.put("users", Arrays.asList(user, user, user, user, user));
        return "endless-userlist";
    }

    @GetMapping(value = "/endless-api", produces = "application/json")
    @ResponseBody
    public List<User> getNextUsers(@RequestParam("page") Integer pageNumber) {
        System.out.println("got pageNumber: " + pageNumber);
        if(pageNumber == null) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "specify page number");
        }
        User user = new User(pageNumber, "some@email.com", "qwerty", "UK", 'f', LocalDate.now());
        return Arrays.asList(user, user, user, user, user);
    }
}
