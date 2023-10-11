import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        File file = new File("texts.txt");

        try {


            //Dosya yoksa oluştur
            if (!file.exists()) {
                file.createNewFile();
            }

            //Mevcuttaki dosya içerindeki metin program içine alınıyor.

            FileReader fileReader = new FileReader("texts.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String readText;

            //Alınan metin yazdırılıyor

            while ((readText = bufferedReader.readLine()) != null) {
                System.out.println(readText);
            }

            bufferedReader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Yeni metin kullanıcıdan alınıyor.

        Scanner scanner = new Scanner(System.in);
        System.out.print("Bir metin girin: ");
        String metin = scanner.nextLine();

        scanner.close();

        try {
            //Dışardaki dosyaya yazdırma işlemi için FileWriter ve PrintWriter nesneleri üretiyoruz

            FileWriter fileWriter = new FileWriter("texts.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            //Bu metot kullanıcıdan aldğığmız metini dosyaya yazdırır.
            printWriter.print(metin);

            printWriter.close();
            fileWriter.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}