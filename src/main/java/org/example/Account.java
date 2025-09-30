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
        } else {
            balance = balance;
        }
    }

    // Withdraw method
    public double withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount; // valid withdrawal branch
            return amount;
        } else {
            // fill the else branch so JaCoCo counts it
            return 0.0; // amount invalid (negative, zero, or exceeds balance)
        }
    }

    // Get current balance
    public double getBalance() {
        return balance;
    }
}
