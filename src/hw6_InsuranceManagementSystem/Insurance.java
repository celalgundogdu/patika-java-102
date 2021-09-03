package hw6_InsuranceManagementSystem;

import java.util.Date;

public abstract class Insurance {

    private String name;
    private double price;
    private Date startDate;
    private Date expireDate;

    public Insurance(String name, double price, Date startDate, Date expireDate) {
        this.name = name;
        this.price = price;
        this.startDate = startDate;
        this.expireDate = expireDate;
    }

    public abstract double calculate();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }
}
