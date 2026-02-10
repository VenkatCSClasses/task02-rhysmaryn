import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    void constructor_valid_input() {
        BankAccount account = new BankAccount("user@example.com", new BigDecimal("10.00"));
        assertEquals(0, account.getBalance().compareTo(new BigDecimal("10.00")));
        assertEquals("user@example.com", account.getEmail());
    }

    @Test
    void constructor_invalid_email() {
        assertThrows(IllegalArgumentException.class, () ->
                new BankAccount("userexample.com", new BigDecimal("10.00"))
        );
    }

    @Test
    void deposit_adds_money() {
        BankAccount account = new BankAccount("a@b.com", new BigDecimal("1.00"));
        account.deposit(new BigDecimal("2.50"));
        assertEquals(0, account.getBalance().compareTo(new BigDecimal("3.50")));
    }

    @Test
    void deposit_invalid_amount() {
        BankAccount account = new BankAccount("a@b.com", new BigDecimal("1.00"));
        assertThrows(IllegalArgumentException.class, () ->
                account.deposit(new BigDecimal("0.00"))
        );
    }

    @Test
    void withdraw_removes_money() {
        BankAccount account = new BankAccount("a@b.com", new BigDecimal("10.00"));
        account.withdraw(new BigDecimal("3.00"));
        assertEquals(0, account.getBalance().compareTo(new BigDecimal("7.00")));
    }

    @Test
    void withdraw_insufficient_funds() {
        BankAccount account = new BankAccount("a@b.com", new BigDecimal("2.00"));
        assertThrows(IllegalStateException.class, () ->
                account.withdraw(new BigDecimal("3.00"))
        );
    }

    @Test
    void transfer_moves_money() {
        BankAccount from = new BankAccount("from@x.com", new BigDecimal("10.00"));
        BankAccount to = new BankAccount("to@x.com", new BigDecimal("1.00"));

        from.transfer(to, new BigDecimal("4.00"));

        assertEquals(0, from.getBalance().compareTo(new BigDecimal("6.00")));
        assertEquals(0, to.getBalance().compareTo(new BigDecimal("5.00")));
    }

    @Test
    void email_validation() {
        BankAccount account = new BankAccount("a@b.com", new BigDecimal("1.00"));
        assertTrue(account.isEmailValid("a@b.com"));
        assertFalse(account.isEmailValid("a@@b.com"));
    }

    @Test
    void amount_validation() {
        BankAccount account = new BankAccount("a@b.com", new BigDecimal("1.00"));
        assertTrue(account.isAmountValid(new BigDecimal("1.25")));
        assertFalse(account.isAmountValid(new BigDecimal("1.001")));
    }
}
