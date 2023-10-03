import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ArrayCheckException {
        int [] arr= {0,1,2,3,4,5,6,7,8,9};
        Scanner input=new Scanner(System.in);
        int index=input.nextInt();
        try {
            checkArray(arr,index);
            System.out.println("indeks değeri : "+arr[index]);
        }catch (ArrayCheckException e){
            System.out.println(e.toString());
        }
    }

    public static void checkArray(int[] a, int index) throws ArrayCheckException {
        if(index>=a.length && index>0){
            throw new ArrayCheckException("Uygun Aralıkta değil");
        }else {
            System.out.println("Uygun");
        }
    }
}