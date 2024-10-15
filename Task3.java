import java.util.Scanner;

public class SimpleBankingApplication {
    private static double balance = 0.0;
    private static int accountId; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your Account ID: ");
        accountId = scanner.nextInt(); 

        int option;

        do {
            System.out.println("Welcome to the Simple Banking Application");
            System.out.println("Please select an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    checkBalance(scanner);
                    break;
                case 2:
                    depositMoney(scanner);
                    break;
                case 3:
                    withdrawMoney(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using the Simple Banking Application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (option != 4);

        scanner.close();
    }

    public static void checkBalance(Scanner scanner) {
        System.out.print("Enter your account ID: ");
        int id = scanner.nextInt();
        if (id == accountId) {
            System.out.printf("Your current balance is: $%.2f%n", balance);
        } else {
            System.out.println("Invalid account ID.");
        }
    }

    public static void depositMoney(Scanner scanner) {
        System.out.print("Enter your account ID: ");
        int id = scanner.nextInt();
        if (id == accountId) {
            System.out.print("Enter amount to deposit: ");
            double amount = scanner.nextDouble();
            if (amount > 0) {
                balance += amount;
                System.out.printf("Successfully deposited $%.2f. New balance: $%.2f%n", amount, balance);
            } else {
                System.out.println("Invalid amount. Please enter a positive value.");
            }
        } else {
            System.out.println("Invalid account ID.");
        }
    }

    public static void withdrawMoney(Scanner scanner) {
        System.out.print("Enter your account ID: ");
        int id = scanner.nextInt();
        if (id == accountId) {
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.printf("Successfully withdrew $%.2f. New balance: $%.2f%n", amount, balance);
            } else {
                System.out.println("Invalid amount. Please enter a positive value not exceeding your balance.");
            }
        } else {
            System.out.println("Invalid account ID.");
        }
    }
}
