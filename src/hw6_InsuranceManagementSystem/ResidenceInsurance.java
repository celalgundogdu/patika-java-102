package hw6_InsuranceManagementSystem;

import java.util.Date;

public class ResidenceInsurance extends Insurance{

    public ResidenceInsurance(String name, double price, Date startDate, Date expireDate) {
        super(name, price, startDate, expireDate);
    }

    @Override
    public double calculate() {
        return 0;
    }
}
