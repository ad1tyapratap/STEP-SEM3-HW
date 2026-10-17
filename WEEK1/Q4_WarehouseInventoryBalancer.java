public class Q4_WarehouseInventoryBalancer {

    static void analyzeInventory(int[] a, int[] b) {
        if (a.length != b.length || a.length == 0) {
            System.out.println("Arrays must have equal, non-zero length");
            return;
        }

        int sumA = 0, sumB = 0;
        int max = Integer.MIN_VALUE;
        String section = "";
        int item = 0;

        for (int i = 0; i < a.length; i++) {
            sumA += a[i];
            sumB += b[i];

            if (a[i] > max) {
                max = a[i];
                section = "Section A";
                item = i + 1;
            }

            if (b[i] > max) {
                max = b[i];
                section = "Section B";
                item = i + 1;
            }
        }

        String status = (sumA == sumB) ? "Balanced" : "Not Balanced";

        System.out.println("Section A Total: " + sumA
                + " | Section B Total: " + sumB
                + " | Status: " + status);

        System.out.println("Highest Quantity: " + max
                + " (" + section + ", Item " + item + ")");
    }

    public static void main(String[] args) {
        int[] a = {20, 15, 30};
        int[] b = {25, 10, 30};

        analyzeInventory(a, b);
    }
}