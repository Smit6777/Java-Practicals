
import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {
        String paragraph = " smit is smart smit is hardworking smit is creative";

        String[] words = paragraph.toLowerCase().split("\\s+");

        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(frequency.entrySet());

        list.sort((a, b) -> {
            int result = b.getValue().compareTo(a.getValue());
            if (result == 0) {
                return a.getKey().compareTo(b.getKey());
            }
            return result;
        });

        System.out.println("Word Frequencies:");

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
