/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Customer;

/**
 *
 * @author dero
 */
// Customer.java
import CurrentAccount.CurrentAccount;
import Account.Account;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerId;
    private String name;
    private List<Account> accounts;
    
    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.accounts = new ArrayList<>();
    }
    
    public String getCustomerId() {
        return customerId;
    }
    
    public String getName() {
        return name;
    }
    
    public void addAccount(Account account) {
        if (account != null) {
            accounts.add(account);
            System.out.println("Account " + account.getAccountNumber() + 
                             " added to customer " + name);
        } else {
            System.out.println("Error: Cannot add null account");
        }
    }
    
    public List<Account> getAccounts() {
        return new ArrayList<>(accounts); // Return a copy for encapsulation
    }
    
    public double totalWorth() {
        double total = 0.0;
        for (Account account : accounts) {
            total += account.getBalance();
        }
        return total;
    }
    
    public void displayAllStatements() {
        System.out.println("\n=== ACCOUNT STATEMENTS ===");
        System.out.println("Customer: " + name + " (ID: " + customerId + ")");
        System.out.println("Total Accounts: " + accounts.size());
        System.out.println("=" .repeat(40));
        
        if (accounts.isEmpty()) {
            System.out.println("No accounts found for this customer.");
        } else {
            for (int i = 0; i < accounts.size(); i++) {
                Account account = accounts.get(i);
                System.out.println("\nAccount #" + (i + 1));
                System.out.println(account.generateStatement());
                System.out.println("Type: " + account.getClass().getSimpleName());
                if (account instanceof CurrentAccount) {
                    CurrentAccount ca = (CurrentAccount) account;
                    System.out.println("Overdraft Limit: UGX " + 
                                     String.format("%.2f", ca.getOverdraftLimit()));
                }
                System.out.println("-" .repeat(30));
            }
        }
        
        System.out.println("\nTotal Worth: UGX " + 
                         String.format("%.2f", totalWorth()));
        System.out.println("=" .repeat(40));
    }
}
