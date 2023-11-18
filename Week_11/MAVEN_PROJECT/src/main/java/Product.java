import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", columnDefinition = "serial")
    private int id;

    @Column(name = "product_name", nullable = false)
    private String name;
    @Column(name = "product_prc", nullable = false)
    private int price;

    @Column(name = "product_stock")
    private int stock;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "product_code_id", referencedColumnName = "code_id")
    private Code code;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "pro2colors",
            joinColumns = {@JoinColumn(name = "pro2color_product_id")},
            inverseJoinColumns = {@JoinColumn(name = "pro2color_color_id")}
    )
    private List<Color> colorList;

    /*
    @ManyToMany: Bu anotasyon, iki varlık sınıfı arasında bir çoktan çoklu ilişki olduğunu belirtir.
    Yani, bu durumda, Product sınıfı ile Color sınıfı arasında birçoktan çoklu ilişki bulunmaktadır.

    @JoinTable: Bu anotasyon, ilişki tablosunun ayrı bir tablo olacağını belirtir. Yani, pro2colors adlı bir ilişki tablosu oluşturulacak.

    name = "pro2colors": İlişki tablosunun adını belirtir. Bu durumda, tablonun adı "pro2colors" olacaktır.

    joinColumns: Bu, ilişki tablosunda bu sınıfa ait olan sütunları belirtir. pro2color_product_id adında bir sütun, Product sınıfına ait olan öğeleri temsil edecektir.

    inverseJoinColumns: Bu, ilişki tablosunda diğer sınıfa ait olan sütunları belirtir.
    pro2color_color_id adında bir sütun, Color sınıfına ait olan öğeleri temsil edecektir.

    private List<Color> colorList;: Bu alan, Product sınıfında bir List<Color> türünde colorList adında bir değişken tanımlar.
    Bu liste, Product sınıfı ile Color sınıfı arasındaki çoktan çoklu ilişkiyi temsil eder. Yani, bir ürünün birden çok rengi olabilir ve aynı renk birçok ürüne ait olabilir.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_supplier_id", referencedColumnName = "supplier_id")
    private Supplier supplier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_category_id", referencedColumnName = "category_id")
    private Category category;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Color> getColorList() {
        return colorList;
    }

    public void setColorList(List<Color> colorList) {
        this.colorList = colorList;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", code=" + code +
                ", supplier=" + supplier +
                ", category=" + category +
                ", colorList=" + colorList +
                '}';
    }
}
