import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Tam sayı giriniz : ");

        int tamSayi = input.nextInt();

        System.out.println("Ondalıklı sayı giriniz : ");

        double ondalikliSayi = input.nextDouble();


        int tamSayiyaCevir = (int) ondalikliSayi;

        System.out.println("Tam sayı olarak girilen değerin ondalık sonucu : " + (double) tamSayi);
        System.out.println("Ondalıklı olarak girilen değerin tam sayı sonucu : " + tamSayiyaCevir);
    }
}