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
    ExitOption exitApplication = new ExitOption(5, "5. Exit");

    List<MenuOption> menuOptions = Arrays.asList(registerMenu, appointmentsMenu, exitApplication);


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

                else if (userChoice.equals("5")) {
                    exitApplication.exitApplication();
                    return;

                }

            }

        }

        return;
    }
}
