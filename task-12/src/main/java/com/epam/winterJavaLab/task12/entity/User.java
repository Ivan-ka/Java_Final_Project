package com.epam.winterJavaLab.task12.entity;

import com.epam.winterJavaLab.task12.constants.ConstantsValid;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class User {
    private Long id;

    @NotBlank(message = ConstantsValid.REQUIRED_NAME)
    @Size(min = 2, message = ConstantsValid.SIZE_NAME)
    private String name;

    @NotBlank(message = ConstantsValid.REQUIRED_SURNAME)
    @Size(min = 2, message = ConstantsValid.SIZE_SURNAME)
    private String surname;

    @NotBlank(message = ConstantsValid.REQUIRED_BIRTH)
    private String dateOfBirth;

    @NotBlank(message = ConstantsValid.REQUIRED_EMAIL)
    @Email
    private String email;

    @NotBlank(message = ConstantsValid.REQUIRED_PASSWORD)
    @Size(min = 5, message = ConstantsValid.SIZE_PASSWORD)
    private String password;

    @NotBlank(message = ConstantsValid.REQUIRED_PASSWORD)
    @Size(min = 5, message = ConstantsValid.SIZE_PASSWORD)
    private String passwordRepetition;

    private String checkGender;

    private String gender;

    private String checkRole;

    private String role;





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordRepetition() {
        return passwordRepetition;
    }

    public void setPasswordRepetition(String passwordRepetition) {
        this.passwordRepetition = passwordRepetition;
    }

    public String getCheckGender() {
        return checkGender;
    }

    public void setCheckGender(String checkGender) {
        this.checkGender = checkGender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCheckRole() {
        return checkRole;
    }

    public void setCheckRole(String checkRole) {
        this.checkRole = checkRole;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
