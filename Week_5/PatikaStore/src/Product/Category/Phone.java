package Product.Category;

import Brand.Brand;
import Product.BaseProduct;

import java.util.ArrayList;

public class Phone extends BaseProduct {

    private int storage;
    private double screenSize;
    private int camera;
    private double battery;
    private int ram;
    private String color;

    public Phone(int productId, String productName, double price, Brand brand, int discount, int stock, int storage, double screenSize, int camera, double battery, int ram, String color) {
        super(productId, productName, price, brand, discount, stock);
        this.storage = storage;
        this.screenSize = screenSize;
        this.camera = camera;
        this.battery = battery;
        this.ram = ram;
        this.color = color;
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

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }

    public double getBattery() {
        return battery;
    }

    public void setBattery(double battery) {
        this.battery = battery;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


}
