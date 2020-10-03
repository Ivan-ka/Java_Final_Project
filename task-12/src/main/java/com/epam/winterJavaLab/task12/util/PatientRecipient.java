package com.epam.winterJavaLab.task12.util;

import com.epam.winterJavaLab.task12.entity.Patient;
import com.epam.winterJavaLab.task12.entity.User;
import com.epam.winterJavaLab.task12.service.interfaces.PatientService;
import com.epam.winterJavaLab.task12.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


@Component
public class PatientRecipient {

    private PatientService patientService;
    private UserService userService;


    @Autowired
    public PatientRecipient(PatientService patientService, UserService userService) {
        this.patientService = patientService;
        this.userService = userService;
    }



    public Patient getPatientFromDB() {
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        Patient patient = patientService.getPatient(userEmail);

        if (patient == null) {
            User user = userService.getUser(userEmail);
            patientService.addPatient(user);
            patient = patientService.getPatient(userEmail);
        }

        return patient;
    }

}
