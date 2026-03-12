package com.hospital.service;

import com.hospital.patient.Patient;
import com.hospital.exception.PatientNotFoundException;
import java.io.*;

public class HospitalService {

    public void addPatient(Patient patient) throws Exception {
        FileWriter fw = new FileWriter("patients.txt", true);
        fw.write(patient.getPatientId() + "," + patient.getPatientName() + "," + patient.getAge() + "," + patient.getDisease());
        fw.write("\n");
        fw.close();
    }

    public void searchPatient(String patientId) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("patients.txt"));
        String line;
        boolean found = false;

        while ((line = br.readLine()) != null) {
            String arr[] = line.split(",");

            if (arr[0].equals(patientId)) {
                Patient patient = new Patient(arr[0], arr[1], arr[2], arr[3]);
                patient.displayPatient();
                found = true;
                break;
            }
        }

        br.close();

        if (found == false) {
            throw new PatientNotFoundException("Patient not found");
        }
    }

    public void displayPatients() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("patients.txt"));
        String line;

        while ((line = br.readLine()) != null) {
            String arr[] = line.split(",");
            Patient patient = new Patient(arr[0], arr[1], arr[2], arr[3]);
            patient.displayPatient();
        }

        br.close();
    }
}
