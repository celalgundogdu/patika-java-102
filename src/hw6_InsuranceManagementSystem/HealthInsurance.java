package hw6_InsuranceManagementSystem;

import java.util.Date;

public class HealthInsurance extends Insurance{


    public HealthInsurance(String name, double price, Date startDate, Date expireDate) {
        super(name, price, startDate, expireDate);
    }

    @Override
    public double calculate() {
        return 0;
    }
}
