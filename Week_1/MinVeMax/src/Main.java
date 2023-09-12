
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int girdiSayisi;

        int sayac = 0;

        Scanner input = new Scanner(System.in);

        System.out.print("Kaç tane sayı gireceksiniz: ");

        girdiSayisi = input.nextInt();

        int[] sayilar = new int[girdiSayisi];


        while (sayac != girdiSayisi) {

            int hangiEleman = sayac + 1;

            System.out.print(hangiEleman + ". Sayıyı giriniz: ");

            int deger = input.nextInt();

            sayilar[sayac] = deger;

            sayac++;

        }

        Arrays.sort(sayilar);

        System.out.println("En büyük sayı: " + sayilar[girdiSayisi - 1]);

        System.out.println("En küçük sayı: " + sayilar[0]);

    }
}