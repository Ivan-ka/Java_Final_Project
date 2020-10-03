package com.epam.winterJavaLab.task12.util;

import com.epam.winterJavaLab.task12.constants.ConstantsValid;
import com.epam.winterJavaLab.task12.entity.User;
import com.epam.winterJavaLab.task12.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class UserValidator implements Validator {

    private UserService userService;


    @Autowired
    public UserValidator(UserService userService) {
        this.userService = userService;
    }



    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }


    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (userService.getUser(user.getEmail()) != null) {
            errors.rejectValue("email", "", ConstantsValid.EMAIL_EXISTS);
        }

        if (!user.getPassword().equals(user.getPasswordRepetition())) {
            errors.rejectValue("passwordRepetition", "", ConstantsValid.PASSWORD_MISMATCH);
        }
    }

}
