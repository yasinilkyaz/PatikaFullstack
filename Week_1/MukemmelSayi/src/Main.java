import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int bolen = 1;
        int tamBolen = 0;
        int sayi;

        Scanner input = new Scanner(System.in);

        System.out.print("Bir sayı giriniz: ");

        sayi = input.nextInt();

        while (bolen != sayi) {

            if (sayi % bolen == 0) {
                tamBolen += bolen;
            }
            bolen++;

        }

        if (sayi == tamBolen) {
            System.out.println(sayi + " Mükemmel sayıdır.");
        }

        else {
            System.out.println(sayi + " Mükemmel sayı değildir.");
        }

    }
}