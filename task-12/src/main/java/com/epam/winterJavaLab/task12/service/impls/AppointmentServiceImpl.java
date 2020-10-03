package com.epam.winterJavaLab.task12.service.impls;

import com.epam.winterJavaLab.task12.dao.interfaces.AppointmentDao;
import com.epam.winterJavaLab.task12.entity.Appointment;
import com.epam.winterJavaLab.task12.service.interfaces.AppointmentService;
import com.epam.winterJavaLab.task12.service.interfaces.BasketService;
import com.epam.winterJavaLab.task12.util.PatientRecipient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;


@Service
@Transactional(readOnly = true)
public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentDao appointmentDao;
    private PatientRecipient patientRecipient;
    private BasketService basketService;


    @Autowired
    public AppointmentServiceImpl(AppointmentDao appointmentDao, PatientRecipient patientRecipient, BasketService basketService) {
        this.appointmentDao = appointmentDao;
        this.patientRecipient = patientRecipient;
        this.basketService = basketService;
    }



    @Override
    @Transactional
    public void addAppointment(Appointment appointment) {
        appointmentDao.addAppointment(appointment, patientRecipient.getPatientFromDB().getEmail());
    }


    @Transactional
    @Override
    public void addFromBasket() {
        Long patientID = patientRecipient.getPatientFromDB().getId();
        appointmentDao.addFromBasket(patientID);
        basketService.deleteBasketAppointmentByPatientId(patientID);
    }


    @Override
    @Transactional
    public void updateAppointment(Appointment appointment) {
        appointmentDao.updateAppointment(appointment, patientRecipient.getPatientFromDB().getEmail());
    }


    @Override
    public Appointment getAppointment(Long id) {
        return  appointmentDao.getAppointment(id);
    }


    @Override
    @Transactional
    public void deleteAppointment(Long id) {
        appointmentDao.deleteAppointment(id);
    }


    @Override
    @Transactional
    public void deleteAppointmentByDate(Date date) {
        appointmentDao.deleteAppointmentByDate(date);
    }


    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentDao.getAllAppointments();
    }


    @Override
    public List<Appointment> getAppointmentsByPatientId() {
        return appointmentDao.getAppointmentsByPatientId(patientRecipient.getPatientFromDB().getId());
    }

}
