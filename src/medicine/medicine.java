package medicine;

public class medicine {
    private String name;
    private MedicineType medicineType;
    private int Quantity;

    public medicine(String name, MedicineType medicineType, int quantity) {
        this.name = name;
        this.medicineType = medicineType;
        Quantity = quantity;
    }
}
