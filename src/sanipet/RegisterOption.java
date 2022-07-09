package sanipet;
import patient.Patient;
import patient.PatientType;
import person.Owner;

import java.util.List;
import java.util.Scanner;

public class RegisterOption extends MenuOption {

    public RegisterOption(int optionID, String optionDescription) {
        super(optionID, optionDescription);
    }

    void optionAction(List<Patient> sessionPatients, List<Owner> sessionOwners) {
        if(sessionOwners.size() == 0) {
            System.out.println("An owner must be created first!");
            createOwner(sessionOwners);
        }
        else {
            int newOwner = 0;
            Scanner createNewOwnerScanner = new Scanner(System.in);
            while (newOwner != 1 && newOwner != 2){
                System.out.println("Would you like to create a new owner for this pet, or use an existing one?");
                System.out.println("    1. New");
                System.out.println("    2. Existing");

                newOwner = Integer.parseInt(createNewOwnerScanner.nextLine());
            }

            if (newOwner == 1) {
                createOwner(sessionOwners);
            }
        }
        createPatient(sessionPatients);
        return;

    }

    private void createOwner(List<Owner> sessionOwners) {
        Scanner ownerScanner = new Scanner(System.in);
        System.out.println("New owner DNI:");
        String DNI = ownerScanner.nextLine();
        System.out.println("New owner name:");
        String name = ownerScanner.nextLine();
        System.out.println("New owner surname:");
        String surname = ownerScanner.nextLine();
        System.out.println("New owner cellphone:");
        String cellphone = ownerScanner.nextLine();
        int age = 0;
        while (age < 18) {
            System.out.println("New owner age (must be over 18):");
            age = Integer.parseInt(ownerScanner.nextLine());
        }
        Owner newOwner = new Owner(DNI, name, surname, cellphone, age);
        sessionOwners.add(newOwner);
        System.out.println("Owner successfully created!");

        return;
    }

    private void createPatient(List<Patient> sessionPatients) {
        Scanner patientScanner = new Scanner(System.in);
        int patientType = 0;
        while (patientType != 1 && patientType != 2) {
            System.out.println("New patient type:");
            System.out.println("    1. Cat");
            System.out.println("    2. Dog");

            patientType = Integer.parseInt(patientScanner.nextLine());
        }
        System.out.println("New patient name:");
        String name = patientScanner.nextLine();
        System.out.println("New patient breed:");
        String breed = patientScanner.nextLine();
        System.out.println("New patient owner:");
        String owner = patientScanner.nextLine();
        int vaccinationStatusChoice = 3;
        boolean vaccinationStatus;
        while (vaccinationStatusChoice != 1 && vaccinationStatusChoice != 2){
            System.out.printf("Is %s vaccinated?%n", name);
            System.out.println("    1. Yes");
            System.out.println("    2. No");

            vaccinationStatusChoice = Integer.parseInt(patientScanner.nextLine());
        }
        if (vaccinationStatusChoice == 1) {
            vaccinationStatus = true;
        }
        else {
            vaccinationStatus = false;
        }

        Patient newPatient = new Patient(patientType == 1 ? PatientType.CAT : PatientType.DOG, name, breed, owner, vaccinationStatus);
        sessionPatients.add(newPatient);
        System.out.println("Patient successfully created!");
        return;

    }
}
