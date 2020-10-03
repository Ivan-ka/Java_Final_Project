package com.epam.winterJavaLab.task12.controller;

import com.epam.winterJavaLab.task12.constants.ConstantsView;
import com.epam.winterJavaLab.task12.entity.User;

import com.epam.winterJavaLab.task12.service.interfaces.AppointmentService;
import com.epam.winterJavaLab.task12.service.interfaces.BasketService;
import com.epam.winterJavaLab.task12.service.interfaces.UserService;

import com.epam.winterJavaLab.task12.util.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;


@Controller
@RequestMapping(ConstantsView.SLASH)
public class UserController {

    private static Date date = new Date(System.currentTimeMillis());

    private UserService userService;
    private UserValidator userValidator;
    private AppointmentService appointmentService;
    private BasketService basketService;


    @Autowired
    public UserController(UserService userService, UserValidator userValidator, AppointmentService appointmentService, BasketService basketService) {
        this.userService = userService;
        this.userValidator = userValidator;
        this.appointmentService = appointmentService;
        this.basketService = basketService;
    }



    @GetMapping(ConstantsView.SLASH)
    public String index() {
        appointmentService.deleteAppointmentByDate(date);
        basketService.deleteBasketAppointmentByDate(date);
        return ConstantsView.INDEX_TEMPLATE;
    }


    @GetMapping(ConstantsView.REGISTER_PATH)
    public String getRegister(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("currentDate", date);
        return ConstantsView.REGISTER_TEMPLATE;
    }


    @PostMapping(ConstantsView.REGISTER_PATH)
    public String getRegisterForm(@ModelAttribute @Valid User user, BindingResult result, Model model) {
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            model.addAttribute("currentDate", date);
            return ConstantsView.REGISTER_TEMPLATE;
        }
        userService.addUser(user);
        return ConstantsView.PROFILE_PATH_WITH_REDIRECT;
    }


    @GetMapping(ConstantsView.USERS_PATH)
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return ConstantsView.USERS_TEMPLATE;
    }


    @RequestMapping(ConstantsView.LOGIN_PATH)
    public String getLogin(@RequestParam(name = "error", required = false) Boolean error, Model model) {
        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", true);
        }
        return ConstantsView.LOGIN_TEMPLATE;
    }

}
