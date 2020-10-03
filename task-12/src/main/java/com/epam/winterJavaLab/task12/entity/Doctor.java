package com.epam.winterJavaLab.task12.entity;


public class Doctor extends User {

    private String fullName;

    private String specialty;

    private String experience;



    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }


    @Override
    public String toString() {
        return fullName;
    }

}
