import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner i=new Scanner(System.in);

        int mesafe,yas,tip;
        double mesafeUcreti=0.1;
        double indirimOrani=0;

        System.out.print("Mesafeyi km türünden giriniz : ");
        mesafe=i.nextInt();

        System.out.print("Yaşınızı giriniz : ");
        yas=i.nextInt();

        System.out.print("Yolculuk tipini giriniz (1 => Tek Yön , 2 => Gidiş Dönüş ): ");
        tip=i.nextInt();

        //Genel girdi kontrolü

        if(mesafe < 1 && yas < 1&& tip>0||tip<3){
            double yolTutar=mesafe*mesafeUcreti;

            if(yas<12){
                indirimOrani=0.5;
            } else if (yas>=12 && yas<=24) {
                indirimOrani=0.1;

            } else if (yas>65) {
                indirimOrani=0.3;

            }else {
                indirimOrani=0;
            }
            double indirimliTutar=yolTutar*indirimOrani;
            yolTutar-=indirimliTutar;

            if(tip==2){
                double donusIndirimiOrani=0.2;
                double donusIndirimi=yolTutar*donusIndirimiOrani;
                double toplamTutar=(yolTutar-donusIndirimi)*2;
                System.out.println("Toplam Tutar = "+toplamTutar+" TL");


            }else {
                System.out.println("Toplam Tutar = "+yolTutar+" TL");
            }

        }else {
            System.out.println("Hatalı Veri Girdiniz");
        }

    }
}