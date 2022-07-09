package Medicine;

public class Medicine {
    private String name;
    private MedicineType medicineType;
    private float quantity;

    private int stock;

    public Medicine(String name, MedicineType medicineType, float quantity, int stock) {
        this.name = name;
        this.medicineType = medicineType;
        this.quantity = quantity;
        this.stock = stock;
    }
}
