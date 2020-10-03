package com.epam.winterJavaLab.task12.dao.impls;

import com.epam.winterJavaLab.task12.dao.interfaces.DoctorDao;
import com.epam.winterJavaLab.task12.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class DoctorDaoImpl implements DoctorDao {

    private JdbcTemplate jdbcTemplate;


    @Autowired
    public DoctorDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    @Override
    public List<Doctor> getAllDoctors() {
        return jdbcTemplate.query("SELECT Hospital.Doctor.id, Hospital.Doctor.fullName, Hospital.Specialty.name as specialty, " +
                        "Hospital.Doctor.experience " +
                        "FROM Hospital.Doctor " +
                        "INNER JOIN Hospital.Specialty ON Hospital.Doctor.specialtyID = Hospital.Specialty.id ",
                new BeanPropertyRowMapper<>(Doctor.class));
    }

}
