package Medicine;

public class Medicine {
    public String name;
    public String medicineType;
    public float quantity;

    public String presentation;
    public int stock;

    public int cost;

    public Medicine(String name, String  medicineType, float quantity, String presentation, int stock, int cost) {
        this.name = name;
        this.medicineType = medicineType;
        this.quantity = quantity;
        this.presentation = presentation;
        this.stock = stock;
        this.cost = cost;
    }
}
