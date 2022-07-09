package Menu;

import Medicine.Medicine;
import patient.Appointment;
import patient.Bill;

import java.util.Arrays;
import java.util.List;

public class BillingOption extends MenuOption{
    public BillingOption(int optionID, String optionDescription) {
        super(optionID, optionDescription);
    }

    void optionAction(List<Appointment> sessionAppointments, List<String> appointmentsWithCost, List<Medicine> sessionMedicines, List<String> medicinesWithCost, List<Bill> sessionBills){
        if (sessionAppointments.size() == 0) {
            System.out.println("There are no appointments to bill for.");
        }

        else {
            MenuScanner billingScanner = new MenuScanner();
            String billingScannerTitle = "Select appointment to bill for:";

            int chosenAppointmentIndex = billingScanner.optionsScanner(billingScannerTitle, appointmentsWithCost);

            Appointment chosenAppointment = sessionAppointments.get(chosenAppointmentIndex);

            if (!chosenAppointment.status.equals("Finished")){
                System.out.println("The requested appointment hasn't been completed. Please complete it in order to generate its bill.");
            }

            else {
                List<String> addMedicineOptions = Arrays.asList("Yes", "No");
                billingScannerTitle = "Would you like to add medicine to this appointment's invoice?";

                int addMedicine = billingScanner.optionsScanner(billingScannerTitle, addMedicineOptions);

                if (addMedicine == 0) {
                    billingScannerTitle= "Choose a medicine below. Be aware that medicine with no stock cannot be added to a bill:";

                    int selectedMedicineIndex = billingScanner.optionsScanner(billingScannerTitle, medicinesWithCost);

                    if (sessionMedicines.get(selectedMedicineIndex).stock == 0) {
                        System.out.println("Selected medicine has no stock.");
                    }

                    else {
                        String billString = String.format("%s\n%s", appointmentsWithCost.get(chosenAppointmentIndex), medicinesWithCost.get(selectedMedicineIndex));

                        Bill newBill = new Bill(chosenAppointment, sessionMedicines.get(selectedMedicineIndex), billString);

                        // TODO: call newBill.saveBill(); to save bill in filesystem as .txt

                        sessionBills.add(newBill);

                    }

                }

                else {
                    //something else
                }


            }




        }

    return;
    }
}
