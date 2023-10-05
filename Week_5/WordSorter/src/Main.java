import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String text = input.nextLine();

        String[] word = text.split(" ", 100);

        HashMap<String, Integer> words = new HashMap<>();

        for (int i = 0; i < word.length; i++) {
            int count = 0;
            for (int j = 0; j < word.length; j++) {

                if (word[i].equals(word[j])) {
                    count++;
                }
                words.put(word[i], count);
            }

        }
        int repeatValue = 0;
        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            if (entry.getValue() > repeatValue) {
                repeatValue = entry.getValue();
            }
        }
        System.out.println("En çok Tekrar eden kelime :" + getKeyByValue(words, repeatValue) + "\t Tekrar Sayısı :" + repeatValue);

    }

    public static <K, V> K getKeyByValue(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }
}