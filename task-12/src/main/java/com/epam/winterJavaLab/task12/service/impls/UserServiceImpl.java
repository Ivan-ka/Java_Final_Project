package com.epam.winterJavaLab.task12.service.impls;

import com.epam.winterJavaLab.task12.dao.interfaces.UserDao;
import com.epam.winterJavaLab.task12.entity.User;
import com.epam.winterJavaLab.task12.enums.Gender;
import com.epam.winterJavaLab.task12.enums.Role;
import com.epam.winterJavaLab.task12.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private PasswordEncoder passwordEncoder;


    @Autowired
    public UserServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    @Transactional
    public void addUser(User user) {
        if (user.getCheckGender() != null) {
            user.setGender(Gender.MALE.name());
        } else {
            user.setGender(Gender.FEMALE.name());
        }


        if (user.getCheckRole() != null) {
            user.setRole(Role.ADMIN.name());
        } else {
            user.setRole(Role.USER.name());
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.addUser(user);
    }


    @Override
    public User getUser(String email) {
        return userDao.getUser(email);
    }


    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

}
