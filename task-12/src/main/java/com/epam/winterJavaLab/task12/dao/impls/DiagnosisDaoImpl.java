package com.epam.winterJavaLab.task12.dao.impls;

import com.epam.winterJavaLab.task12.dao.interfaces.DiagnosisDao;
import com.epam.winterJavaLab.task12.entity.Diagnosis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class DiagnosisDaoImpl implements DiagnosisDao {

    private JdbcTemplate jdbcTemplate;


    @Autowired
    public DiagnosisDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    @Override
    public List<Diagnosis> getAllDiagnoses() {
        return jdbcTemplate.query("SELECT * FROM Hospital.Diagnosis", new BeanPropertyRowMapper<>(Diagnosis.class));
    }

}
