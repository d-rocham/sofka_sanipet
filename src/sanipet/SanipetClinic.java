package sanipet;

import java.util.Scanner;


public class SanipetClinic {
    public static void main(String[] args) {
        ClinicManager sessionClinic = new ClinicManager();
        MainMenu sessionMenu = new MainMenu();

        sessionMenu.run(sessionClinic);

    }
}
