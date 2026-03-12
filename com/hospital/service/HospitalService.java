package com.hospital.service;

import com.hospital.patient.Patient;
import com.hospital.exception.PatientNotFoundException;
import java.io.*;

public class HospitalService {
  public void addPatient(Patient p) throws Exception {
    BufferedWriter bw = new BufferedWriter(new FileWriter("patients.txt", true));
    bw.write(p.getPatientId() + "," + p.getPatientName() + "," + p.getAge() + "," + p.getDisease());
    bw.newLine();
    bw.close();
  }

  public void searchPatient(String patientId) throws Exception {
    BufferedReader br = new BufferedReader(new FileReader("patients.txt"));
    String line;
    while ((line = br.readLine()) != null) {
      String[] d = line.split(",");
      if (d[0].equals(patientId)) {
        br.close();
        new Patient(d[0], d[1], d[2], d[3]).displayPatient();
        return;
      }
    }
    br.close();
    throw new PatientNotFoundException("Patient with ID " + patientId + " not found.");
  }

  public void displayPatients() throws Exception {
    BufferedReader br = new BufferedReader(new FileReader("patients.txt"));
    String line;
    while ((line = br.readLine()) != null) {
      String[] d = line.split(",");
      new Patient(d[0], d[1], d[2], d[3]).displayPatient();
    }
    br.close();
  }
}
