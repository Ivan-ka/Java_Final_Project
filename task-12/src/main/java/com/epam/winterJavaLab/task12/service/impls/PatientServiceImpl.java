package com.epam.winterJavaLab.task12.service.impls;

import com.epam.winterJavaLab.task12.dao.interfaces.PatientDao;
import com.epam.winterJavaLab.task12.entity.Patient;
import com.epam.winterJavaLab.task12.entity.User;
import com.epam.winterJavaLab.task12.service.interfaces.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
public class PatientServiceImpl implements PatientService {

    private PatientDao patientDao;


    @Autowired
    public PatientServiceImpl(PatientDao patientDao) {
        this.patientDao = patientDao;
    }


    @Override
    @Transactional
    public void addPatient(User user) {
        patientDao.addPatient(user);
    }


    @Override
    public Patient getPatient(String email) {
        return patientDao.getPatient(email);
    }

}
