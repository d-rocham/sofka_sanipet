package Menu;

import Medicine.Medicine;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MedicineOption extends MenuOption{

    List<String> medicineTypes = Arrays.asList("Pill", "Syrup", "Pet care");
    List<String> medicinePresentations = Arrays.asList("MG", "ML");

    public MedicineOption(int optionID, String optionDescription) {
        super(optionID, optionDescription);
    }

    void optionAction(List<String> medicineNames, List<Medicine> sessionMedicines) {

        String medicineMenuTitle = "What would you like to do?";

        List<String> medicineOptions = Arrays.asList("Add medicine.","Show medicine stock.", "Upgrade medicine stock");

        MenuScanner medicineScanner = new MenuScanner();

        int chosenOption = medicineScanner.optionsScanner(medicineMenuTitle, medicineOptions);

        if (chosenOption == 0) {
            createMedicine(sessionMedicines);
        }
        else if (chosenOption == 1){
            displayMedicineStock(sessionMedicines);
        }
        else {
            updateMedicineStock(medicineNames, sessionMedicines);
        }

        return;


    }

    void createMedicine(List<Medicine> sessionMedicines) {

        MenuScanner medicineScanner = new MenuScanner();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Name of new medicine:");

        String medicineName = scanner.nextLine();

        String medicineMenuTitle = "Type of new medicine:";

        int chosenMedicineType = medicineScanner.optionsScanner(medicineMenuTitle, medicineTypes);

        medicineMenuTitle = String.format("Presentation of %s", medicineName);

        int chosenMedicinePresentation = medicineScanner.optionsScanner(medicineMenuTitle, medicinePresentations);

        System.out.printf("Quantity in %s of %s\n", medicinePresentations.get(chosenMedicinePresentation), medicineName);

        float medicineQuantity = Float.parseFloat(scanner.nextLine());

        System.out.println("Amount available in stock:");

        int medicineStock = Integer.parseInt(scanner.nextLine());

        System.out.println("Medicine cost:");

        int medicineCost = Integer.parseInt(scanner.nextLine());

        Medicine newMedicine = new Medicine(medicineName, medicineTypes.get(chosenMedicineType), medicineQuantity, medicinePresentations.get(chosenMedicinePresentation), medicineStock, medicineCost);

        sessionMedicines.add(newMedicine);

        return;
    }

    void displayMedicineStock(List<Medicine> sessionMedicines) {
        Scanner exitScanner = new Scanner(System.in);
        int exit = 0;

        while (exit != 1){
            System.out.println("Name    |    Type    |    Quantity    |    Presentation    |    Stock    |");
            for (Medicine medicine: sessionMedicines){
                System.out.printf("%s    |    %s    |    %s    |    %s    |    %s    |\n", medicine.name, medicine.medicineType, medicine.quantity, medicine.presentation, medicine.stock);
            }
            System.out.println("To exit, press 1 and hit enter.");

            exit = Integer.parseInt(exitScanner.nextLine());
        }
        return;

    }

    void updateMedicineStock(List<String> medicineNames ,List<Medicine> sessionMedicines) {
        MenuScanner updateMedicineMenu = new MenuScanner();

        String menuTitle = "Choose a medicine to update its stock: ";

        int chosenMedicine = updateMedicineMenu.optionsScanner(menuTitle, medicineNames);

        int newStock = -1;

        Scanner stockScanner = new Scanner(System.in);

        while(newStock < 0) {
            System.out.println("Insert new stock (higher than 0):");

            newStock = Integer.parseInt(stockScanner.nextLine());
        }

        sessionMedicines.get(chosenMedicine).stock = newStock;

        System.out.printf("Stock for %s updated to %d\n", medicineNames.get(chosenMedicine), newStock);

        return;
    }
}

