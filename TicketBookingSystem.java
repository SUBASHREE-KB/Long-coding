import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TicketBookingSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        prepopulateData();
        System.out.println("Welcome to the Ticket Booking System");
        System.out.println("1. Admin");
        System.out.println("2. User");
        System.out.print("Select an option: ");
        int option = scanner.nextInt();

        if (option == 1) {
            adminOperations(scanner);
        } else if (option == 2) {
            userOperations(scanner);
        } else {
            System.out.println("Invalid option.");
        }

        scanner.close();
    }

    private static void adminOperations(Scanner scanner) {
        while (true) {
            System.out.println("Admin Operations:");
            System.out.println("1. Add Movie");
            System.out.println("2. Update Movie");
            System.out.println("3. Delete Movie");
            // Other admin operations...

            System.out.print("Enter choice (or 0 to exit): ");
            int choice = scanner.nextInt();
            if (choice == 0) break;

            switch (choice) {
                case 1:
                    System.out.println("Enter Movie Details:");
                    System.out.print("Title: ");
                    scanner.nextLine(); // consume newline
                    String title = scanner.nextLine();
                    System.out.print("Language: ");
                    String language = scanner.nextLine();
                    System.out.print("Genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Release Date (yyyy-MM-dd): ");
                    String releaseDateStr = scanner.nextLine();
                    Date releaseDate = parseDate(releaseDateStr);
                    Movie movie = new Movie(Database.movies.size() + 1, title, language, genre, releaseDate);
                    Admin.addMovie(movie);
                    break;
                case 2:
                    System.out.print("Enter Movie ID to update: ");
                    int movieId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Language: ");
                    String newLanguage = scanner.nextLine();
                    System.out.print("Genre: ");
                    String newGenre = scanner.nextLine();
                    System.out.print("Release Date (yyyy-MM-dd): ");
                    String newReleaseDateStr = scanner.nextLine();
                    Date newReleaseDate = parseDate(newReleaseDateStr);
                    Admin.updateMovie(movieId, newTitle, newLanguage, newGenre, newReleaseDate);
                    break;
                case 3:
                    System.out.print("Enter Movie ID to delete: ");
                    int deleteMovieId = scanner.nextInt();
                    Admin.deleteMovie(deleteMovieId);
                    break;
                // Handle other admin operations...
            }
        }
    }

    private static void userOperations(Scanner scanner) {
        User user = new User();
        System.out.println("1. Register");
        System.out.println("2. Login");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (choice == 1) {
            System.out.println("Enter Registration Details:");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Phone: ");
            String phone = scanner.nextLine();
            user.register(name, email, phone);
        } else if (choice == 2) {
            System.out.println("Enter Login Email:");
            String email = scanner.nextLine();
            if (!user.login(email)) {
                return;
            }
        }

        while (true) {
            System.out.println("User Operations:");
            System.out.println("1. Search Movies");
            System.out.println("2. Book Tickets");
            System.out.println("3. View Booking History");
            System.out.println("4. Make Payment");

            System.out.print("Enter choice (or 0 to exit): ");
            int userChoice = scanner.nextInt();
            if (userChoice == 0) break;

            switch (userChoice) {
                case 1:
                    System.out.print("Title (or leave blank): ");
                    scanner.nextLine(); // consume newline
                    String title = scanner.nextLine();
                    System.out.print("Language (or leave blank): ");
                    String language = scanner.nextLine();
                    System.out.print("Genre (or leave blank): ");
                    String genre = scanner.nextLine();
                    System.out.print("City (or leave blank): ");
                    String cityName = scanner.nextLine();
                    List<Movie> movies = user.searchMovies(title, language, genre, cityName);
                    if (movies.isEmpty()) {
                        System.out.println("No movies found.");
                    } else {
                        System.out.println("Movies Found: ");
                        movies.forEach(System.out::println);
                    }
                    break;
                case 2:
                    System.out.print("Enter Show ID to book: ");
                    int showId = scanner.nextInt();
                    Show show = Database.shows.stream().filter(s -> s.getShowId() == showId).findFirst().orElse(null);
                    if (show == null) {
                        System.out.println("Show not found.");
                        break;
                    }
                    List<Seat> selectedSeats = new ArrayList<>();
                    System.out.print("Enter number of seats: ");
                    int numSeats = scanner.nextInt();
                    for (int i = 0; i < numSeats; i++) {
                        System.out.print("Enter Seat ID: ");
                        int seatId = scanner.nextInt();
                        Seat seat = Database.seats.stream().filter(s -> s.getSeatId() == seatId).findFirst().orElse(null);
                        if (seat != null) {
                            selectedSeats.add(seat);
                        } else {
                            System.out.println("Invalid Seat ID.");
                        }
                    }
                    System.out.print("Enter Coupon Code (or leave blank): ");
                    scanner.nextLine(); // consume newline
                    String couponCode = scanner.nextLine();
                    Coupon coupon = Database.coupons.stream().filter(c -> c.getCode().equalsIgnoreCase(couponCode)).findFirst().orElse(null);
                    user.bookTickets(show, selectedSeats, coupon);
                    break;
                case 3:
                    user.viewBookingHistory();
                    break;
                case 4:
                    System.out.print("Enter Booking ID to make payment: ");
                    int bookingId = scanner.nextInt();
                    Booking booking = Database.bookings.stream().filter(b -> b.getBookingId() == bookingId).findFirst().orElse(null);
                    if (booking != null) {
                        user.makePayment(booking);
                    } else {
                        System.out.println("Booking not found.");
                    }
                    break;
                // Handle other user operations...
            }
        }
    }

    private static Date parseDate(String dateStr) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void prepopulateData() {
        // Prepopulate cities
        City city1 = new City(1, "New York");
        City city2 = new City(2, "Los Angeles");
        Database.cities.add(city1);
        Database.cities.add(city2);

        // Prepopulate cinemas
        Cinema cinema1 = new Cinema(1, "Cinema One", "123 Main St", city1);
        Cinema cinema2 = new Cinema(2, "Cinema Two", "456 Elm St", city2);
        Database.cinemas.add(cinema1);
        Database.cinemas.add(cinema2);

        // Prepopulate halls
        Hall hall1 = new Hall(1, "A100",cinema1,50);
        Hall hall2 = new Hall(2, "Main",cinema2,100);
        Database.halls.add(hall1);
        Database.halls.add(hall2);

        // Prepopulate movies
        Movie movie1 = new Movie(1, "Inception", "English", "Sci-Fi", new Date());
        Movie movie2 = new Movie(2, "Parasite", "Korean", "Thriller", new Date());
        Database.movies.add(movie1);
        Database.movies.add(movie2);

        // Prepopulate shows
        Show show1 = new Show(1, "10:00 AM", "12:30 PM", hall1, movie1);
        Show show2 = new Show(2, "01:00 PM", "03:30 PM", hall2, movie2);
        Database.shows.add(show1);
        Database.shows.add(show2);

        for (Hall hall : Database.halls) {
            for (int i = 1; i <= hall.getCapacity(); i++) {
                Seat seat = new Seat(i, i, hall);
                Database.seats.add(seat);
            }
        }

        // Prepopulate coupons
        Coupon coupon1 = new Coupon(1, "SAVE10", 10);
        Database.coupons.add(coupon1);
    }
}
