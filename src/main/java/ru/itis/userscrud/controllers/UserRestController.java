package ru.itis.userscrud.controllers;

import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import ru.itis.userscrud.aspect.AspectLogged;
import ru.itis.userscrud.controllers.util.ValidationError;
import ru.itis.userscrud.controllers.util.ValidationErrorBuilder;
import ru.itis.userscrud.dto.UserRestDto;
import ru.itis.userscrud.models.User;
import ru.itis.userscrud.services.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("rest/users")
@RestController
public class UserRestController {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @AspectLogged
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<UserRestDto> all() {
        logger.info("rest getting all users (by log4j)");
        return userService.getAllUsers().stream().map(UserRestDto::new).collect(Collectors.toList());
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public UserRestDto byId(@PathVariable Integer id) {
        return new UserRestDto(userService.getUserById(id).orElse(new User()));
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public UserRestDto addUser(@Valid @RequestBody UserRestDto newUser) {
        return new UserRestDto(userService.addUser(User.fromRestDto(newUser)));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Integer id) {
        return Boolean.toString(userService.deleteUser(id));
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ValidationError handleException(MethodArgumentNotValidException exception) {
        return createValidationError(exception);
    }

    private ValidationError createValidationError(MethodArgumentNotValidException e) {
        return ValidationErrorBuilder.fromBindingErrors(e.getBindingResult());
    }
}
