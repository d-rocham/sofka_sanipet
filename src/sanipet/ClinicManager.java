package sanipet;

import medicine.medicine;
import patient.Patient;
import person.Employee;

import java.util.ArrayList;
import java.util.List;

public class ClinicManager {
    List<Patient> patients;
    List<medicine> medicines;
    List<Employee> personnel;

    // TODO: how to implement schedule?

    public ClinicManager() {
        this.patients = new ArrayList<>();
        this.medicines = new ArrayList<>();
        this.personnel = new ArrayList<>();
    }
}
