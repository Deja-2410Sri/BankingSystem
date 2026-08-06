import java.util.ArrayList;
import java.util.Scanner;
class Account {
    private int accountId;
    private String holderName;
    private double balance;
    public Account(int accountId, String holderName, double initialBalance) {
        this.accountId = accountId;
        this.holderName = holderName;
        this.balance = initialBalance;
    }
    public int getAccountId() {
        return accountId;
    }
    public String getHolderName() {
        return holderName;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Successfully deposited ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            System.out.println("Successfully withdrew ₹" + amount);
        } else if (amount > this.balance) {
            System.out.println("Error: Insufficient balance!");
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
    }
}
public class BankingSystem {
    private static ArrayList<Account> accounts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== BANKING SYSTEM (WEEK 1: ARRAYLIST) ===");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    System.out.println("Exiting Application...");
                    return;
                default:
                    System.out.println("Invalid Choice! Try again.");
            }
        }
    }
    private static Account findAccountById(int accId) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountId() == accId) {
                return accounts.get(i); // Account found
            }
        }
        return null; // Account not found
    }
    // 1. Create Account (Checks duplicate ID using iteration)
    private static void createAccount() {
        System.out.print("Enter Account ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        if (findAccountById(id) != null) {
            System.out.println("Error: Account ID already exists! Duplicate IDs not allowed.");
            return;
        }
        System.out.print("Enter Account Holder Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Initial Deposit: ");
        double balance = scanner.nextDouble();
        Account newAcc = new Account(id, name, balance);
        accounts.add(newAcc);
        System.out.println("Account created successfully!");
    }
    // 2. Deposit
    private static void depositMoney() {
        System.out.print("Enter Account ID: ");
        int id = scanner.nextInt();
        Account acc = findAccountById(id);
        if (acc != null) {
            System.out.print("Enter Deposit Amount: ");
            double amount = scanner.nextDouble();
            acc.deposit(amount);
        } else {
            
            System.out.println("Account not found!");
        }
    }
    // 3. Withdraw
    private static void withdrawMoney() {
        System.out.print("Enter Account ID: ");
        int id = scanner.nextInt();
        Account acc = findAccountById(id);
        if (acc != null) {
            System.out.print("PleaseEnter Withdrawal Amount: ");
            double amount = scanner.nextDouble();
            acc.withdraw(amount);
        } else {
            System.out.println("Account not found!");
        }
    }
    private static void checkBalance() {
        System.out.print("Enter Account ID: ");
        int id = scanner.nextInt();
        Account acc = findAccountById(id);
        if (acc != null) {
            System.out.println("\n--- Account Details ---");
            System.out.println("Account ID: " + acc.getAccountId());
            System.out.println("Holder Name: " + acc.getHolderName());
            System.out.println("Current Balance:" + acc.getBalance());
        } else {
            System.out.println("Account not found!");
        }
    }
}
