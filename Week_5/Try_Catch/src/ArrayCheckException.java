public class ArrayCheckException extends Exception{
    public ArrayCheckException(String message) {
        super(message);

    }

    @Override
    public String toString() {
        return getMessage();
        //getMessage metodunu silip aşağıdakinide yazabilirsin.
        //"ArrayCheckException{ Array boyutu hatası }";
    }
}
