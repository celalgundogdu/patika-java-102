package hw5_PatikaStore;

public class MobilePhone extends Product {

    private int memory;
    private double screenSize;
    private int batteryPower;
    private int ram;
    private int camera;
    private String color;
    private static int idCreator = 1;

    public MobilePhone(String name, Brand brand, double unitPrice, int discount, int stockAmount, int memory,
                       double screenSize, int batteryPower, int ram, int camera, String color) {
        super(idCreator, name, brand, unitPrice, discount, stockAmount);
        this.memory = memory;
        this.screenSize = screenSize;
        this.batteryPower = batteryPower;
        this.ram = ram;
        this.camera = camera;
        this.color = color;
        idCreator++;
    }

    @Override
    public void print() {
        System.out.printf("%-4d | %-30s | %-10.1f | %-10s | %-10d | %-5.1f | %-5d | %-5d  | %-5d | %-10s\n", this.getId(),
                this.getName(), this.getUnitPrice(), this.getBrand().getName(), this.memory, this.screenSize,
                this.camera, this.batteryPower, this.ram, this.color);
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(int batteryPower) {
        this.batteryPower = batteryPower;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
