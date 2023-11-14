import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("market");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        EntityTransaction transaction=entityManager.getTransaction();

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
