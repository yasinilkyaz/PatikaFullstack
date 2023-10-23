import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Main {
    static ArrayList<Student> students=new ArrayList<>();

    public static void main(String[] args) throws IOException {
        getList();

        System.out.println(students);
        for (Student stu:students
             ) {



        }


    }


    public int random(ArrayList<String> studentLists) {
        Random random = new Random();
        int studentCount = 56;
        int randomIndex = random.nextInt(studentLists.size()) + 1;
        return randomIndex;

    }

    public static void getList(){
        try {

            FileReader fileReader=new FileReader("ogrencilistesi.txt");
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String readText;
            Student student=new Student();
            int number=0;
            String name="";


            int count=0;
            while ((readText = bufferedReader.readLine()) != null) {
                count++;
                if (count%2==1){
                    number= Integer.parseInt(readText);
                }else if(count%2==0){
                    name=readText;
                    student.setNumber(number);
                    student.setName(name);
                    students.add(student);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}