package com.epam.winterJavaLab.task12.service.interfaces;

import com.epam.winterJavaLab.task12.entity.Appointment;

import java.sql.Date;
import java.util.List;


public interface BasketService {

    void addBasketAppointment(Appointment appointment);

    void updateBasketAppointment(Appointment appointment);

    Appointment getBasketAppointment(Long id);

    void deleteBasketAppointment(Long id);

    void deleteBasketAppointmentByPatientId(Long patientID);

    void deleteBasketAppointmentByDate(Date date);

    List<Appointment> getAllBasketAppointments();

    List<Appointment> getBasketAppointmentsByPatientId();

    int findDateMatch(String date);

    int findDoctorMatch(String date, String doctor);

}
