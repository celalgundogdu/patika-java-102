package hw6_InsuranceManagementSystem;

import java.util.ArrayList;

public class AddressManager {

    public static void add(Address address, User user){
        user.getAddressList().add(address);
        System.out.println("Adres eklendi");
    }

    public static boolean delete(Address address, User user){
        ArrayList<Address> addressList = user.getAddressList();
        for(Address a : addressList){
            if (a.equals(address)){
                addressList.remove(address);
                return true;
            }
        }
        return false;
    }

}
