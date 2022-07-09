package Menu;

import patient.Appointment;
import patient.Patient;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AppointmentsOption extends MenuOption {

    List<String> workingDays = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");

    List<String> workingHours = Arrays.asList("8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00");

    List <String> appointmentStatus = Arrays.asList("Not started", "Cancelled", "Finished", "Absent");

    public AppointmentsOption(int optionID, String optionDescription) {
        super(optionID, optionDescription);
    }

    void optionAction(List<String> sessionPatientsNames,List<String> appointmentsNames ,List<Appointment> sessionAppointments) {
        if (sessionPatientsNames.size() == 0) {
            System.out.println("There are no patients logged in the system. Create one prior to managing appointments.");
        }
        else {
            MenuScanner manageAppointmentsScanner = new MenuScanner();
            String appointmentsScannerTitle = "What action will you perform?";
            List<String> appointmentsScannerOptions = Arrays.asList("Create new appointment.", "Update existing appointment.", "Filter by day.");

            int selectedAction = manageAppointmentsScanner.optionsScanner(appointmentsScannerTitle, appointmentsScannerOptions);

            if (selectedAction == 0) {
                createAppointment(sessionPatientsNames, sessionAppointments);
            }
            else if (selectedAction == 1) {
                updateAppointment(appointmentsNames,sessionAppointments);
            }

            else {
                // Filter by day
            }

        }
        return;
    }

    void createAppointment(List<String> sessionPatientsNames, List<Appointment> sessionAppointments) {
        MenuScanner createAppointmentScanner = new MenuScanner();

        String createAppointmentTitle = "Choose a patient to create an appointment for:";

        int chosenPatient = createAppointmentScanner.optionsScanner(createAppointmentTitle, sessionPatientsNames);

        System.out.printf("Creating appointment for %s\n", sessionPatientsNames.get(chosenPatient));

        createAppointmentTitle = "Choose the appointment type:";

        List<String> appointmentTypes = Arrays.asList("Medical.", "Surgery.", "Aesthetic.");

        int chosenAppointmentType = createAppointmentScanner.optionsScanner(createAppointmentTitle, appointmentTypes);

        createAppointmentTitle = "Choose the appointment day:";

        int chosenDay = createAppointmentScanner.optionsScanner(createAppointmentTitle, workingDays);

        createAppointmentTitle = "Choose the appointment hour:";

        int chosenHour = createAppointmentScanner.optionsScanner(createAppointmentTitle, workingHours);

        Appointment newAppointment = new Appointment(appointmentTypes.get(chosenAppointmentType), appointmentStatus.get(0), workingDays.get(chosenDay), workingHours.get(chosenHour), String.format("%s - %s", sessionPatientsNames.get(chosenPatient), appointmentTypes.get(chosenAppointmentType)));

        sessionAppointments.add(newAppointment);

        System.out.printf("Appointment scheduled for %s on %s, %s\n", sessionPatientsNames.get(chosenPatient), workingDays.get(chosenDay), workingHours.get(chosenHour));

        return;
    }

    void updateAppointment(List<String>appointmentsNames, List<Appointment> sessionAppointments) {
        if (sessionAppointments.size() == 0) {
            System.out.println("No appointments in system. Create an appointment first.");
        }
        else {
            MenuScanner editAppointmentsScanner = new MenuScanner();

            String editAppointmentsTitle = "Choose an appointment to update:";

            int chosenAppointment = editAppointmentsScanner.optionsScanner(editAppointmentsTitle, appointmentsNames);

            editAppointmentsTitle = "What would you like to do?";

            List<String> editionOptions = Arrays.asList("Change appointment status.", "Change appointment date.");

            int chosenEditionOption = editAppointmentsScanner.optionsScanner(editAppointmentsTitle, editionOptions);

            Appointment targetAppointment = sessionAppointments.get(chosenAppointment);

            if (chosenEditionOption == 0) {
                editAppointmentsTitle = "Change status to:";
                int chosenStatus = editAppointmentsScanner.optionsScanner(editAppointmentsTitle, appointmentStatus);

                targetAppointment.status = appointmentStatus.get(chosenStatus);

            }
            else {

                editAppointmentsTitle = "What day is today?";
                int currentDay = editAppointmentsScanner.optionsScanner(editAppointmentsTitle, workingDays);
                int appointmentDayIndex = workingDays.indexOf(targetAppointment.day);
                int dayDifference = appointmentDayIndex - currentDay;

                if (dayDifference == 1 || dayDifference == 0) {
                    System.out.println("It's too late to change the date. You are doomed.");
                }
                else {
                    editAppointmentsTitle = "Choose a new day for your appointment";

                    int chosenDayIndex = editAppointmentsScanner.optionsScanner(editAppointmentsTitle, workingDays);

                    targetAppointment.day = workingDays.get(chosenDayIndex);
                }
            }
        }
        return;
    }

}
