package com.hospital.main;

import com.hospital.patient.Patient;
import com.hospital.service.HospitalService;
import com.hospital.exception.InvalidAgeException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    HospitalService service = new HospitalService();

    System.out.print("Enter Patient ID: ");
    String id = sc.nextLine();
    System.out.print("Enter Patient Name: ");
    String name = sc.nextLine();
    System.out.print("Enter Age: ");
    String age = sc.nextLine();
    int ageVal = Integer.parseInt(age);
    if (ageVal < 0 || ageVal > 120)
      throw new InvalidAgeException("Invalid age: " + age);
    System.out.print("Enter Disease: ");
    String disease = sc.nextLine();

    service.addPatient(new Patient(id, name, age, disease));

    service.displayPatients();

    System.out.print("\nEnter Patient ID to search: ");
    service.searchPatient(sc.nextLine());
  }
}
