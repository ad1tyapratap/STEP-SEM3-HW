public class Q1_ExamHallSeatDuplicationChecker {

    static void checkDuplicateSeats(int[] seats) {
        boolean found = false;

        for (int i = 0; i < seats.length; i++) {
            boolean printed = false;

            for (int k = 0; k < i; k++) {
                if (seats[k] == seats[i])
                    printed = true;
            }

            if (printed)
                continue;

            for (int j = i + 1; j < seats.length; j++) {
                if (seats[i] == seats[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seats[i]);
                    found = true;
                    break;
                }
            }
        }

        if (!found)
            System.out.println("No Duplicate Seats Found");
    }

    public static void main(String[] args) {
        int[] seats = {101, 102, 103, 102, 105};
        checkDuplicateSeats(seats);
    }
}