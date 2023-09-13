import java.util.Scanner;

public class Main {

    static int usluSayiHesapla(int taban,int us){

        int result=taban;
        if(us==0)return 1;
        if(us==1){
            return result;
        }else {return usluSayiHesapla(taban,us-1)*result;}

    }

    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);

        System.out.print("Taban değeri giriniz : ");
        int taban=input.nextInt();

        System.out.print("Üs değerini giriniz : ");
        int us=input.nextInt();

        System.out.println("Sonuç : "+usluSayiHesapla(taban,us));

    }
}