import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input=new Scanner(System.in);

        System.out.print("Basamak değerini giriniz : ");

        int elemanSayisi=input.nextInt();

        System.out.println();

        int [] fibonacci =new int[elemanSayisi];

        fibonacci[0]=1;
        fibonacci[1]=1;

        for(int i=2; i<elemanSayisi;i++){

        fibonacci[i]=fibonacci[i-2]+fibonacci[i-1];

        }

        System.out.println(Arrays.toString(fibonacci));
    }
}