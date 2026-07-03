package CurrentAccount;


import Account.Account;
import Customer.Customer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class CurrentAccount extends Account {
    private double overdraftLimit;
    
    public CurrentAccount(String accountNumber, double balance, 
                          Customer customer, double overdraftLimit) {
        super(accountNumber, balance, customer);
        this.overdraftLimit = overdraftLimit;
    }
    
    public double getOverdraftLimit() {
        return overdraftLimit;
    }
    
    public void setOverdraftLimit(double overdraftLimit) {
        if (overdraftLimit >= 0) {
            this.overdraftLimit = overdraftLimit;
        } else {
            System.out.println("Error: Overdraft limit cannot be negative");
        }
    }
    
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Invalid withdrawal amount");
            return;
        }
        if (getBalance() - amount < -overdraftLimit) {
            System.out.println("Error: Withdrawal denied - exceeds overdraft limit");
            System.out.println("Current balance: UGX " + String.format("%.2f", getBalance()));
            System.out.println("Overdraft limit: UGX " + String.format("%.2f", overdraftLimit));
            System.out.println("Maximum withdrawal: UGX " + 
                             String.format("%.2f", getBalance() + overdraftLimit));
            return;
        }
        setBalance(getBalance() - amount);
        System.out.println("Withdrawal of UGX " + String.format("%.2f", amount) + " successful");
        System.out.println("New balance: UGX " + String.format("%.2f", getBalance()));
        if (getBalance() < 0) {
            System.out.println("*** Account is now in overdraft by UGX " + 
                             String.format("%.2f", Math.abs(getBalance())) + " ***");
        }
    }
    
    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Invalid deposit amount");
            return;
        }
        double oldBalance = getBalance();
        setBalance(getBalance() + amount);
        System.out.println("Deposit of UGX " + String.format("%.2f", amount) + " successful");
        System.out.println("New balance: UGX " + String.format("%.2f", getBalance()));
        if (oldBalance < 0 && getBalance() >= 0) {
            System.out.println("*** Account is now out of overdraft ***");
        }
    }
}
