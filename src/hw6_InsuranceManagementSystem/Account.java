package hw6_InsuranceManagementSystem;

import java.util.ArrayList;
import java.util.List;

public abstract class Account implements Comparable<Account> {

    private User user;
    private List<Insurance> insuranceList;
    private AuthenticationStatus authenticationStatus;

    public Account(User user) {
        this.user = user;
        insuranceList = new ArrayList<>();
    }

    public abstract void addInsurance(Insurance insurance);

    public final void showUserInfo(){
        System.out.printf("%-20s %-20s %-30s", user.getFirstName(), user.getLastName(), user.getEmail());
    }

    public void login(String email, String password) throws InvalidAuthenticationException {
        if (user.getEmail().equals(email) && user.getPassword().equals(password)){
            System.out.println("Giriş yapıldı.");
            this.authenticationStatus = AuthenticationStatus.SUCCESS;
        }else {
            throw new InvalidAuthenticationException("Hatalı giriş!");
        }
    }

    public void addAddress(Address address){
        AddressManager.add(address, this.user);
    }

    public boolean deleteAddress(Address address){
        return AddressManager.delete(address, this.user);
    }

    @Override
    public int compareTo(Account o) {
        return this.user.getEmail().compareTo(o.getUser().getEmail());
    }

    public User getUser() {
        return user;
    }

    public List<Insurance> getInsuranceList() {
        return insuranceList;
    }

    public AuthenticationStatus getAuthenticationStatus() {
        return this.authenticationStatus;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
