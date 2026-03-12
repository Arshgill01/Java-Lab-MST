package com.hospital.patient;

public class Patient {
    private String patientId;
    private String patientName;
    private String age;
    private String disease;

    public Patient(String patientId, String patientName, String age, String disease) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.age = age;
        this.disease = disease;
    }

    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }
    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }
    public String getAge() { return age; }
    public void setAge(String age) { this.age = age; }
    public String getDisease() { return disease; }
    public void setDisease(String disease) { this.disease = disease; }

    public void displayPatient() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Patient Name: " + patientName);
        System.out.println("Age: " + age);
        System.out.println("Disease: " + disease);
    }
}
