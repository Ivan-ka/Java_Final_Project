package com.epam.winterJavaLab.task12.service.interfaces;

import com.epam.winterJavaLab.task12.entity.Appointment;

import java.sql.Date;
import java.util.List;


public interface AppointmentService {

    void addAppointment(Appointment appointment);

    void addFromBasket();

    void updateAppointment(Appointment appointment);

    Appointment getAppointment(Long id);

    void deleteAppointment(Long id);

    void deleteAppointmentByDate(Date date);

    List<Appointment> getAllAppointments();

    List<Appointment> getAppointmentsByPatientId();

}
