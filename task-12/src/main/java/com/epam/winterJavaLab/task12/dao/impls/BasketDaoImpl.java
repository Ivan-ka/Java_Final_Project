package com.epam.winterJavaLab.task12.dao.impls;

import com.epam.winterJavaLab.task12.constants.ConstantsSQL;
import com.epam.winterJavaLab.task12.dao.interfaces.BasketDao;
import com.epam.winterJavaLab.task12.entity.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;


@Repository
public class BasketDaoImpl implements BasketDao {

    private JdbcTemplate jdbcTemplate;


    @Autowired
    public BasketDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    @Override
    public void addBasketAppointment(Appointment appointment, String email) {
        jdbcTemplate.update(ConstantsSQL.ADDITION_BASKET_APPOINTMENT,
                appointment.getDat(), appointment.getDoctor(), email, appointment.getDiagnosis());
    }


    @Override
    public void updateBasketAppointment(Appointment appointment, String email) {
        jdbcTemplate.update(ConstantsSQL.RENOVATION_BASKET_APPOINTMENT,
                appointment.getDat(), appointment.getDoctor(), email, appointment.getDiagnosis(), appointment.getId());
    }


    @Override
    public Appointment getBasketAppointment(Long id) {
        return jdbcTemplate.query(ConstantsSQL.RECEPTION_BASKET_APPOINTMENT,
                new Object[] { id },
                new BeanPropertyRowMapper<>(Appointment.class)).stream().findAny().orElse(null);
    }


    @Override
    public void deleteBasketAppointment(Long id) {
        jdbcTemplate.update(ConstantsSQL.REMOVAL_BASKET_APPOINTMENT, id);
    }


    @Override
    public void deleteBasketAppointmentByPatientId(Long patientID) {
        jdbcTemplate.update(ConstantsSQL.REMOVAL_BASKET_APPOINTMENT_BY_PATIENT_ID, patientID);
    }


    @Override
    public void deleteBasketAppointmentByDate(Date date) {
        jdbcTemplate.update(ConstantsSQL.REMOVAL_BASKET_APPOINTMENT_BY_DATE, date);
    }


    @Override
    public List<Appointment> getAllBasketAppointments() {
        return jdbcTemplate.query(ConstantsSQL.RECEPTION_ALL_BASKET_APPOINTMENTS,
                new BeanPropertyRowMapper<>(Appointment.class));
    }


    @Override
    public List<Appointment> getBasketAppointmentsByPatientId(Long patientID) {
        return jdbcTemplate.query(ConstantsSQL.RECEPTION_BASKET_APPOINTMENTS_BY_PATIENT_ID,
                new Object[] { patientID },
                new BeanPropertyRowMapper<>(Appointment.class));
    }

}
