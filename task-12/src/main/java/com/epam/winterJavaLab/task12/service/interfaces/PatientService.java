package com.epam.winterJavaLab.task12.service.interfaces;

import com.epam.winterJavaLab.task12.entity.Patient;
import com.epam.winterJavaLab.task12.entity.User;


public interface PatientService {

    void addPatient(User user);

    Patient getPatient(String email);

}
