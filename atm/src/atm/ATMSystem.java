/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atm;

/**
 *
 * @author sswet
 */

import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    
    public boolean withdraw(double amount) {
    // Set a minimum withdrawal limit, for example, $100
    double minimumWithdrawal = 100;
    
    if (balance >= amount && amount >= minimumWithdrawal) {
        balance -= amount;
        return true;
    } else {
        if (amount < minimumWithdrawal) {
            System.out.println("Withdrawal unsuccessful. Minimum withdrawal amount is $" + minimumWithdrawal);
        } else {
            System.out.println("Insufficient funds. Unable to withdraw.");
        }
        return false;
    }
}
}

class ATM {
    private BankAccount bankAccount;
    private Scanner scanner;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void processTransaction() {
        while (true) {
            displayMenu();
            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    bankAccount.deposit(depositAmount);
                    System.out.println("Deposited $" + depositAmount + ". Current balance: $" + bankAccount.getBalance());
                    break;
                case 2:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (bankAccount.withdraw(withdrawAmount)) {
                        System.out.println("Withdrew $" + withdrawAmount + ". Current balance: $" + bankAccount.getBalance());
                    } else {
                        System.out.println("Insufficient funds. Unable to withdraw.");
                    }
                    break;
                case 3:
                    System.out.println("Current balance: $" + bankAccount.getBalance());
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 4.");
            }
        }
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000); // Starting balance of $1000
        ATM atm = new ATM(account);
        atm.processTransaction();
    }
}



