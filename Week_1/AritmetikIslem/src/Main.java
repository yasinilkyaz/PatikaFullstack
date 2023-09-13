import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input=new Scanner(System.in);

        System.out.print("A değerini giriniz : ");
        int a=input.nextInt();

        System.out.print("B değerini giriniz : ");
        int b=input.nextInt();

        System.out.print("C değerini giriniz : ");
        int c=input.nextInt();

        int result= a+b*c-b;

        System.out.println("Formül : A+B*C-B");

        System.out.println(result);

    }
}