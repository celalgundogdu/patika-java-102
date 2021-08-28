package hw5_PatikaStore;

public class Notebook extends Product {

    private int ram;
    private int storage;
    private double screenSize;
    private static int idCreator = 1;

    public Notebook(String name, Brand brand, double unitPrice, int discount, int stockAmount, int ram, int storage, double screenSize) {
        super(idCreator, name, brand, unitPrice, discount, stockAmount);
        this.ram = ram;
        this.storage = storage;
        this.screenSize = screenSize;
        idCreator++;
    }

    @Override
    public void print() {
        System.out.printf("%-4d | %-30s | %-10.1f | %-10s | %-10d | %-5.1f | %-5d\n", this.getId(), this.getName(), this.getUnitPrice(),
                this.getBrand().getName(), this.getStorage(), this.getScreenSize(), this.getRam());
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

}
