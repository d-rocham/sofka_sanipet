package sanipet;


import Medicine.Medicine;
import patient.Appointment;
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

    // TODO: how to implement schedule?

    public ClinicManager() {
        this.patients = new ArrayList<>();
        this.medicines = new ArrayList<>();
        this.personnel = new ArrayList<>();
        this.appointments = new ArrayList<>();
        this.owners = new ArrayList<>();
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
}
