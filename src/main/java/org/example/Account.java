package org.example;

public class Account {
    private double balance;

    // Default constructor
    public Account() {
        this.balance = 0.0;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Withdraw method
    public double withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return amount;
        }
        return 0.0;
    }

    // Get current balance
    public double getBalance() {
        return balance;
    }
}

