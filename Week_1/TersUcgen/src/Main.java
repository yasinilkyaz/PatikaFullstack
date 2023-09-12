import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Basamak Sayısını giriniz : ");

        int basamak = input.nextInt();

        System.out.println();


        int boslukIcinBasamak = basamak;

        int yildizSayisi = -1;

        for (int i = 0; i < basamak; i++) {

            yildizSayisi += 2;

        }

        for (int i = 0; i <= basamak; i++) {

            for (int k = boslukIcinBasamak; k < basamak; k++) {
                System.out.print(" ");
            }

            for (int j = 0; j < yildizSayisi; j++) {
                System.out.print("*");
            }

            yildizSayisi -= 2;

            boslukIcinBasamak--;

            System.out.println();
        }
    }
}