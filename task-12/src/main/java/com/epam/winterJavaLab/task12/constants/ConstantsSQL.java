package com.epam.winterJavaLab.task12.constants;


public class ConstantsSQL {

    public static final String ADDITION_APPOINTMENT = "INSERT INTO Hospital.Appointment (dat, doctorID, patientID, diagnosisID) " +
            "VALUES (?, " +
            "(SELECT id FROM Hospital.Doctor WHERE fullName = ?), " +
            "(SELECT id FROM Hospital.Patient WHERE email = ?), " +
            "(SELECT id FROM Hospital.Diagnosis WHERE name = ?))";

    public static final String ADDITION_FROM_BASKET = "INSERT INTO Hospital.Appointment (dat, doctorID, patientID, diagnosisID) " +
            "SELECT Hospital.Basket.dat, Hospital.Basket.doctorID, Hospital.Basket.patientID, Hospital.Basket.diagnosisID " +
            "FROM Hospital.Basket WHERE patientID = ?";

    public static final String RENOVATION_APPOINTMENT = "UPDATE Hospital.Appointment SET dat = ?, " +
            "doctorID = (SELECT id FROM Hospital.Doctor WHERE fullName = ?), " +
            "patientID = (SELECT id FROM Hospital.Patient WHERE email = ?), " +
            "diagnosisID = (SELECT id FROM Hospital.Diagnosis WHERE name = ?) " +
            "WHERE id = ?";

    public static final String RECEPTION_APPOINTMENT = "SELECT Hospital.Appointment.id, Hospital.Appointment.dat, Hospital.Doctor.fullName as doctor," +
            "Hospital.Patient.fullName as patient, Hospital.Diagnosis.name as diagnosis " +
            "FROM Hospital.Appointment " +
            "INNER JOIN Hospital.Doctor ON Hospital.Appointment.doctorID = Hospital.Doctor.id " +
            "INNER JOIN Hospital.Patient ON Hospital.Appointment.patientID = Hospital.Patient.id " +
            "INNER JOIN Hospital.Diagnosis ON Hospital.Appointment.diagnosisID = Hospital.Diagnosis.id " +
            "WHERE Hospital.Appointment.id = ?";

    public static final String REMOVAL_APPOINTMENT = "DELETE FROM Hospital.Appointment WHERE id = ?";

    public static final String REMOVAL_APPOINTMENT_BY_DATE = "DELETE FROM Hospital.Appointment WHERE dat < ?";

    public static final String RECEPTION_ALL_APPOINTMENTS = "SELECT Hospital.Appointment.id, Hospital.Appointment.dat, " +
            "Hospital.Doctor.fullName as doctor, Hospital.Patient.fullName as patient, Hospital.Diagnosis.name as diagnosis " +
            "FROM Hospital.Appointment " +
            "INNER JOIN Hospital.Doctor ON Hospital.Appointment.doctorID = Hospital.Doctor.id " +
            "INNER JOIN Hospital.Patient ON Hospital.Appointment.patientID = Hospital.Patient.id " +
            "INNER JOIN Hospital.Diagnosis ON Hospital.Appointment.diagnosisID = Hospital.Diagnosis.id ";

    public static final String RECEPTION_APPOINTMENTS_BY_PATIENT_ID = "SELECT Hospital.Appointment.id, Hospital.Appointment.dat, " +
            "Hospital.Doctor.fullName as doctor, Hospital.Patient.fullName as patient, Hospital.Diagnosis.name as diagnosis " +
            "FROM Hospital.Appointment " +
            "INNER JOIN Hospital.Doctor ON Hospital.Appointment.doctorID = Hospital.Doctor.id " +
            "INNER JOIN Hospital.Patient ON Hospital.Appointment.patientID = Hospital.Patient.id " +
            "INNER JOIN Hospital.Diagnosis ON Hospital.Appointment.diagnosisID = Hospital.Diagnosis.id " +
            "WHERE Hospital.Appointment.patientID = ?";

    public static final String ADDITION_BASKET_APPOINTMENT = "INSERT INTO Hospital.Basket (dat, doctorID, patientID, diagnosisID) " +
            "VALUES (?, " +
            "(SELECT id FROM Hospital.Doctor WHERE fullName = ?), " +
            "(SELECT id FROM Hospital.Patient WHERE email = ?), " +
            "(SELECT id FROM Hospital.Diagnosis WHERE name = ?))";

    public static final String RENOVATION_BASKET_APPOINTMENT = "UPDATE Hospital.Basket SET dat = ?, " +
            "doctorID = (SELECT id FROM Hospital.Doctor WHERE fullName = ?), " +
            "patientID = (SELECT id FROM Hospital.Patient WHERE email = ?), " +
            "diagnosisID = (SELECT id FROM Hospital.Diagnosis WHERE name = ?) " +
            "WHERE id = ?";

    public static final String RECEPTION_BASKET_APPOINTMENT = "SELECT Hospital.Basket.id, Hospital.Basket.dat, " +
            "Hospital.Doctor.fullName as doctor, Hospital.Patient.fullName as patient, Hospital.Diagnosis.name as diagnosis " +
            "FROM Hospital.Basket " +
            "INNER JOIN Hospital.Doctor ON Hospital.Basket.doctorID = Hospital.Doctor.id " +
            "INNER JOIN Hospital.Patient ON Hospital.Basket.patientID = Hospital.Patient.id " +
            "INNER JOIN Hospital.Diagnosis ON Hospital.Basket.diagnosisID = Hospital.Diagnosis.id " +
            "WHERE Hospital.Basket.id = ?";

    public static final String REMOVAL_BASKET_APPOINTMENT = "DELETE FROM Hospital.Basket WHERE id = ?";

    public static final String REMOVAL_BASKET_APPOINTMENT_BY_PATIENT_ID = "DELETE FROM Hospital.Basket WHERE patientID = ?";

    public static final String REMOVAL_BASKET_APPOINTMENT_BY_DATE = "DELETE FROM Hospital.Basket WHERE dat < ?";

    public static final String RECEPTION_ALL_BASKET_APPOINTMENTS = "SELECT Hospital.Basket.id, Hospital.Basket.dat, " +
            "Hospital.Doctor.fullName as doctor, Hospital.Patient.fullName as patient, Hospital.Diagnosis.name as diagnosis " +
            "FROM Hospital.Basket " +
            "INNER JOIN Hospital.Doctor ON Hospital.Basket.doctorID = Hospital.Doctor.id " +
            "INNER JOIN Hospital.Patient ON Hospital.Basket.patientID = Hospital.Patient.id " +
            "INNER JOIN Hospital.Diagnosis ON Hospital.Basket.diagnosisID = Hospital.Diagnosis.id ";

    public static final String RECEPTION_BASKET_APPOINTMENTS_BY_PATIENT_ID = "SELECT Hospital.Basket.id, Hospital.Basket.dat, " +
            "Hospital.Doctor.fullName as doctor, Hospital.Patient.fullName as patient, Hospital.Diagnosis.name as diagnosis " +
            "FROM Hospital.Basket " +
            "INNER JOIN Hospital.Doctor ON Hospital.Basket.doctorID = Hospital.Doctor.id " +
            "INNER JOIN Hospital.Patient ON Hospital.Basket.patientID = Hospital.Patient.id " +
            "INNER JOIN Hospital.Diagnosis ON Hospital.Basket.diagnosisID = Hospital.Diagnosis.id " +
            "WHERE Hospital.Basket.patientID = ?";

}
