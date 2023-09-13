import java.util.Scanner;

public class Main {

    static boolean sayiAsalMi(int sayi,int bolen){

        if (sayi==bolen){return true;}

        if(sayi%bolen==0){
            return false;
        }else {
            return sayiAsalMi(sayi,bolen+1);
        }

    }

    public static void main(String[] args) {

        Scanner input=new Scanner(System.in);

        System.out.print("Sayı Giriniz : ");

        int sayi=input.nextInt();

        System.out.println(sayi+" sayısı "+(sayiAsalMi(sayi,2) ? "ASALDIR !":"ASAL değildir. !"));

    }
}