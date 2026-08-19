import java.util.HashMap;
import java.util.Scanner;

public class BankApp {

    static HashMap<Integer, Account> accounts = new HashMap<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Create Account");
            ystem.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
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
                    System.out.print("Enter Account ID: ");
                    id = sc.nextInt();

                    Account depositAccount = accounts.get(id);

                    if (depositAccount == null) {
                        System.out.println("Account Not Found!");
                    } else {
                        System.out.print("Enter Deposit Amount: ");
                        double amount = sc.nextDouble();

                        if (amount > 0) {
                            depositAccount.deposit(amount);
                            System.out.println("Deposit Successful!");
                            System.out.println("Current Balance: ₹"
                                    + depositAccount.getBalance());
                        } else {
                            System.out.println("Invalid Amount!");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Account ID: ");
                    id = sc.nextInt();

                    Account withdrawAccount = accounts.get(id);

                    if (withdrawAccount == null) {
                        System.out.println("Account Not Found!");
                    } else {
                        System.out.print("Enter Withdraw Amount: ");
                        double amount = sc.nextDouble();

                        if (amount <= 0) {
                            System.out.println("Invalid Amount!");
                        } else if (withdrawAccount.withdraw(amount)) {
                            System.out.println("Withdrawal Successful!");
                            System.out.println("Current Balance: ₹"
                                    + withdrawAccount.getBalance());
                        } else {
                            System.out.println("Insufficient Balance!");
                        }
                    }
                    break;
                  case 4:
                    System.out.print("Enter Account ID: ");
                    id = sc.nextInt();

                    account = accounts.get(id);

                    if (account == null) {
                        System.out.println("Account Not Found!");
                    } else {
                        System.out.println("Current Balance: ₹" + account.balance);
                    }
                    break;
           


                    
                                 case 5:
                    System.out.println("Thank You!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
            
