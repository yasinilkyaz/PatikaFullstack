

import Brand.BrandManager;

import Product.Category.Computer;
import Product.Category.Phone;
import Product.ProductManager;

import java.util.Scanner;


public class PatikaStore {


    public void run() {

        BrandManager brandManager = new BrandManager();

        brandManager.addBrand(1, "Samsung");
        brandManager.addBrand(2, "Lenovo");
        brandManager.addBrand(3, "Apple");
        brandManager.addBrand(4, "Huawei");
        brandManager.addBrand(5, "Casper");
        brandManager.addBrand(6, "Asus");
        brandManager.addBrand(7, "HP");
        brandManager.addBrand(8, "Xiaomi");
        brandManager.addBrand(9, "Monster");


        ProductManager productManager = new ProductManager();

        productManager.addComputer(new Computer(1, "HUAWEI Matebook 14", 7000, brandManager.getBrands(4), 0, 5, 512, 14, 16));
        productManager.addComputer(new Computer(2, "LENOVO V14 IGL", 3699, brandManager.getBrands(2), 0, 5, 1024, 14, 8));
        productManager.addComputer(new Computer(3, "ASUS Tuf Gaming", 8199, brandManager.getBrands(6), 0, 5, 2048, 15, 32));

        productManager.addPhone(new Phone(1, "SAMSUNG GALAXY A51", 3199, brandManager.getBrands(1), 0, 5, 128, 6.5, 32, 4000, 6, "Siyah"));
        productManager.addPhone(new Phone(2, "iPhone 11 64 GB", 7379, brandManager.getBrands(3), 0, 5, 64, 6.1, 5, 3046, 6, "Mavi"));
        productManager.addPhone(new Phone(3, "Redmi Note 10 Pro", 4012, brandManager.getBrands(8), 0, 5, 128, 6.5, 35, 4000, 12, "Beyaz"));

        boolean patikaStore = false;
        while (!patikaStore) {

            System.out.println("PatikaStore Ürün Yönetim Paneli !");
            System.out.println("1 - Notebook Listele");
            System.out.println("2 - Cep Telefonu Listele");
            System.out.println("3 - Ürün Ekle");
            System.out.println("4 - Ürün Sil");
            System.out.println("5 - Marka Listele");
            System.out.println("6 - Çıkış");

            Scanner input = new Scanner(System.in);
            int mainMenu = input.nextInt();

            switch (mainMenu) {
                case 1:
                    System.out.println("-Notebook-");
                    System.out.println("1- Id numarasına göre listele");
                    System.out.println("2- Marka alfabetik sırasına göre listele");
                    System.out.println("3- Ana menü");
                    int listMenuPC = input.nextInt();
                    switch (listMenuPC) {
                        case 1 -> productManager.printComputers();
                        case 2 -> productManager.printComputersSortBrand();
                        default -> {
                            break;
                        }


                    }
                    break;
                case 2:
                    System.out.println("-Telefon-");
                    System.out.println("1- Id numarasına göre listele");
                    System.out.println("2- Marka alfabetik sırasına göre listele");
                    System.out.println("3- Ana menü");
                    int listMenuPhone = input.nextInt();
                    switch (listMenuPhone) {
                        case 1 -> productManager.printPhones();
                        case 2 -> productManager.printPhonesSortBrand();
                        default -> {
                            break;
                        }
                    }
                    break;
                case 3:
                    productManager.addProduct();
                    break;
                case 4:
                    productManager.removeProduct();
                    break;
                case 5:
                    brandManager.printBrandSortedName();
                    break;
                case 6:
                    patikaStore = true;
            }
        }
    }
}