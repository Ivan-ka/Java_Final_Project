package com.epam.winterJavaLab.task12.dao.interfaces;

import com.epam.winterJavaLab.task12.entity.Appointment;

import java.sql.Date;
import java.util.List;


public interface BasketDao {

    void addBasketAppointment(Appointment appointment, String email);

    void updateBasketAppointment(Appointment appointment, String email);

    Appointment getBasketAppointment(Long id);

    void deleteBasketAppointment(Long id);

    void deleteBasketAppointmentByPatientId(Long patientID);

    void deleteBasketAppointmentByDate(Date date);

    List<Appointment> getAllBasketAppointments();

    List<Appointment> getBasketAppointmentsByPatientId(Long patientID);

}
