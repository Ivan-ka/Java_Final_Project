package com.epam.winterJavaLab.task12.dao.interfaces;

import com.epam.winterJavaLab.task12.entity.User;

import java.util.List;


public interface UserDao {

    void addUser(User user);

    User getUser(String email);

    List<User> getAllUsers();

}
