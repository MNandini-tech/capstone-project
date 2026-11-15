
import java.util.Scanner;

public class RouteSeat {

    static Scanner sc = new Scanner(System.in);

    // Route details
    static String[] source = new String[10];
    static String[] destination = new String[10];
    static int[] distance = new int[10];
    static int routeCount = 0;

    // Bus details
    static String[] busName = new String[10];
    static int[] busRoute = new int[10];
    static int[] totalSeats = new int[10];
    static boolean[][] seats = new boolean[10][50];
    static int busCount = 0;

    // Booking details
    static int[] bookingId = new int[100];
    static String[] passengerName = new String[100];
    static int[] passengerAge = new int[100];
    static int[] bookedBus = new int[100];
    static int[] bookedSeat = new int[100];
    static double[] fare = new double[100];
    static boolean[] active = new boolean[100];
    static int bookingCount = 0;


    // 1. Add Route
    static void addRoute() {

        if (routeCount == 10) {
            System.out.println("Route limit reached!");
            return;
        }

        System.out.print("Enter source: ");
        source[routeCount] = sc.nextLine();

        System.out.print("Enter destination: ");
        destination[routeCount] = sc.nextLine();

        System.out.print("Enter distance in KM: ");
        distance[routeCount] = Integer.parseInt(sc.nextLine());

        if (distance[routeCount] <= 0) {
            System.out.println("Invalid distance!");
            return;
        }

        routeCount++;

        System.out.println("Route added successfully!");
    }


    // 2. Add Bus
    static void addBus() {

        if (routeCount == 0) {
            System.out.println("Please add a route first!");
            return;
        }

        if (busCount == 10) {
            System.out.println("Bus limit reached!");
            return;
        }

        viewRoutes();

        System.out.print("Enter route ID: ");
        int id = Integer.parseInt(sc.nextLine());

        if (id < 1 || id > routeCount) {
            System.out.println("Invalid route ID!");
            return;
        }

        System.out.print("Enter bus name: ");
        busName[busCount] = sc.nextLine();

        System.out.print("Enter number of seats (maximum 50): ");
        int count = Integer.parseInt(sc.nextLine());

        if (count < 1 || count > 50) {
            System.out.println("Invalid seat count!");
            return;
        }

        busRoute[busCount] = id - 1;
        totalSeats[busCount] = count;

        busCount++;

        System.out.println("Bus added successfully!");
    }


    // 3. View Routes
    static void viewRoutes() {

        System.out.println("\n--- ROUTE LIST ---");

        if (routeCount == 0) {
            System.out.println("No routes available!");
            return;
        }

        for (int i = 0; i < routeCount; i++) {
            System.out.println("Route ID: " + (i + 1));
            System.out.println(source[i] + " to " + destination[i]);
            System.out.println("Distance: " + distance[i] + " KM");
            System.out.println("----------------------");
        }
    }


    // 4. View Buses
    static void viewBuses() {

        System.out.println("\n--- BUS LIST ---");

        if (busCount == 0) {
            System.out.println("No buses available!");
            return;
        }

        for (int i = 0; i < busCount; i++) {

            int r = busRoute[i];

            System.out.println("Bus ID: " + (i + 1));
            System.out.println("Bus Name: " + busName[i]);
            System.out.println("Route: " + source[r] + " to " + destination[r]);
            System.out.println("Total Seats: " + totalSeats[i]);
            System.out.println("----------------------");
        }
    }


    // 5. Show Seat Map
    static void showSeatMap() {

        if (busCount == 0) {
            System.out.println("No buses available!");
            return;
        }

        viewBuses();

        System.out.print("Enter bus ID: ");
        int id = Integer.parseInt(sc.nextLine());

        if (id < 1 || id > busCount) {
            System.out.println("Invalid bus ID!");
            return;
        }

        int b = id - 1;

        System.out.println("\n--- SEAT MAP ---");
        System.out.println("A = Available, B = Booked");

        for (int i = 0; i < totalSeats[b]; i++) {

            if (seats[b][i] == false) {
                System.out.print((i + 1) + "[A]  ");
            } else {
                System.out.print((i + 1) + "[B]  ");
            }

            if ((i + 1) % 4 == 0) {
                System.out.println();
            }
        }

        System.out.println();
    }


    // 6. Book Ticket
    static void bookTicket() {

        if (busCount == 0) {
            System.out.println("No buses available!");
            return;
        }

        if (bookingCount == 100) {
            System.out.println("Booking limit reached!");
            return;
        }

        viewBuses();

        System.out.print("Enter bus ID: ");
        int b = Integer.parseInt(sc.nextLine()) - 1;

        if (b < 0 || b >= busCount) {
            System.out.println("Invalid bus ID!");
            return;
        }

        // Show available seats
        System.out.println("\nAvailable seats:");

        for (int i = 0; i < totalSeats[b]; i++) {
            if (seats[b][i] == false) {
                System.out.print((i + 1) + " ");
            }
        }

        System.out.println();

        System.out.print("Enter seat number: ");
        int seat = Integer.parseInt(sc.nextLine());

        if (seat < 1 || seat > totalSeats[b]) {
            System.out.println("Invalid seat number!");
            return;
        }

        if (seats[b][seat - 1] == true) {
            System.out.println("Seat already booked!");
            return;
        }

        System.out.print("Enter passenger name: ");
        String name = sc.nextLine();

        System.out.print("Enter passenger age: ");
        int age = Integer.parseInt(sc.nextLine());

        if (age <= 0) {
            System.out.println("Invalid age!");
            return;
        }

        // Calculate fare
        int r = busRoute[b];
        double amount = distance[r] * 2;

        System.out.println("Ticket fare: Rs. " + amount);

        System.out.print("Enter payment amount: ");
        double paid = Double.parseDouble(sc.nextLine());

        if (paid < amount) {
            System.out.println("Insufficient payment!");
            System.out.println("Booking not completed.");
            return;
        }

        // Store booking details
        bookingId[bookingCount] = bookingCount + 1;
        passengerName[bookingCount] = name;
        passengerAge[bookingCount] = age;
        bookedBus[bookingCount] = b;
        bookedSeat[bookingCount] = seat;
        fare[bookingCount] = amount;
        active[bookingCount] = true;

        // Mark seat as booked
        seats[b][seat - 1] = true;

        System.out.println("\n--- TICKET CONFIRMATION ---");
        System.out.println("Booking ID: " + bookingId[bookingCount]);
        System.out.println("Passenger: " + name);
        System.out.println("Age: " + age);
        System.out.println("Seat Number: " + seat);
        System.out.println("Fare: Rs. " + amount);
        System.out.println("Payment: Rs. " + paid);
        System.out.println("Change: Rs. " + (paid - amount));
        System.out.println("Booking successful!");

        bookingCount++;
    }


    // 7. Cancel Booking
    static void cancelBooking() {

        System.out.print("Enter booking ID: ");
        int id = Integer.parseInt(sc.nextLine());

        int index = -1;

        // Find the booking
        for (int i = 0; i < bookingCount; i++) {

            if (bookingId[i] == id && active[i] == true) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Booking not found!");
            return;
        }

        System.out.print("Enter hours before departure: ");
        int hours = Integer.parseInt(sc.nextLine());

        if (hours < 0) {
            System.out.println("Invalid hours!");
            return;
        }

        double refund;

        if (hours >= 24) {
            refund = fare[index] * 0.90;
        } else if (hours >= 6) {
            refund = fare[index] * 0.50;
        } else {
            refund = 0;
        }

        // Make the seat available again
        int b = bookedBus[index];
        int s = bookedSeat[index];

        seats[b][s - 1] = false;
        active[index] = false;

        System.out.println("Booking cancelled successfully!");
        System.out.println("Refund amount: Rs. " + refund);
    }


    // 8. Passenger List
    static void passengerList() {

        if (busCount == 0) {
            System.out.println("No buses available!");
            return;
        }

        viewBuses();

        System.out.print("Enter bus ID: ");
        int id = Integer.parseInt(sc.nextLine());

        if (id < 1 || id > busCount) {
            System.out.println("Invalid bus ID!");
            return;
        }

        System.out.println("\n--- PASSENGER LIST ---");

        boolean found = false;

        for (int i = 0; i < bookingCount; i++) {

            if (bookedBus[i] == id - 1 && active[i] == true) {

                System.out.println("Booking ID: " + bookingId[i]);
                System.out.println("Name: " + passengerName[i]);
                System.out.println("Age: " + passengerAge[i]);
                System.out.println("Seat Number: " + bookedSeat[i]);
                System.out.println("----------------------");

                found = true;
            }
        }

        if (found == false) {
            System.out.println("No passengers found!");
        }
    }


    // Main Method
    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== ROUTESEAT SYSTEM =====");
            System.out.println("1. Add Route");
            System.out.println("2. Add Bus");
            System.out.println("3. View Routes");
            System.out.println("4. View Buses");
            System.out.println("5. Show Seat Map");
            System.out.println("6. Book Ticket");
            System.out.println("7. Cancel Booking");
            System.out.println("8. Passenger List");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    addRoute();
                    break;

                case 2:
                    addBus();
                    break;

                case 3:
                    viewRoutes();
                    break;

                case 4:
                    viewBuses();
                    break;

                case 5:
                    showSeatMap();
                    break;

                case 6:
                    bookTicket();
                    break;

                case 7:
                    cancelBooking();
                    break;

                case 8:
                    passengerList();
                    break;

                case 0:
                    System.out.println("Thank you for using RouteSeat!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}
