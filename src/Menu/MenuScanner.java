package Menu;

import java.util.List;
import java.util.Scanner;

public class MenuScanner {
    int optionsScanner(String menuTitle, List<String> menuOptions) {
        int selectedOption = -1;

        int upperBound = menuOptions.size() - 1;

        Scanner menuScanner = new Scanner(System.in);

        while (selectedOption < 0 || selectedOption > upperBound) {
            System.out.println(menuTitle);
            for (int idx = 0; idx <= upperBound; idx++){
                System.out.printf("    %d. %s\n", idx, menuOptions.get(idx));
            }

            selectedOption = Integer.parseInt(menuScanner.nextLine());
        }

        return selectedOption;

    }
}
