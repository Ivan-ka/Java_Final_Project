package com.epam.winterJavaLab.task12.dao.interfaces;

import com.epam.winterJavaLab.task12.entity.Patient;
import com.epam.winterJavaLab.task12.entity.User;


public interface PatientDao {

    void addPatient(User user);

    Patient getPatient(String email);

}
