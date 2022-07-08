package medicine;

public class medicine {
    private String name;
    private MedicineType medicineType;
    private float quantity;

    private int stock;

    public medicine(String name, MedicineType medicineType, float quantity, int stock) {
        this.name = name;
        this.medicineType = medicineType;
        this.quantity = quantity;
        this.stock = stock;
    }
}
