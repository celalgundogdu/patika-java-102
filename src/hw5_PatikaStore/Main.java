package hw5_PatikaStore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    static void showFirstMenu(){
        System.out.println("Patika Store Ürün Yönetim Paneli !");
        System.out.println("1 - Notebook İşlemleri");
        System.out.println("2 - Cep Telefonu İşlemleri");
        System.out.println("3 - Marka Listele");
        System.out.println("0 - Çıkış Yap\n");
    }

    static void showSecondMenu(){
        System.out.println("1 - Ürünleri Markaya Göre Listele");
        System.out.println("2 - Ürünü ID numarasına Göre Getir");
        System.out.println("3 - Ürün Ekle");
        System.out.println("4 - Ürün Sil\n");
    }

    static String getUserChoice(){
        String choice;
        System.out.print("Tercihiniz : ");
        choice = input.nextLine();
        return choice;
    }

    public static void main(String[] args) {

        List<Brand> brandList = new ArrayList<>();
        Brand brand1 = new Brand("Samsung");
        brandList.add(brand1);
        Brand brand2 = new Brand("Lenovo");
        brandList.add(brand2);
        Brand brand3 = new Brand("Apple");
        brandList.add(brand3);
        Brand brand4 = new Brand("Huawei");
        brandList.add(brand4);
        Brand brand5 = new Brand("Casper");
        brandList.add(brand5);
        Brand brand6 = new Brand("Asus");
        brandList.add(brand6);
        Brand brand7 = new Brand("HP");
        brandList.add(brand7);
        Brand brand8 = new Brand("Xiaomi");
        brandList.add(brand8);
        Brand brand9 = new Brand("Monster");
        brandList.add(brand9);

        Collections.sort(brandList);

        BrandManager brandManager = new BrandManager();
        MobilePhoneManager mobilePhoneManager = new MobilePhoneManager();
        NotebookManager notebookManager = new NotebookManager();

        List<Notebook> notebookList = new ArrayList<>();
        List<MobilePhone> mobilePhoneList = new ArrayList<>();

        notebookManager.add(notebookList, new Notebook("HUAWEI Matebook 14", brand4, 7000, 0, 5, 16, 512, 14));
        notebookManager.add(notebookList, new Notebook("LENOVO V14 IGL", brand2, 3699, 0, 15, 8, 1024, 14));
        notebookManager.add(notebookList, new Notebook("ASUS Tuf Gaming", brand6, 8199, 0, 10, 32, 2048, 15.6));

        mobilePhoneManager.add(mobilePhoneList, new MobilePhone("SAMSUNG GALAXY A51", brand1, 3199, 0, 15, 128, 6.5,
                4000, 6, 32, "Siyah"));
        mobilePhoneManager.add(mobilePhoneList, new MobilePhone("iPhone 11 64 GB", brand3, 7379, 0, 20, 64, 6.1,
                3046, 6, 5, "Mavi"));
        mobilePhoneManager.add(mobilePhoneList, new MobilePhone("Redmi Note 10 Pro 8GB", brand8, 4012, 0, 10, 128, 6.5,
                4000, 12, 35, "Beyaz"));

        System.out.println("=========================================================================================");


        boolean isExit = false;
        do {
            showFirstMenu();
            String choice = getUserChoice();
            String operationType;
            switch (choice){
                case "1":
                    System.out.println("\nNotebook Listesi\n");
                    notebookManager.printAllProducts(notebookList);
                    System.out.println();
                    showSecondMenu();

                    operationType = getUserChoice();
                    if (operationType.equals("1")){
                        System.out.print("Marka Adı: ");
                        String brandName = input.nextLine();
                        Brand brand = brandManager.getBrandByName(brandList, brandName);
                        if (brand != null){
                            List<Notebook> filteredList = notebookManager.getProductsByBrand(notebookList, brand);
                            notebookManager.printAllProducts(filteredList);
                        }else {
                            System.out.println("Bu markaya ait ürün bulunamadı!");
                        }
                    }else if(operationType.equals("2")){
                        System.out.print("ID numarası: ");
                        int id = input.nextInt();
                        Notebook notebook = notebookManager.getProductById(notebookList, id);
                        if (notebook != null){
                            notebook.print();
                        }else {
                            System.out.println("Bu ID numarasına sahip ürün bulunamadı!");
                        }
                    }else if(operationType.equals("3")){
                        System.out.print("Ürün adı: ");
                        String productName = input.nextLine();

                        System.out.print("\nMarka adı: ");
                        String brandName = input.nextLine();

                        System.out.print("\nFiyat: ");
                        double price = input.nextDouble();

                        System.out.print("\nStok Miktarı: ");
                        int stock = input.nextInt();

                        System.out.print("\nRAM: ");
                        int ram = input.nextInt();

                        System.out.print("\nDepolama Alanı: ");
                        int storage = input.nextInt();

                        System.out.print("\nEkran boyutu: ");
                        double size = input.nextDouble();

                        boolean isAdded = false;
                        for(Brand brand : brandList){
                            if (brand.getName().toUpperCase().equals(brandName.toUpperCase())){
                                notebookManager.add(notebookList, new Notebook(productName, brand, price, 0, stock, ram, storage, size));
                                isAdded = true;
                                break;
                            }
                        }
                        if (!isAdded){
                            Brand brand = new Brand(brandName);
                            brandList.add(brand);
                            Collections.sort(brandList);
                            notebookManager.add(notebookList, new Notebook(productName, brand, price, 0, stock, ram, storage, size));
                        }

                    }else if (operationType.equals("4")){
                        System.out.print("ID numarası: ");
                        int id = input.nextInt();
                        notebookManager.delete(notebookList, id);
                    }else {
                        System.out.println("Geçersiz işlem numarası girdiniz!");
                    }
                    break;

                case "2":
                    System.out.println("\nCep Telefonu Listesi\n");
                    mobilePhoneManager.printAllProducts(mobilePhoneList);
                    System.out.println();
                    showSecondMenu();
                    operationType = getUserChoice();

                    if (operationType.equals("1")){
                        System.out.print("Marka Adı: ");
                        String brandName = input.nextLine();
                        Brand brand = brandManager.getBrandByName(brandList, brandName);
                        if (brand != null){
                            List<MobilePhone> filteredList = mobilePhoneManager.getProductsByBrand(mobilePhoneList, brand);
                            mobilePhoneManager.printAllProducts(filteredList);
                        }else {
                            System.out.println("Bu markaya ait ürün bulunamadı!");
                        }
                    }else if(operationType.equals("2")){
                        System.out.print("ID numarası: ");
                        int id = input.nextInt();
                        MobilePhone mobilePhone = mobilePhoneManager.getProductById(mobilePhoneList, id);
                        if (mobilePhone != null){
                            mobilePhone.print();
                        }else {
                            System.out.println("Bu ID numarasına sahip ürün bulunamadı!");
                        }
                    }else if(operationType.equals("3")){
                        System.out.print("Ürün adı: ");
                        String productName = input.nextLine();

                        System.out.print("\nMarka adı: ");
                        String brandName = input.nextLine();

                        System.out.print("\nFiyat: ");
                        double price = input.nextDouble();

                        System.out.print("\nStok Miktarı: ");
                        int stock = input.nextInt();

                        System.out.print("\nHafıza: ");
                        int storage = input.nextInt();

                        System.out.print("\nEkran boyutu: ");
                        double size = input.nextDouble();

                        System.out.print("\nPil gücü: ");
                        int battery = input.nextInt();

                        System.out.print("\nRAM: ");
                        int ram = input.nextInt();

                        System.out.print("\nKamera: ");
                        int camera = input.nextInt();

                        System.out.print("\nRenk: ");
                        String color = input.nextLine();

                        boolean isAdded = false;
                        for(Brand brand : brandList){
                            if (brand.getName().toUpperCase().equals(brandName.toUpperCase())){
                                mobilePhoneManager.add(mobilePhoneList, new MobilePhone(productName, brand, price, 0, stock, storage, size, battery, ram, camera, color));
                                isAdded = true;
                                break;
                            }
                        }
                        if (!isAdded){
                            Brand brand = new Brand(brandName);
                            brandList.add(brand);
                            Collections.sort(brandList);
                            mobilePhoneManager.add(mobilePhoneList, new MobilePhone(productName, brand, price, 0, stock, storage, size, battery, ram, camera, color));
                        }

                    }else if (operationType.equals("4")){
                        System.out.print("ID numarası: ");
                        int id = input.nextInt();
                        notebookManager.delete(notebookList, id);
                    }else{
                        System.out.println("Geçersiz işlem numarası girdiniz!");
                    }
                    break;

                case "3":
                    brandManager.printAllBrands(brandList);
                    break;

                case "0":
                    System.out.println("Hoşçakalın");
                    isExit = true;
                    break;
                default:
                    System.out.println("Geçersiz bir tercih yaptınız!");
                    break;
            }
            System.out.println();
            input.nextLine();
        }while(!isExit);
    }
}
