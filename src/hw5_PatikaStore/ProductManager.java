package hw5_PatikaStore;

import java.util.ArrayList;
import java.util.List;

public abstract class ProductManager <T extends Product> {

    public abstract void printAllProducts(List<T> products);


    public void add(List<T> products, T product) {
        products.add(product);
        System.out.println(product.getName() + " eklendi.");;
    }


    public boolean delete(List<T> products, int id) {
        T deletedProduct = getProductById(products, id);
        if (deletedProduct != null){
            products.remove(deletedProduct);
            return true;
        }
        return false;
    }


    public T getProductById(List<T> products, int id) {
        for (T product : products){
            if (product.getId() == id){
                return product;
            }
        }
        return null;
    }


    public List<T> getProductsByBrand(List<T> products, Brand brand) {
        List<T> filteredProducts = new ArrayList<>();
        for (T product : products){
            if (product.getBrand().equals(brand)){
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }
}
