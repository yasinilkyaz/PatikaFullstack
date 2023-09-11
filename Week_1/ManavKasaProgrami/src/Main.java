import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double armut=2.14;
        double elma=3.67;
        double domates=1.11;
        double muz=0.95;
        double patlıcan=5;
        double result=0;
        int kilogram=0;
        Scanner i=new Scanner(System.in);

        System.out.print("Armut Kaç Kilo ? :");
        kilogram=i.nextInt();
        result+=kilogram*armut;

        System.out.print("Elma Kaç Kilo ? :");
        kilogram=i.nextInt();
        result+=kilogram*elma;

        System.out.print("Domates Kaç Kilo ? :");
        kilogram=i.nextInt();
        result+=kilogram*domates;

        System.out.print("Muz Kaç Kilo ? :");
        kilogram=i.nextInt();
        result+=kilogram*muz;

        System.out.print("Patlıcan Kaç Kilo ? :");
        kilogram=i.nextInt();
        result+=kilogram*patlıcan;

        System.out.println("Toplam Tutar : "+result);
    }
}