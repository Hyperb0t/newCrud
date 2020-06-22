package ru.itis.userscrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.itis.userscrud.dto.UserRegFormDto;
import ru.itis.userscrud.logging.LocalePrinter;
import ru.itis.userscrud.models.User;
import ru.itis.userscrud.services.UserService;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private LocalePrinter localePrinter;

    @GetMapping
    public String registerGet(ModelMap map) {
        System.out.println(localePrinter.print("test.message", Locale.forLanguageTag("ru-RU")));
        map.put("user", new UserRegFormDto());
        return "register";
    }

    @PostMapping
    public String registerPost(RedirectAttributes redirectAttributes,
                               @Valid @ModelAttribute("user") UserRegFormDto userRegFormDto,
                               BindingResult result) {
        if(result.hasErrors()) {
            return "register";
        }
        else {
            User user = userService.registerUser(userRegFormDto);
            return "redirect: " + MvcUriComponentsBuilder.fromMappingName("ULC#getUsers").build();
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

}
