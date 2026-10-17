public class Q4_HotWeatherAlertWindows {
    public static void main(String[] args) {
        int[] readings = {2, 2, 2, 2, 5, 5, 5, 8};
        int k = 3, threshold = 4;

        int sum = 0, count = 0;

        for (int i = 0; i < k; i++)
            sum += readings[i];

        if (sum >= k * threshold)
            count++;

        for (int i = k; i < readings.length; i++) {
            sum += readings[i] - readings[i - k];

            if (sum >= k * threshold)
                count++;
        }

        System.out.println(count);
    }
}