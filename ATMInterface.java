import java.util.Scanner;

class ATMInterface {

    public static void main(String[] args) {
        ATMSystem atm = new ATMSystem();
        atm.start();
    }
}

class ATMSystem {
    private double balance;
    private final Scanner scanner;

    ATMSystem() {
        scanner = new Scanner(System.in);
        authenticateUser();
        balance = 5000.0; // Initial balance
    }

    private void authenticateUser() {
        System.out.print("Enter your 4-digit PIN: ");
        int pin = scanner.nextInt();

        if (pin != 2654) {
            System.out.println("Incorrect PIN. Access Denied.");
            System.exit(0);
        }

        System.out.println("Login Successful!\n");
    }

    public void start() {
        boolean sessionActive = true;

        while (sessionActive) {
            showMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> withdraw();
                case 2 -> deposit();
                case 3 -> checkBalance();
                case 4 -> {
                    System.out.println("Thank you for using our ATM. Goodbye!");
                    sessionActive = false;
                }
                default -> System.out.println("Invalid choice. Please select again.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\n==== ATM Menu ====");
        System.out.println("1. Withdraw Money");
        System.out.println("2. Deposit Money");
        System.out.println("3. Check Account Balance");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Please enter a valid amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining Balance: ₹" + balance);
        }
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ₹");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Please enter a valid amount.");
        } else {
            balance += amount;
            System.out.println("Deposit successful. Updated Balance: ₹" + balance);
        }
    }

    private void checkBalance() {
        System.out.println("Your current balance is: ₹" + balance);
    }
}
