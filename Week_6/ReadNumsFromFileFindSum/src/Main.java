import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        File file=new File("sayilar.txt");

        if (!file.exists()){
            file.createNewFile();
        }

        FileReader reader=new FileReader(file);
        BufferedReader bufferedReader=new BufferedReader(reader);

        String line;
        int sum=0;
        while ((line=bufferedReader.readLine())!=null){
            System.out.println("   "+line);
            sum+=Integer.parseInt(line);
        }

        System.out.println("+____");
        System.out.println("   "+sum);
    }
}