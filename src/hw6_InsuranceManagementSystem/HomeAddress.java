package hw6_InsuranceManagementSystem;

public class HomeAddress extends GlobalAddress implements Address{

    public HomeAddress(String city, String district, String neighbourhood, String no) {
        super(city, district, neighbourhood, no);
    }

    @Override
    public void print() {
        System.out.println(this.getCity() + "/" + this.getDistrict() + "/" + this.getNeighbourhood() + "No:" + this.getNo());
    }
}
