import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner i=new Scanner(System.in);

        System.out.print("Lütfen boyunuzu (metre cinsinde) giriniz : ");
        double length=i.nextDouble();

        System.out.print("Lütfen kilonuzu giriniz : ");
        double weight=i.nextDouble();

        double result=weight/(length*length);
        System.out.println("Vücut Kitle İndeksiniz : "+result);

    }
}