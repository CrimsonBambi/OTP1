package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account(); // fresh account before each test
    }

    // ---------------- Deposit tests ----------------

    @Test
    void testDepositPositiveAmount() {
        account.deposit(100.0);
        assertEquals(100.0, account.getBalance(), 0.0001);

        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), 0.0001);
    }

    @Test
    void testDepositZeroAmount() {
        account.deposit(0.0);
        assertEquals(0.0, account.getBalance(), 0.0001);
    }

    @Test
    void testDepositNegativeAmount() {
        account.deposit(-50.0);
        assertEquals(0.0, account.getBalance(), 0.0001);
    }

    // ---------------- Withdraw tests ----------------

    @Test
    void testWithdrawValidAmount() {
        account.deposit(200.0);
        double withdrawn = account.withdraw(50.0);
        assertEquals(50.0, withdrawn, 0.0001);
        assertEquals(150.0, account.getBalance(), 0.0001);
    }

    @Test
    void testWithdrawZeroAmount() {
        account.deposit(100.0);
        double withdrawn = account.withdraw(0.0);
        assertEquals(0.0, withdrawn, 0.0001);
        assertEquals(100.0, account.getBalance(), 0.0001);
    }

    @Test
    void testWithdrawNegativeAmount() {
        account.deposit(100.0);
        double withdrawn = account.withdraw(-30.0);
        assertEquals(0.0, withdrawn, 0.0001);
        assertEquals(100.0, account.getBalance(), 0.0001);
    }

    @Test
    void testWithdrawMoreThanBalance() {
        account.deposit(50.0);
        double withdrawn = account.withdraw(100.0); // exceeds balance
        assertEquals(0.0, withdrawn, 0.0001);
        assertEquals(50.0, account.getBalance(), 0.0001);
    }

    // ---------------- Balance tests ----------------

    @Test
    void testGetBalanceAfterOperations() {
        assertEquals(0.0, account.getBalance(), 0.0001);

        account.deposit(75.0);
        assertEquals(75.0, account.getBalance(), 0.0001);

        account.withdraw(25.0);
        assertEquals(50.0, account.getBalance(), 0.0001);
    }

    @Test
    void testMultipleOperations() {
        account.deposit(100.0);
        account.withdraw(30.0);
        account.deposit(20.0);
        account.withdraw(50.0);
        assertEquals(40.0, account.getBalance(), 0.0001);
    }
}
