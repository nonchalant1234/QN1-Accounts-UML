/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Account;

import Customer.Customer;
import Statement.Statement;


public abstract class Account implements Statement {
    private String accountNumber;
    private double balance;
    protected Customer customer; // Protected to allow subclasses access
    
    public Account(String accountNumber, double balance, Customer customer) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customer = customer;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public double getBalance() {
        return balance;
    }
    
    protected void setBalance(double balance) {
        this.balance = balance;
    }
    
    public Customer getCustomer() {
        return customer;
    }
    
    // Abstract methods to be implemented by subclasses
    public abstract void withdraw(double amount);
    public abstract void deposit(double amount);
    
    @Override
    public String generateStatement() {
        return "Account Number: " + accountNumber + 
               "\nCurrent Balance: UGX " + String.format("%.2f", balance);
    }
}
