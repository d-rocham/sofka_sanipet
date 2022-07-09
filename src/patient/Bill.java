package patient;

import Medicine.Medicine;

import java.util.List;

public class Bill {
    public Bill(Appointment billAppointment, Medicine billMedicine, String billContent) {
        this.billAppointment = billAppointment;
        this.billMedicine = billMedicine;
        this.billContent = billContent;
    }

    Appointment billAppointment;
    Medicine billMedicine;
    String billContent;


    void displayBill() {
        System.out.println(billContent);
    }

    int getBillTotal(){
        return billAppointment.cost + billMedicine.cost;
    }

    // void saveBill(){saves bill as txt file}
}
