package com.epam.winterJavaLab.task12.dao.impls;

import com.epam.winterJavaLab.task12.constants.ConstantsSQL;
import com.epam.winterJavaLab.task12.dao.interfaces.AppointmentDao;
import com.epam.winterJavaLab.task12.entity.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;


@Repository
public class AppointmentDaoImpl implements AppointmentDao {

    private JdbcTemplate jdbcTemplate;


    @Autowired
    public AppointmentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    @Override
    public void addAppointment(Appointment appointment, String email) {
        jdbcTemplate.update(ConstantsSQL.ADDITION_APPOINTMENT,
                appointment.getDat(), appointment.getDoctor(), email, appointment.getDiagnosis());
    }


    @Override
    public void addFromBasket(Long patientID) {
        jdbcTemplate.update(ConstantsSQL.ADDITION_FROM_BASKET, patientID);
    }


    @Override
    public void updateAppointment(Appointment appointment, String email) {
        jdbcTemplate.update(
                ConstantsSQL.RENOVATION_APPOINTMENT,
                appointment.getDat(), appointment.getDoctor(), email, appointment.getDiagnosis(), appointment.getId());
    }


    @Override
    public Appointment getAppointment(Long id) {
        return jdbcTemplate.query(
                ConstantsSQL.RECEPTION_APPOINTMENT,
                new Object[] { id },
                new BeanPropertyRowMapper<>(Appointment.class)).stream().findAny().orElse(null);
    }


    @Override
    public void deleteAppointment(Long id) {
        jdbcTemplate.update(ConstantsSQL.REMOVAL_APPOINTMENT, id);
    }


    @Override
    public void deleteAppointmentByDate(Date date) {
        jdbcTemplate.update(ConstantsSQL.REMOVAL_APPOINTMENT_BY_DATE, date);
    }


    @Override
    public List<Appointment> getAllAppointments() {
        return jdbcTemplate.query(ConstantsSQL.RECEPTION_ALL_APPOINTMENTS,
                new BeanPropertyRowMapper<>(Appointment.class));
    }


    @Override
    public List<Appointment> getAppointmentsByPatientId(Long patientID) {
        return jdbcTemplate.query(ConstantsSQL.RECEPTION_APPOINTMENTS_BY_PATIENT_ID,
                new Object[] { patientID },
                new BeanPropertyRowMapper<>(Appointment.class));
    }

}
