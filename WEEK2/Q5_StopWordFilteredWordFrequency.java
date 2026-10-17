import java.util.*;

public class Q5_StopWordFilteredWordFrequency {

    static void printFilteredWordFrequency(String feedback) {
        String text = feedback.toLowerCase()
                .replace(".", "")
                .replace(",", "");

        String[] words = text.split("\\s+");

        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};

        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            if (word.isEmpty())
                continue;

            boolean stop = false;

            for (String s : stopWords) {
                if (word.equals(s)) {
                    stop = true;
                    break;
                }
            }

            if (!stop)
                map.put(word, map.getOrDefault(word, 0) + 1);
        }

        ArrayList<String> list = new ArrayList<>(map.keySet());

        list.sort((a, b) -> map.get(b) - map.get(a));

        for (String word : list)
            System.out.println(word + ": " + map.get(word));
    }

    public static void main(String[] args) {
        printFilteredWordFrequency(
                "The mentor was great, the session was great and clear.");
    }
}