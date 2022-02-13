package com.model;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;

/**
 * Represent a user data. Initially the internal {@link Municipality} data isn't present.
 */
public class User extends DataWithCodeAbstract{

    private String gender;

    private Date dateOfBirth;

    private String municipalityCode;

    public User() { };

    public User(String code, String gender, Date dateOfBirth, String municipalityCode, Optional<Municipality> municipalityOpt) {
        super(code);
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.municipalityCode = municipalityCode;
        this.municipalityOpt = municipalityOpt;
    }

    private Optional<Municipality> municipalityOpt;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Optional<Municipality> getMunicipalityOpt() {
        return municipalityOpt;
    }

    public void setMunicipalityOpt(Optional<Municipality> municipalityOpt) {
        this.municipalityOpt = municipalityOpt;
    }

    public String getMunicipalityCode() {
        return municipalityCode;
    }

    public void setMunicipalityCode(String municipalityCode) {
        this.municipalityCode = municipalityCode;
    }

    public int getAge(){
        Calendar userDateOfBorn = new GregorianCalendar();
        userDateOfBorn.setTime(this.dateOfBirth);
        Calendar today = Calendar.getInstance();
        return today.get(Calendar.YEAR) - userDateOfBorn.get(Calendar.YEAR);
    }

}
