package Product.Category;

import Brand.Brand;
import Product.BaseProduct;

import java.util.ArrayList;

public class Computer extends BaseProduct {

    private int storage;
    private double screenSize;
    private int ram;

    public Computer(int productId, String productName, double price, Brand brand, int discount, int stock, int storage, double screenSize, int ram) {
        super(productId, productName, price, brand, discount, stock);
        this.storage = storage;
        this.screenSize = screenSize;
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

}
