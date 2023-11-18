import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("market");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Product product=entityManager.find(Product.class,1);
        System.out.println(product.getColorList().toString());
        transaction.commit();
/*
        transaction.begin();
        Color blue=new Color("blue");
        Color red=new Color("red");
        Color yellow=new Color("yellow");
        entityManager.persist(blue);
        entityManager.persist(red);
        entityManager.persist(yellow);

        Product product=entityManager.find(Product.class,1);
        List<Color> colorList=new ArrayList<>();
        colorList.add(blue);
        colorList.add(red);
        product.setColorList(colorList);
        entityManager.persist(product);

        transaction.commit();
        //--------OnetoOne ilişki gözlemek için code ve product incele ---------
*/
        /*
        //Supplier ekleme
        Supplier supplier= new Supplier();
        supplier.setAddress("adres");
        supplier.setCompany("patika");
        supplier.setContent("5656454");
        supplier.setMail("info@patika.dev");
        supplier.setPerson("mustafa");
        entityManager.persist(supplier);
        //Category ekleme
        Category category= new Category();
        category.setName("telefonlar");
        entityManager.persist(category);
        //Code ekleme
        Code code=new Code();
        code.setGroup("123123");
        code.setSerial("13asd1");
        entityManager.persist(code);
        //product ekleme
        Product product=new Product();
        product.setName("Iphone 13");
        product.setPrice(36500);
        product.setStock(500);
        product.setCode(code);
        product.setSupplier(supplier);
        product.setCategory(category);
        entityManager.persist(product);
        System.out.println(product.toString());

        transaction.commit();


        /*
        transaction.begin();
        Product product=entityManager.find(Product.class,2);
        System.out.println(product.toString());
        transaction.commit();
        */

        /*------------Delete Transaction ile Silme--------------
        transaction.begin();
        Customer customer=entityManager.find(Customer.class,1);
        entityManager.remove(customer);
        transaction.commit();
        */

        /*--------------Update Transaction ile güncelleme--------
        transaction.begin();
        Customer customer=entityManager.find(Customer.class,1);
        customer.setName("İlkyaz");//update
        entityManager.persist(customer);
        transaction.commit();
        System.out.println(customer.toString());
        */


        /*-------------Read veri okuma-------------
        Customer customer=entityManager.find(Customer.class,1);
        System.out.println(customer.toString());
         */


        /* -------------Create Transaction ile veri ekleme----------
        transaction.begin();

        Customer customer=new Customer();
        customer.setName("Yasin");
        customer.setMail("test@patika.dev");
        customer.setGender(Customer.GENDER.MALE);
        customer.setOnDate(LocalDate.now());
        entityManager.persist(customer);

        transaction.commit();
        */

    }
}
