
class CinemaBooking {
    String movieName;
    double ticketPrice;
    int numberOfTickets;
    String customerName;
    CinemaBooking() {
        movieName = "UNKNOWN";
        ticketPrice = 0;
        numberOfTickets = 0;
        customerName = "UNKNOWN";
    }
    CinemaBooking(String movieName, double ticketPrice,
                  int numberOfTickets, String customerName) {
        this.movieName = movieName;
        this.ticketPrice = ticketPrice;
        this.numberOfTickets = numberOfTickets;
        this.customerName = customerName;
    }
    void bookTickets(int tickets) {
        numberOfTickets = tickets;
    }
    void bookTickets(int tickets, String customer) {
        numberOfTickets = tickets;
        customerName = customer;
    }
    double calculateAmount() {
        if (numberOfTickets <= 0 || ticketPrice <= 0) {
            return -1;
        }
        double total = ticketPrice * numberOfTickets;
         if (numberOfTickets >= 5) {
            total = total - (total * 0.10);
        }

        return total;
    }

    boolean compareCustomer(String name) {
        return customerName.equalsIgnoreCase(name);
    }
    void displayBooking() {
        System.out.println("\n--- CINEMA BOOKING SUMMARY ---");
        System.out.println("Movie Name: " + movieName.toUpperCase());
        System.out.println("Customer Name: " + customerName.toUpperCase());
        System.out.println("Ticket Price: Rs. " + ticketPrice);
        System.out.println("Number of Tickets: " + numberOfTickets);

        if (numberOfTickets <= 0 || ticketPrice <= 0) {
            System.out.println("Invalid booking details!");
            return;
        }

        double total = ticketPrice * numberOfTickets;
        System.out.println("Total Amount: Rs. " + total);

        if (numberOfTickets >= 5) {
            System.out.println("Discount: 10%");
        } else {
            System.out.println("Discount: 0%");
        }

        System.out.println("Final Amount: Rs. " + calculateAmount());
    }
}
public class Main {
    public static void main(String[] args) {
        CinemaBooking b1 = new CinemaBooking(
            "salar", 200, 5, "Rahul"
        );
        b1.displayBooking();

        CinemaBooking b2 = new CinemaBooking();
        b2.movieName = "Avengers";
        b2.ticketPrice = 180;
        b2.bookTickets(3, "Arun");
        b2.displayBooking();
         System.out.println("\n--- CUSTOMER VERIFICATION ---");
        if (b1.compareCustomer("rahul")) {
            System.out.println("Customer name matched.");
        } else {
            System.out.println("Customer name did not match.");
        }
    }
}
