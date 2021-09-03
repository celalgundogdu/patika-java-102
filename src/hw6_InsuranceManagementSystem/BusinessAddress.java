package hw6_InsuranceManagementSystem;

public class BusinessAddress extends GlobalAddress implements Address {

    private String tradeName;

    public BusinessAddress(String tradeName, String city, String district, String neighbourhood, String no) {
        super(city, district, neighbourhood, no);
        this.tradeName = tradeName;
    }

    @Override
    public void print() {
        System.out.println(this.getCity() + "/" + this.getDistrict() + " - " + this.tradeName);
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }
}
