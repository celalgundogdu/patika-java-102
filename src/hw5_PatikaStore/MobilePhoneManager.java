package hw5_PatikaStore;

import java.util.List;

public class MobilePhoneManager extends ProductManager<MobilePhone> {

    @Override
    public void printAllProducts(List<MobilePhone> mobilePhoneList) {
        System.out.printf("%-4s | %-30s | %-10s | %-10s | %-10s | %-5s | %-5s | %-5s | %-5s | %-10s\n",
                "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "Kamera", "Pil", "RAM", "Renk");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        for (MobilePhone mobilePhone : mobilePhoneList){
            mobilePhone.print();
        }
    }
}
