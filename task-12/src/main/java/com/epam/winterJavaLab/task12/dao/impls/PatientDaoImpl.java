package com.epam.winterJavaLab.task12.dao.impls;

import com.epam.winterJavaLab.task12.dao.interfaces.PatientDao;
import com.epam.winterJavaLab.task12.entity.Patient;
import com.epam.winterJavaLab.task12.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class PatientDaoImpl implements PatientDao {

    private JdbcTemplate jdbcTemplate;


    @Autowired
    public PatientDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    @Override
    public void addPatient(User user) {
        jdbcTemplate.update(
                "INSERT INTO Hospital.Patient (fullName, dateOfBirth, gender, email) VALUES (?, ?, ?, ?)",
                user.getName() + " " + user.getSurname(), user.getDateOfBirth(), user.getGender(), user.getEmail());
    }


    @Override
    public Patient getPatient(String email) {
        return jdbcTemplate.query(
                "SELECT * FROM Hospital.Patient WHERE email = ?",
                new Object[] { email },
                new BeanPropertyRowMapper<>(Patient.class)
        ).stream().findAny().orElse(null);
    }

}
