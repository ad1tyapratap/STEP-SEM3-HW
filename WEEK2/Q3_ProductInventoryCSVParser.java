public class Q3_ProductInventoryCSVParser {

    static void parseInventoryRecord(String csvLine) {
        String[] data = csvLine.split(",", -1);

        if (data.length != 3) {
            System.out.println("Invalid Record");
        } else {
            System.out.println("Product: " + data[0]
                    + " | SKU: " + data[1]
                    + " | Qty: " + data[2]);
        }
    }

    public static void main(String[] args) {
        parseInventoryRecord("Wireless Mouse,WM-2201,150");
    }
}