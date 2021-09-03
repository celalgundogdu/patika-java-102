package hw6_InsuranceManagementSystem;

public abstract class GlobalAddress {

    private String city;
    private String district;
    private String neighbourhood;
    private String no;

    public GlobalAddress(String city, String district, String neighbourhood, String no) {
        this.city = city;
        this.district = district;
        this.neighbourhood = neighbourhood;
        this.no = no;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
}
