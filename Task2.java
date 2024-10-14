import java.util.Scanner;

public class HotelReservationSystem {
    static boolean[] rooms = new boolean[200];  
    static String[] guestNames = new String[200]; 
    static double[] payments = new double[200];  
    static double[] tips = new double[200];  

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = 0; // Initialize option

        while (option != 4) { 
            System.out.println("_Welcome to Taj Hotel_");
            System.out.println("Please select any of the options:");
            System.out.println("1. Make a reservation");
            System.out.println("2. Check reservation");
            System.out.println("3. Checkout");
            System.out.println("4. Exit");

            option = scanner.nextInt(); 

            switch (option) {
                case 1:
                    makeReservation(scanner);
                    break;
                case 2:
                    checkReservation(scanner);
                    break;
                case 3:
                    checkout(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using the hotel reservation system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

    public static void makeReservation(Scanner scanner) {
        displayRoomAvailability();

        System.out.print("Select a room to reserve (enter room number): ");
        int roomNumber = scanner.nextInt();

        if (roomNumber >= 1 && roomNumber <= 200 && !rooms[roomNumber - 1]) {
            rooms[roomNumber - 1] = true;  
            System.out.print("Enter your name: ");
            String guestName = scanner.next();
            guestNames[roomNumber - 1] = guestName;  

            double price;
            if (roomNumber <= 100) {
                price = 100; 
                System.out.println("You selected a Standard Room. Price: $" + price);
            } else {
                price = 200;  
                System.out.println("You selected a Deluxe Room. Price: $" + price);
            }

            if (processPayment(scanner, roomNumber, price)) {
                
                System.out.println("\nReservation successful! Here is your receipt:");
                System.out.println("Room Number: " + roomNumber);
                System.out.println("Guest Name: " + guestName);
                System.out.println("Amount Paid: $" + payments[roomNumber - 1]);
                if (tips[roomNumber - 1] > 0) {
                    System.out.println("Tip: $" + tips[roomNumber - 1]);
                }
            } else {
                rooms[roomNumber - 1] = false;  
                guestNames[roomNumber - 1] = null;  
                System.out.println("Reservation failed due to insufficient payment.");
            }
        } else {
            System.out.println("Invalid selection or room already reserved.");
        }
    }

    public static boolean processPayment(Scanner scanner, int roomNumber, double price) {
        System.out.println("Proceed to payment:");
        System.out.println("Total amount due: $" + price);
        System.out.print("Enter the amount to pay: ");  
        double amountPaid = scanner.nextDouble();

        if (amountPaid >= price) {
            payments[roomNumber - 1] = price;  
            if (amountPaid > price) {
                tips[roomNumber - 1] = amountPaid - price;  
                System.out.println("Thank you for the tip of $" + tips[roomNumber - 1] + "!");
            } else {
                tips[roomNumber - 1] = 0; 
            }
            System.out.println("Payment successful. Thank you!");
            return true;
        } else {
            System.out.println("Insufficient amount. Reservation cannot be processed.");
            return false;
        }
    }

    public static void displayRoomAvailability() {
        System.out.println("Room Availability:\n");

        
        boolean standardRoomsAvailable = false;
        for (int i = 0; i < 100; i++) {
            if (!rooms[i]) {
                standardRoomsAvailable = true;
                break;
            }
        }
        if (standardRoomsAvailable) {
            System.out.println("Standard Rooms (1-100) are available.");
        } else {
            System.out.println("All Standard Rooms (1-100) are reserved.");
        }

        
        boolean deluxeRoomsAvailable = false;
        for (int i = 100; i < 200; i++) {
            if (!rooms[i]) {
                deluxeRoomsAvailable = true;
                break;
            }
        }
        if (deluxeRoomsAvailable) {
            System.out.println("Deluxe Rooms (101-200) are available.");
        } else {
            System.out.println("All Deluxe Rooms (101-200) are reserved.");
        }

        System.out.println();  
    }

    public static void checkReservation(Scanner scanner) {
        System.out.print("Enter room number to check reservation: ");
        int roomNumber = scanner.nextInt();

        if (roomNumber >= 1 && roomNumber <= 200) {
            if (rooms[roomNumber - 1]) {
                System.out.println("Room " + roomNumber + " is reserved by " + guestNames[roomNumber - 1] + ".");
                System.out.println("Amount Paid: $" + payments[roomNumber - 1]);
                if (tips[roomNumber - 1] > 0) {
                    System.out.println("Tip: $" + tips[roomNumber - 1]);
                }
            } else {
                System.out.println("Room " + roomNumber + " is available.");
            }
        } else {
            System.out.println("Invalid room number.");
        }
    }

    public static void checkout(Scanner scanner) {
        System.out.print("Enter your room number to checkout: ");
        int roomNumber = scanner.nextInt();

        if (rooms[roomNumber - 1]) {
            rooms[roomNumber - 1] = false;  
            guestNames[roomNumber - 1] = null; 
            payments[roomNumber - 1] = 0;
            tips[roomNumber - 1] = 0;  
            System.out.println("Checkout successful for Room " + roomNumber + ". Thank you for staying with us!");
        } else {
            System.out.println("Room " + roomNumber + " is not currently reserved.");
        }
    }
}
