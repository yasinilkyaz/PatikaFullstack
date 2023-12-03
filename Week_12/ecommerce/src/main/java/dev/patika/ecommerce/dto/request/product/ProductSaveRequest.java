package dev.patika.ecommerce.dto.request.product;

public class ProductSaveRequest {


    private String name;
    private int price;
    private int stock;
    private int supplierId;
    private int categoryId;

    public ProductSaveRequest() {
    }

    public ProductSaveRequest(String name, int price, int stock, int supplierId, int categoryId) {

        this.name = name;
        this.price = price;
        this.stock = stock;
        this.supplierId = supplierId;
        this.categoryId = categoryId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
