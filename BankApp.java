import java.util.HashMap;
import java.util.Scanner;

public class BankApp {

    static HashMap<Integer, Account> accounts = new HashMap<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Create Account");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Account ID: ");
                    int id = sc.nextInt();

                    if (accounts.containsKey(id)) {
                        System.out.println("Account ID already exists!");
                        break;
                    }

                    sc.nextLine();

                    System.out.print("Enter Account Holder Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();

                    Account account = new Account(id, name, balance);
                    accounts.put(id, account);

                    System.out.println("Account Created Successfully!");
                    break;

                case 2:
                    System.out.println("Thank You!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}