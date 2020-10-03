package com.epam.winterJavaLab.task12.dao.impls;

import com.epam.winterJavaLab.task12.dao.interfaces.UserDao;
import com.epam.winterJavaLab.task12.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;


    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    @Override
    public void addUser(User user) {
        jdbcTemplate.update(
                "INSERT INTO Users (name, surname, dateOfBirth, gender, email, role, password) VALUES (?, ?, ?, ?, ?, ?, ?)",
                user.getName(), user.getSurname(), user.getDateOfBirth(), user.getGender(), user.getEmail(), user.getRole(),
                user.getPassword());
    }


    @Override
    public User getUser(String email) {
        return jdbcTemplate.query(
                "SELECT * FROM Users WHERE email = ?",
                new Object[] { email },
                new BeanPropertyRowMapper<>(User.class)
        ).stream().findAny().orElse(null);
    }


    @Override
    public List<User> getAllUsers() {
        return jdbcTemplate.query("SELECT * FROM Users", new BeanPropertyRowMapper<>(User.class));
    }

}
