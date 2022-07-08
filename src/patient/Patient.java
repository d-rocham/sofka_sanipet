package patient;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Patient {

    private PatientType patientType;
    private final String historyNumber;
    private String name;
    private String breed;
    private String owner;
    private boolean vaccine_status;

    private List<Appointment> appointments;

    public void setAppointments(Appointment newAppointment) {
        this.appointments.add(newAppointment);
    }



    public Patient(PatientType patientType, String name, String breed, String owner, boolean vaccine_status) {
        this.patientType = patientType;
        this.name = name;
        this.breed = breed;
        this.owner = owner;
        this.vaccine_status = vaccine_status;
        this.historyNumber = generateHistoryNumber();
        this.appointments = new ArrayList<Appointment>();

    }

    public PatientType getPatientType() {
        return patientType;
    }

    public void setPatientType(PatientType patientType) {
        this.patientType = patientType;
    }

    public String getHistoryNumber() {
        return historyNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean isVaccine_status() {
        return vaccine_status;
    }

    public void setVaccine_status(boolean vaccine_status) {
        this.vaccine_status = vaccine_status;
    }

    private String generateHistoryNumber() {
        return String.valueOf(ThreadLocalRandom.current().nextInt(1, 999999 + 1));
    }

}