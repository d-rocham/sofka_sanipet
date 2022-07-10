package patient;

import Medicine.Medicine;

import static java.util.Objects.isNull;

public class Bill {
    public Bill(Appointment billAppointment, Medicine billMedicine, String billContent) {
        this.billAppointment = billAppointment;
        this.billMedicine = billMedicine;
        this.billContent = billContent;
    }

    Appointment billAppointment;
    Medicine billMedicine;
    String billContent;


    public void displayBill() {
        System.out.println("FINAL BILL:");
        System.out.println(billContent);
        System.out.printf("TOTAL...... %d\n", getBillTotal());
    }

    int getBillTotal(){

        if (!isNull(billMedicine)) {
            return billAppointment.cost + billMedicine.cost;
        }

        return billAppointment.cost;

    }

}
