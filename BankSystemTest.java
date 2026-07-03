/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.sacco.banksystemtest;

import CurrentAccount.CurrentAccount;
import Customer.Customer;
import SavingsAccount.SavingsAccount;

/**
 *
 * @author dero
 */
// BankSystemTest.java - Complete demonstration
public class BankSystemTest {
    public static void main(String[] args) {
        System.out.println("=== COMMUNITY BANK SYSTEM ===\n");
        
        // 1. Create a customer
        Customer customer = new Customer("C001", "John Mukasa");
        System.out.println("Customer created: " + customer.getName());
        
        // 2. Create accounts
        SavingsAccount savings = new SavingsAccount("SA001", 1000000.00, customer);
        CurrentAccount current = new CurrentAccount("CA001", 500000.00, customer, 200000.00);
        
        // 3. Add accounts to customer
        customer.addAccount(savings);
        customer.addAccount(current);
        System.out.println();
        
        // 4. Test deposit operations
        System.out.println("--- DEPOSIT OPERATIONS ---");
        savings.deposit(200000.00);
        current.deposit(100000.00);
        System.out.println();
        
        // 5. Test withdrawal operations
        System.out.println("--- WITHDRAWAL OPERATIONS ---");
        System.out.println("Attempting to withdraw UGX 1,500,000 from Savings Account:");
        savings.withdraw(1500000.00); // Should fail - insufficient funds
        
        System.out.println("\nAttempting to withdraw UGX 500,000 from Savings Account:");
        savings.withdraw(500000.00); // Should succeed
        
        System.out.println("\nAttempting to withdraw UGX 700,000 from Current Account:");
        current.withdraw(700000.00); // Should succeed - within overdraft
        
        System.out.println("\nAttempting to withdraw UGX 100,000 from Current Account:");
        current.withdraw(100000.00); // Should fail - exceeds overdraft limit
        System.out.println();
        
        // 6. Test interest
        System.out.println("--- INTEREST OPERATION ---");
        savings.addInterest();
        System.out.println();
        
        // 7. Display all statements
        customer.displayAllStatements();
        
        // 8. Verify total worth
        System.out.println("\n--- TOTAL WORTH VERIFICATION ---");
        System.out.println("Direct calculation: UGX " + 
                         String.format("%.2f", customer.totalWorth()));
        
        // 9. Test generateStatement() individually
        System.out.println("\n--- INDIVIDUAL STATEMENTS ---");
        System.out.println("Savings Account Statement:");
        System.out.println(savings.generateStatement());
        System.out.println("\nCurrent Account Statement:");
        System.out.println(current.generateStatement());
    }
}
