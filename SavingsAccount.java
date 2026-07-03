/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SavingsAccount;

import Account.Account;
import Customer.Customer;


public class SavingsAccount extends Account {
    private static final double INTEREST_RATE = 2.5; // 2.5% per annum
    
    public SavingsAccount(String accountNumber, double balance, Customer customer) {
        super(accountNumber, balance, customer);
    }
    
    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Invalid withdrawal amount");
            return;
        }
        if (getBalance() - amount < 0) {
            System.out.println("Error: Insufficient funds. Withdrawal denied.");
            System.out.println("Current balance: UGX " + String.format("%.2f", getBalance()));
            System.out.println("Requested: UGX " + String.format("%.2f", amount));
            return;
        }
        setBalance(getBalance() - amount);
        System.out.println("Withdrawal of UGX " + String.format("%.2f", amount) + " successful");
        System.out.println("New balance: UGX " + String.format("%.2f", getBalance()));
    }
    
    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Invalid deposit amount");
            return;
        }
        setBalance(getBalance() + amount);
        System.out.println("Deposit of UGX " + String.format("%.2f", amount) + " successful");
        System.out.println("New balance: UGX " + String.format("%.2f", getBalance()));
    }
    
    public void addInterest() {
        double interest = getBalance() * (INTEREST_RATE / 100);
        setBalance(getBalance() + interest);
        System.out.println("Interest of UGX " + String.format("%.2f", interest) + 
                           " added at " + INTEREST_RATE + "% rate");
        System.out.println("New balance: UGX " + String.format("%.2f", getBalance()));
    }
}

