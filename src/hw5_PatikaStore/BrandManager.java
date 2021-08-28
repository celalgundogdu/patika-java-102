package hw5_PatikaStore;

import java.util.List;

public class BrandManager {

    public void printAllBrands(List<Brand> brands) {
        for (Brand brand : brands){
            System.out.println(" - " + brand.getName());
        }
    }

    public Brand getBrandByName(List<Brand> brandList, String name){
            for (Brand brand : brandList){
                if (brand.getName().equals(name)){
                    return brand;
                }
            }
            return null;
    }

}
