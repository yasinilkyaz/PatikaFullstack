import java.util.*;

public class Main {
    public static void main(String[] args) {

        Book book1 = new Book("Kara Kitap", 472, "Orhan Pamuk", "1990");
        Book book2 = new Book("Bastırılmış Benlik", 360, "Elif Şafak", "2000");
        Book book3 = new Book("Ince Memed", 464, "Yaşar Kemal", "1955");
        Book book4 = new Book("Saatleri Ayarlama Enstitüsü", 264, "Akmet Hamdi Tanpınar", "1961");
        Book book5 = new Book("Bir Düğün Gecesi", 168, "Adalet Ağaoğlu", "1979");

        TreeSet<Book> books = new TreeSet<>(new BookNameComparator());
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        Iterator<Book> itr = books.iterator();
        System.out.println("Alfabetik siralama");
        while (itr.hasNext()){
            System.out.println(itr.next().getName());
        }

        System.out.println("-------------------");
        TreeSet<Book> books2=new TreeSet<>(new BookPageComparator());
        books2.add(book1);
        books2.add(book2);
        books2.add(book3);
        books2.add(book4);
        books2.add(book5);

        for (Book book:books2) {
            System.out.println(book.getName()+"\t Sayfa sayısı : "+book.getPageCount());
        }
    }

}