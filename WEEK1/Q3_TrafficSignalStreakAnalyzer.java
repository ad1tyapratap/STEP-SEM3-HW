public class Q3_TrafficSignalStreakAnalyzer {

    static void findLongestStreak(String s) {
        if (s == null || s.isEmpty()) {
            System.out.println("Signal log is empty");
            return;
        }

        int count = 1, max = 1;
        char best = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1))
                count++;
            else
                count = 1;

            if (count > max) {
                max = count;
                best = s.charAt(i);
            }
        }

        System.out.println("Longest Streak: '" + best
                + "' repeated " + max + " times");
    }

    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");
    }
}