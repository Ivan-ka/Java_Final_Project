package com.epam.winterJavaLab.task12.service.impls;

import com.epam.winterJavaLab.task12.dao.interfaces.AppointmentDao;
import com.epam.winterJavaLab.task12.dao.interfaces.BasketDao;
import com.epam.winterJavaLab.task12.entity.Appointment;
import com.epam.winterJavaLab.task12.service.interfaces.BasketService;
import com.epam.winterJavaLab.task12.util.PatientRecipient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;


@Service
@Transactional(readOnly = true)
public class BasketServiceImpl implements BasketService {

    private BasketDao basketDao;
    private AppointmentDao appointmentDao;
    private PatientRecipient patientRecipient;


    @Autowired
    public BasketServiceImpl(BasketDao basketDao, AppointmentDao appointmentDao, PatientRecipient patientRecipient) {
        this.basketDao = basketDao;
        this.appointmentDao = appointmentDao;
        this.patientRecipient = patientRecipient;
    }



    @Override
    @Transactional
    public void addBasketAppointment(Appointment appointment) {
        basketDao.addBasketAppointment(appointment, patientRecipient.getPatientFromDB().getEmail());
    }


    @Override
    @Transactional
    public void updateBasketAppointment(Appointment appointment) {
        basketDao.updateBasketAppointment(appointment, patientRecipient.getPatientFromDB().getEmail());
    }


    @Override
    public Appointment getBasketAppointment(Long id) {
        return basketDao.getBasketAppointment(id);
    }


    @Override
    @Transactional
    public void deleteBasketAppointment(Long id) {
        basketDao.deleteBasketAppointment(id);
    }


    @Transactional
    @Override
    public void deleteBasketAppointmentByPatientId(Long patientID) {
        basketDao.deleteBasketAppointmentByPatientId(patientID);
    }


    @Transactional
    @Override
    public void deleteBasketAppointmentByDate(Date date) {
        basketDao.deleteBasketAppointmentByDate(date);
    }


    @Override
    public List<Appointment> getAllBasketAppointments() {
        return  basketDao.getAllBasketAppointments();
    }


    @Override
    public List<Appointment> getBasketAppointmentsByPatientId() {
        return basketDao.getBasketAppointmentsByPatientId(patientRecipient.getPatientFromDB().getId());
    }


    @Override
    public int findDateMatch(String date) {
        int coincidencesNumber = 0;
        List<Appointment> appointmentsList = appointmentDao.getAppointmentsByPatientId(patientRecipient.getPatientFromDB().getId());
        List<Appointment> basketAppointmentsList = basketDao.getBasketAppointmentsByPatientId(patientRecipient.getPatientFromDB().getId());

        for (Appointment appointment : appointmentsList) {
            if (appointment.getDat().equals(date)) {
                coincidencesNumber++;
            }
        }

        for (Appointment basketAppointment : basketAppointmentsList) {
            if (basketAppointment.getDat().equals(date)) {
                coincidencesNumber++;
            }
        }

        return coincidencesNumber;
    }


    @Override
    public int findDoctorMatch(String date, String doctor) {
        int coincidencesNumber = 0;
        List<Appointment> appointmentsList = appointmentDao.getAllAppointments();
        List<Appointment> basketAppointmentsList = basketDao.getAllBasketAppointments();

        for (Appointment appointment : appointmentsList) {
            if (appointment.getDat().equals(date) && appointment.getDoctor().equals(doctor)) {
                    coincidencesNumber++;
            }
        }

        for (Appointment basketAppointment : basketAppointmentsList) {
            if (basketAppointment.getDat().equals(date) && basketAppointment.getDoctor().equals(doctor)) {
                coincidencesNumber++;
            }
        }

        return coincidencesNumber;
    }

}
