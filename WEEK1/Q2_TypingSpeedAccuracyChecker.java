public class Q2_TypingSpeedAccuracyChecker {

    static void checkTypingAccuracy(String original, String typed) {
        if (original.length() != typed.length()) {
            System.out.println("Strings must have equal length");
            return;
        }

        int matched = 0;
        int first = -1;

        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i))
                matched++;
            else if (first == -1)
                first = i;
        }

        double accuracy = (double) matched / original.length() * 100;

        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%",
                matched, original.length(), accuracy);

        if (first == -1) {
            System.out.println(" | No Mismatches");
        } else {
            System.out.println(" | First Mismatch at position " + (first + 1)
                    + " ('" + original.charAt(first) + "' vs '"
                    + typed.charAt(first) + "')");
        }
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
    }
}