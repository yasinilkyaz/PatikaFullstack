import java.util.Scanner;

public class Main {

    static int sayiDusur(int sayi, int n) {
        System.out.print(sayi+" ");
        if (sayi > 0) {

            sayi -= 5;

            return sayiDusur(sayi,n);

        } else {
            sayiArttır(sayi, n);
        }
        return 0;
    }

    static int sayiArttır(int sayi, int n) {
        if (sayi < n) {

            sayi +=5;

            System.out.print(sayi+" ");

            return sayiArttır(sayi,n);
        }
        else {
            return sayi;
        }
    }


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("N sayısı : ");

        int n = input.nextInt();

        System.out.print("Çıktısı : ");
        sayiDusur(n,n);



    }
}