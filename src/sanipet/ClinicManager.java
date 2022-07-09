package sanipet;


import Medicine.Medicine;
import patient.Appointment;
import patient.Bill;
import patient.Patient;
import person.Employee;
import person.Owner;

import java.util.ArrayList;
import java.util.List;

public class ClinicManager {

    public List<Patient> patients;
    public List<Medicine> medicines;
    public List<Employee> personnel;
    public List <Appointment> appointments;
    public List<Owner> owners;

    public List<Bill> bills;

    public ClinicManager() {
        this.patients = new ArrayList<>();
        this.medicines = new ArrayList<>();
        this.personnel = new ArrayList<>();
        this.appointments = new ArrayList<>();
        this.owners = new ArrayList<>();
        this.bills = new ArrayList<>();
    }

    public List<String> getPatientsAsString() {
        List<String> patientsNames = new ArrayList<String>();

        for (Patient patient : patients) {
            patientsNames.add(patient.getName());
        }

        return patientsNames;
    }

    public List<String> getAppointmentsNames() {
        List<String> appointmentsNames = new ArrayList<String>();

        for (Appointment appointment: appointments) {
            appointmentsNames.add(appointment.appointmentName);
        }

        return appointmentsNames;

    }

    public List<String> getMedicinesNames() {
        List<String> medicineNames = new ArrayList<String>();

        for (Medicine medicine: medicines) {
            medicineNames.add(medicine.name);
        }

        return medicineNames;

    }

    public List<String> getAppointmentsWithCost() {
        List<String> appointmentsWithCosts = new ArrayList<>();

        for (Appointment appointment: appointments) {
            appointmentsWithCosts.add(String.format("%s.......... %d", appointment.appointmentName, appointment.cost));
        }

        return appointmentsWithCosts;
    }

    public List<String> getMedicinesWithCost() {
        List<String> medicinesWithCost = new ArrayList<>();

        for (Medicine medicine: medicines) {
            medicinesWithCost.add(String.format("%s.......... %d", medicine.name, medicine.cost));
        }

        return medicinesWithCost;
    }
}
