import java.util.*;

public class Q3_CampusPremiereTicketCounter {

    static class Customer {
        String name;

        Customer(String name) {
            this.name = name;
        }
    }

    static class Seat {
        String id;
        double price;
        boolean booked;

        Seat(String id, double price) {
            this.id = id;
            this.price = price;
        }
    }

    static class Show {
        String time;
        boolean started = false;
        Map<String, Seat> seats = new LinkedHashMap<>();

        Show(String time) {
            this.time = time;
        }

        void addSeat(String id, double price) {
            seats.put(id, new Seat(id, price));
        }
    }

    static class Booking {
        Customer customer;
        Show show;
        List<Seat> bookedSeats = new ArrayList<>();
        boolean cancelled = false;

        Booking(Customer c, Show s, String... ids) {
            customer = c;
            show = s;

            if (ids.length == 0 || ids.length > 6) {
                System.out.println("Booking must contain 1 to 6 seats.");
                return;
            }

            for (String id : ids) {
                Seat seat = s.seats.get(id);

                if (seat == null || seat.booked) {
                    System.out.println("Seat " + id
                            + " is already booked for this show.");
                    return;
                }
            }

            for (String id : ids) {
                Seat seat = s.seats.get(id);
                seat.booked = true;
                bookedSeats.add(seat);
            }

            System.out.print("Booking confirmed for " + c.name + ": ");

            for (int i = 0; i < bookedSeats.size(); i++) {
                if (i > 0)
                    System.out.print(", ");
                System.out.print(bookedSeats.get(i).id);
            }

            System.out.printf(". Total: ₹%.2f.%n", getTotal());
        }

        double getTotal() {
            double total = 0;

            for (Seat s : bookedSeats)
                total += s.price;

            return total;
        }

        void cancel() {
            if (show.started) {
                System.out.println("Cannot cancel after the show starts.");
                return;
            }

            if (cancelled || bookedSeats.isEmpty())
                return;

            for (Seat s : bookedSeats)
                s.booked = false;

            cancelled = true;

            System.out.println(customer.name + "'s booking cancelled.");

            System.out.print("Seats ");

            for (int i = 0; i < bookedSeats.size(); i++) {
                if (i > 0)
                    System.out.print(", ");
                System.out.print(bookedSeats.get(i).id);
            }

            System.out.println(" released.");
        }
    }

    public static void main(String[] args) {
        Show show = new Show("7 PM");

        show.addSeat("A1", 150);
        show.addSeat("A2", 150);
        show.addSeat("F5", 250);
        show.addSeat("R1", 400);

        Customer asha = new Customer("Asha");
        Customer ravi = new Customer("Ravi");
        Customer neha = new Customer("Neha");

        Booking b1 = new Booking(asha, show, "A1", "A2", "F5");
        new Booking(ravi, show, "A2");
        new Booking(ravi, show, "R1");

        b1.cancel();

        new Booking(neha, show, "A2");
    }
}