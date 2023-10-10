package Product;

import Brand.Brand;

public abstract class BaseProduct {

    private int productId;
    private String productName;
    private double price;
    private Brand brand;
    private int discount;
    private int stock;

    public BaseProduct(int productId, String productName, double price, Brand brand, int discount, int stock) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.brand = brand;
        this.discount = discount;
        this.stock = stock;
    }


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
