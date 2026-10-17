public class Q5_MovieReviewWordLengthProfiler {

    static void classifyWordLengths(String review) {
        int shortWords = 0, mediumWords = 0, longWords = 0;

        String text = review.trim();

        if (text.isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }

        String[] words = text.split("\\s+");

        for (String word : words) {
            int len = word.length();

            if (len <= 4)
                shortWords++;
            else if (len <= 8)
                mediumWords++;
            else
                longWords++;
        }

        System.out.println("Short: " + shortWords
                + " | Medium: " + mediumWords
                + " | Long: " + longWords);
    }

    public static void main(String[] args) {
        classifyWordLengths(
                "This movie was absolutely fantastic and thrilling");
    }
}