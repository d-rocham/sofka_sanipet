package Menu;
import sanipet.ClinicManager;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class MainMenu {

    /*
    * Ideally,
    *
    * */
    RegisterOption registerMenu = new RegisterOption(1, "1. Register Patient");
    AppointmentsOption appointmentsMenu = new AppointmentsOption(2, "2. Appointments");

    MedicineOption medicineMenu = new MedicineOption(3, "3. Medicine stock");

    BillingOption billingMenu = new BillingOption(4, "4. Billing");

    ExitOption exitApplication = new ExitOption(5, "5. Exit");

    List<MenuOption> menuOptions = Arrays.asList(registerMenu, appointmentsMenu, medicineMenu, billingMenu, exitApplication);


    public void run(ClinicManager currentSession){
        // Display main menu

        boolean displayMainMenu = true;

        while (displayMainMenu) {
            System.out.println("Sanipet - Veterinary Care");
            for (MenuOption option : menuOptions) {
                System.out.println(option.optionDescription);
            }

            Scanner scanner = new Scanner(System.in);

            // Listen for user input
            while (true) {
                String userChoice = scanner.nextLine();

                if (userChoice.equals("1")) {
                    registerMenu.optionAction(currentSession.patients, currentSession.owners);
                    break;
                }

                else if (userChoice.equals("2")) {
                    appointmentsMenu.optionAction(currentSession.getPatientsAsString(), currentSession.getAppointmentsNames(),currentSession.appointments);
                    break;
                }

                else if(userChoice.equals("3")){
                    medicineMenu.optionAction(currentSession.getMedicinesNames() ,currentSession.medicines);
                    break;
                }

                else if (userChoice.equals("4")){
                    billingMenu.optionAction(currentSession.appointments, currentSession.getAppointmentsWithCost(), currentSession.medicines, currentSession.getMedicinesWithCost(), currentSession.bills);
                    break;
                }

                else if (userChoice.equals("5")) {
                    exitApplication.exitApplication();
                    return;
                }

            }

        }

        return;
    }
}
