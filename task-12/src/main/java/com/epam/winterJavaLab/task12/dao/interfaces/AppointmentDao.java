package com.epam.winterJavaLab.task12.dao.interfaces;

import com.epam.winterJavaLab.task12.entity.Appointment;

import java.sql.Date;
import java.util.List;


public interface AppointmentDao {

    void addAppointment(Appointment appointment, String email);

    void addFromBasket(Long patientID);

    void updateAppointment(Appointment appointment, String email);

    Appointment getAppointment(Long id);

    void deleteAppointment(Long id);

    void deleteAppointmentByDate(Date date);

    List<Appointment> getAllAppointments();

    List<Appointment> getAppointmentsByPatientId(Long patientID);

}
