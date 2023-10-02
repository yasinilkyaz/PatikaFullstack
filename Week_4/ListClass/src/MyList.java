import java.util.Arrays;

public class MyList<T> {
    private Object[] data;
    private Object[] subData;
    private int size;


    public MyList() {
        this.data = new Object[10];
        this.size = 0;

    }

    public MyList(int capacity) {
        if (capacity < 0) {
            System.out.println("Geçerli sayı giriniz");
        }
        this.data = new Object[capacity];
        this.size = 0;
    }

    public MyList(T[] subData,int size) {
        this.data=subData;
        this.size=size;
    }

    public int size() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public void add(T item) {
        if (size == data.length) {
            int newCapacity = getCapacity() * 2;
            Object[] newData = new Object[newCapacity];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
        data[size] = item;
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Geçersiz değer girdiniz");
        }
        return (T) data[index];
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        T rmItem = (T) data[index];
        for (int i = index; i < size - 1; i++) {
            data[i]=data[i+1];

        }
        data[size-1]=null;
        size--;
        return rmItem;
    }
    public T set(int index,T item){
        if (index < 0 || index >= size) {
            return null;
        }

           data[index]=item;
        return (T) data[index];
    }

    public  String toString() {

        int iMax = size - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(String.valueOf(data[i]));
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }

    public boolean isEmpty() {

        for (int i=0;i<data.length;i++){
            if (data[i]!=null){
                return false;
            }
        }
        return true;
    }

    public int indexOf(T j) {
        for (int i=0;i<size;i++){
            if (data[i]==j){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T j) {
        for (int i=size;i>0;i--){
            if (data[i]==j){
                return i;
            }
        }
        return -1;
    }

    public Object[] toArray() {
        return data;
    }

    public MyList<T> subList(int start, int finish) {
        if (start < 0 || finish > data.length || start > finish) {
            System.out.println("Uygun değer giriniz");
        }
        int size=finish-start;
        T[] subData = (T[]) Arrays.copyOfRange(data, start, finish);
        return new MyList<>(subData,size);
    }

    public boolean contains(T i) {
        boolean isContains=false;
        for (int j=0;j<data.length;j++){
            if (data[j]==i){
                isContains=true;
            }
        }
        return isContains;
    }

    public void clear() {
        for (int i=0;i<data.length;i++){
            data[i]=null;
        }
        size=0;
    }
}
