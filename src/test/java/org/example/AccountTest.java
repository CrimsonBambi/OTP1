package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account();  // create a fresh account before each test
    }

    @Test
    void testDeposit() {
        account.deposit(100.0);
        assertEquals(100.0, account.getBalance(), 0.0001);

        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), 0.0001);
    }

    @Test
    void testWithdraw() {
        account.deposit(200.0);
        double withdrawn = account.withdraw(50.0);
        assertEquals(50.0, withdrawn, 0.0001);
        assertEquals(150.0, account.getBalance(), 0.0001);

        // Try to withdraw more than balance
        withdrawn = account.withdraw(300.0);
        assertEquals(0.0, withdrawn, 0.0001);
        assertEquals(150.0, account.getBalance(), 0.0001);
    }

    @Test
    void testGetBalance() {
        assertEquals(0.0, account.getBalance(), 0.0001);
        account.deposit(75.0);
        assertEquals(75.0, account.getBalance(), 0.0001);
    }
}