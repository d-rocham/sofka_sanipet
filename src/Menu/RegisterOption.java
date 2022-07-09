package Menu;
import patient.Patient;
import patient.PatientType;
import person.Owner;

import java.util.Arrays;
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
        MenuScanner createPatientScanner = new MenuScanner();

        List<String> patientTypes = Arrays.asList("Cat", "Dog");
        String menuTitle = "Type of patient:";

        int patientType = createPatientScanner.optionsScanner(menuTitle, patientTypes);

        Scanner patientScanner = new Scanner(System.in);
        System.out.println("New patient name:");
        String name = patientScanner.nextLine();
        System.out.println("New patient breed:");
        String breed = patientScanner.nextLine();
        System.out.println("New patient owner:");
        String owner = patientScanner.nextLine();

        List<String> vaccinationStatusList = Arrays.asList("Yes", "No");
        menuTitle = "Is the pacient vaccinated ?";

        int vaccinationStatus = createPatientScanner.optionsScanner(menuTitle, vaccinationStatusList);

        Patient newPatient = new Patient(patientType == 0 ? PatientType.CAT : PatientType.DOG, name, breed, owner, vaccinationStatus == 0 ? true : false);
        sessionPatients.add(newPatient);
        System.out.println("Patient successfully created!");
        return;

    }
}
