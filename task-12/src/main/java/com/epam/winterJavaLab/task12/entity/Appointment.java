package com.epam.winterJavaLab.task12.entity;

import com.epam.winterJavaLab.task12.constants.ConstantsValid;

import javax.validation.constraints.NotBlank;


public class Appointment {
    private Long id;

    @NotBlank(message = ConstantsValid.REQUIRED_DATE)
    private String dat;

    @NotBlank(message = ConstantsValid.REQUIRED_DOCTOR)
    private String doctor;

    private String patient;

    @NotBlank(message = ConstantsValid.REQUIRED_DIAGNOSIS)
    private String diagnosis;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDat() {
        return dat;
    }

    public void setDat(String dat) {
        this.dat = dat;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

}
