package Product;

import Brand.BrandManager;
import Product.Category.Computer;
import Product.Category.Phone;

import java.util.*;

public class ProductManager {

    static ArrayList<Computer> computers = new ArrayList<>();
    static ArrayList<Phone> phones = new ArrayList<>();

    public void addComputer(Computer computer) {
        computers.add(computer);
    }

    public void addPhone(Phone phone) {
        phones.add(phone);
    }

    public void removeProduct() {
        System.out.println("Silmek istediğiniz ürünün kategorisini seçiniz");
        System.out.println("1 - Notebook");
        System.out.println("2 - Telefon");
        Scanner input = new Scanner(System.in);
        int categoryNum = input.nextInt();
        if (categoryNum == 1) {
            System.out.print("Id: ");
            int id = input.nextInt();
            Iterator<Computer> iterator = computers.iterator();

            while (iterator.hasNext()) {
                Computer computer = iterator.next();
                if (computer.getProductId() == id) {
                    iterator.remove(); // Güvenli bir şekilde koleksiyonu değiştir
                    System.out.println("Silme işlemi gerçekleşti");

                }

            }
            printComputers();
        } else if (categoryNum == 2) {
            System.out.print("Id: ");
            int id = input.nextInt();
            Iterator<Phone> iterator = phones.iterator();

            while (iterator.hasNext()) {
                Phone phone = iterator.next();
                if (phone.getProductId() == id) {
                    iterator.remove(); // Güvenli bir şekilde koleksiyonu değiştir
                    System.out.println("Silme işlemi gerçekleşti");

                }

            }
            printPhones();
        }
    }

    public void addProduct() {
        System.out.println("Eklemek istediğiniz ürün kategorisini seçiniz");
        System.out.println("1 - Notebook");
        System.out.println("2 - Telefon");
        Scanner input = new Scanner(System.in);
        int categoryNum = input.nextInt();

        if (categoryNum == 1) {
            //computer
            System.out.print("id:");
            int id = input.nextInt();
            System.out.print("Ürün ismi:");
            String productName = input.next();
            System.out.print("Fiyat:");
            double price = input.nextDouble();
            System.out.print("marka id:");
            int brandId = input.nextInt();
            System.out.print("İndirim oranı:");
            int discount = input.nextInt();
            System.out.print("Stok adedi:");
            int stock = input.nextInt();
            System.out.print("Depolama:");
            int storage = input.nextInt();
            System.out.print("Ekran boyutu:");
            double screenSize = input.nextInt();
            System.out.print("Ram:");
            int ram = input.nextInt();

            Computer computer = new Computer(id, productName, price, BrandManager.getBrands().get(brandId), discount, stock, storage, screenSize, ram);
            if (idCheckForPC(id)) {

                System.out.println("Ekleme başarılı");
                computers.add(computer);
                printComputers();
            } else {
                System.out.println("id çakışması sebebi ile eklenemedi");
            }
        } else if (categoryNum == 2) {//telefon

            System.out.print("id:");
            int id = input.nextInt();
            System.out.print("Ürün ismi:");
            String productName = input.next();
            System.out.print("Fiyat:");
            double price = input.nextDouble();
            System.out.print("marka id:");
            int brandId = input.nextInt();
            System.out.print("İndirim oranı:");
            int discount = input.nextInt();
            System.out.print("Stok adedi:");
            int stock = input.nextInt();
            System.out.print("Depolama:");
            int storage = input.nextInt();
            System.out.print("Ekran boyutu:");
            double screenSize = input.nextInt();
            System.out.print("Kamera:");
            int camera = input.nextInt();
            System.out.print("Batarya:");
            double battery = input.nextDouble();
            System.out.print("Ram:");
            int ram = input.nextInt();
            System.out.print("Renk:");
            String color = input.next();

            Phone phone = new Phone(id, productName, price, BrandManager.getBrands().get(brandId), discount, stock, storage, screenSize, camera, battery, ram, color);

            if (idCheckForPhone(id)) {
                System.out.println("Ekleme başarılı");
                phones.add(phone);
                printPhones();
            } else {
                System.out.println("id çakışması sebebi ile eklenemedi");
            }

        }

    }

    public boolean idCheckForPC(int id) {
        for (Computer computer : computers
        ) {
            if (computer.getProductId() == id) {
                return false;
            }
        }
        return true;
    }

    public boolean idCheckForPhone(int id) {
        for (Phone phone : phones
        ) {
            if (phone.getProductId() == id) {
                return false;
            }
        }
        return true;
    }

    public void printComputers() {

        ArrayList<Computer> brandComputers = new ArrayList<>(computers);
        Comparator<Computer> brandComputer = new Comparator<Computer>() {
            @Override
            public int compare(Computer o1, Computer o2) {
                return Integer.compare(o1.getProductId(), o2.getProductId());
            }
        };

        brandComputers.sort(brandComputer);


        System.out.println("Notebook Listesi");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                      | Fiyat     | Marka     | Depolama  | Ekran     | RAM         |");
        System.out.println("----------------------------------------------------------------------------------------------------");
        for (Computer computer : brandComputers) {
            System.out.format("| %-2d | %-30s | %-9.1f TL | %-9s | %-9d | %-6.1f | %-11d |%n",
                    computer.getProductId(),
                    computer.getProductName(),
                    computer.getPrice(),
                    computer.getBrand().getBrandName(),
                    computer.getStorage(),
                    computer.getScreenSize(),
                    computer.getRam());

        }
        System.out.println("----------------------------------------------------------------------------------------------------");
    }

    public void printComputersSortBrand() {
        ArrayList<Computer> brandComputers = new ArrayList<>(computers);
        Comparator<Computer> brandComputer = new Comparator<Computer>() {
            @Override
            public int compare(Computer o1, Computer o2) {
                return o1.getBrand().getBrandName().compareTo(o2.getBrand().getBrandName());
            }
        };

        brandComputers.sort(brandComputer);

        System.out.println("Notebook Listesi(Marka)");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                      | Fiyat     | Marka     | Depolama  | Ekran     | RAM         |");
        System.out.println("----------------------------------------------------------------------------------------------------");
        for (Computer computer : brandComputers) {
            System.out.format("| %-2d | %-30s | %-9.1f TL | %-9s | %-9d | %-6.1f | %-11d |%n",
                    computer.getProductId(),
                    computer.getProductName(),
                    computer.getPrice(),
                    computer.getBrand().getBrandName(),
                    computer.getStorage(),
                    computer.getScreenSize(),
                    computer.getRam());

        }
        System.out.println("----------------------------------------------------------------------------------------------------");

    }

    public void printPhones() {

        ArrayList<Phone> brandPhones = new ArrayList<>(phones);
        Comparator<Phone> brandPhone = new Comparator<Phone>() {
            @Override
            public int compare(Phone o1, Phone o2) {
                return Integer.compare(o1.getProductId(), o2.getProductId());
            }
        };


        brandPhones.sort(brandPhone);


        System.out.println("Telefon Listesi(ID)");
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                      | Fiyat     | Marka     | Depolama  | Ekran     | Kamera    | Pil       | RAM       | Renk      | ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        for (Phone phone : brandPhones) {
            System.out.format("| %-2d | %-30s | %-9.1fTL | %-9s | %-9d | %-6.1f | %-8d | %-9.1f | %-9d | %-9s |%n",
                    phone.getProductId(),
                    phone.getProductName(),
                    phone.getPrice(),
                    phone.getBrand().getBrandName(),
                    phone.getStorage(),
                    phone.getScreenSize(),
                    phone.getCamera(),
                    phone.getBattery(),
                    phone.getRam(),
                    phone.getColor());

        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

    }

    public void printPhonesSortBrand() {
        ArrayList<Phone> brandPhones = new ArrayList<>(phones);
        Comparator<Phone> brandPhone = new Comparator<Phone>() {
            @Override
            public int compare(Phone o1, Phone o2) {
                return o1.getBrand().getBrandName().compareTo(o2.getBrand().getBrandName());
            }
        };


        brandPhones.sort(brandPhone);
        System.out.println("Telefon Listesi(Marka)");
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                      | Fiyat     | Marka     | Depolama  | Ekran     | Kamera    | Pil       | RAM       | Renk      | ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        for (Phone phone : brandPhones) {
            System.out.format("| %-2d | %-30s | %-9.1fTL | %-9s | %-9d | %-6.1f | %-8d | %-9.1f | %-9d | %-9s |%n",
                    phone.getProductId(),
                    phone.getProductName(),
                    phone.getPrice(),
                    phone.getBrand().getBrandName(),
                    phone.getStorage(),
                    phone.getScreenSize(),
                    phone.getCamera(),
                    phone.getBattery(),
                    phone.getRam(),
                    phone.getColor());

        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
    }

}

