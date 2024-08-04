import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Stack;

class User {
    private Customer currentUser;
    private Stack<Booking> bookingHistory = new Stack<>();

    public boolean register(String name, String email, String phone) {
        Customer customer = new Customer(Database.customers.size() + 1, name, email, phone);
        Database.customers.add(customer);
        this.currentUser = customer;
        System.out.println("Registration successful.");
        return true;
    }

    public boolean login(String email) {
        for (Customer customer : Database.customers) {
            if (customer.getEmail().equals(email)) {
                this.currentUser = customer;
                System.out.println("Login successful.");
                return true;
            }
        }
        System.out.println("User not found.");
        return false;
    }

    public List<Movie> searchMovies(String title, String language, String genre, String cityName) {
        List<Movie> results = new ArrayList<>();
        for (Movie movie : Database.movies) {
            boolean matches = true;
            if (!title.isEmpty() && !movie.getTitle().equalsIgnoreCase(title)) matches = false;
            if (!language.isEmpty() && !movie.getLanguage().equalsIgnoreCase(language)) matches = false;
            if (!genre.isEmpty() && !movie.getGenre().equalsIgnoreCase(genre)) matches = false;
            // Add filtering logic for city based on show times and cinema locations
            if (matches) results.add(movie);
        }
        return results;
    }

    public void bookTickets(Show show, List<Seat> selectedSeats, Coupon coupon) {
        double totalAmount = calculateTotalAmount(selectedSeats, coupon);
        Booking booking = new Booking(Database.bookings.size() + 1, new Date(), totalAmount, currentUser, show, selectedSeats, coupon);
        Database.bookings.add(booking);
        bookingHistory.push(booking);
        System.out.println("Booking successful.");
    }

    private double calculateTotalAmount(List<Seat> selectedSeats, Coupon coupon) {
        double amount = selectedSeats.size() * 10.0; // Assume $10 per seat
        if (coupon != null) {
            amount -= (amount * coupon.getDiscountPercentage() / 100);
        }
        return amount;
    }

    public void viewBookingHistory() {
        if (bookingHistory.isEmpty()) {
            System.out.println("No booking history found.");
        } else {
            for (Booking booking : bookingHistory) {
                System.out.println(booking);
            }
        }
    }

    public void makePayment(Booking booking) {
        // Payment logic here
        System.out.println("Payment made successfully for Booking ID: " + booking.getBookingId());
    }
}
