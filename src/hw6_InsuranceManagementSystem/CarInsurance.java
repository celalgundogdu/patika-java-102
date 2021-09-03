package hw6_InsuranceManagementSystem;

import java.util.Date;

public class CarInsurance extends Insurance{


    public CarInsurance(String name, double price, Date startDate, Date expireDate) {
        super(name, price, startDate, expireDate);
    }

    @Override
    public double calculate() {
        return 0;
    }
}
