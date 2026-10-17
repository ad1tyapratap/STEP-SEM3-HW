public class Q5_TicketPriceSlotFinder {
    public static void main(String[] args) {
        int[] prices = {120, 150, 200, 260};
        int newPrice = 210;

        int low = 0, high = prices.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (prices[mid] == newPrice) {
                low = mid;
                break;
            } else if (prices[mid] < newPrice) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(low);
    }
}