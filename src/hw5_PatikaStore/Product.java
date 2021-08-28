package hw5_PatikaStore;

public abstract class Product {

    private int id;
    private String name;
    private Brand brand;
    private double unitPrice;
    private int discount;
    private int stockAmount;

    public Product(int id, String name, Brand brand, double unitPrice, int discount, int stockAmount) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.unitPrice = unitPrice;
        this.discount = discount;
        this.stockAmount = stockAmount;
    }

    public abstract void print();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }
}
