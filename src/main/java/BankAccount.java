import java.math.BigDecimal;

public class BankAccount {

    private final String email;
    private BigDecimal balance;

    public BankAccount(String email, BigDecimal initialBalance) {
        if (!isEmailValid(email)) {
            throw new IllegalArgumentException("Invalid email");
        }
        if (initialBalance == null || initialBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Invalid initial balance");
        }
        this.email = email;
        this.balance = initialBalance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getEmail() {
        return email;
    }

    public void deposit(BigDecimal amount) {
        if (!isAmountValid(amount)) {
            throw new IllegalArgumentException("Invalid amount");
        }
        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        if (!isAmountValid(amount)) {
            throw new IllegalArgumentException("Invalid amount");
        }
        if (amount.compareTo(balance) > 0) {
            throw new IllegalStateException("Insufficient funds");
        }
        balance = balance.subtract(amount);
    }

    public void transfer(BankAccount to, BigDecimal amount) {
        if (to == null) {
            throw new IllegalArgumentException("Target account is null");
        }
        if (!isAmountValid(amount)) {
            throw new IllegalArgumentException("Invalid amount");
        }
        if (amount.compareTo(balance) > 0) {
            throw new IllegalStateException("Insufficient funds");
        }

        this.withdraw(amount);
        to.deposit(amount);
    }

    public boolean isEmailValid(String email) {
        if (email == null) return false;

        String trimmed = email.trim();
        if (trimmed.isEmpty()) return false;

        int atIndex = trimmed.indexOf("@");
        if (atIndex == -1 || atIndex != trimmed.lastIndexOf("@")) return false;
        if (atIndex == 0) return false;

        String domain = trimmed.substring(atIndex + 1);
        if (!domain.contains(".")) return false;
        if (domain.startsWith(".") || domain.endsWith(".")) return false;

        return true;
    }

    public boolean isAmountValid(BigDecimal amount) {
        if (amount == null) return false;
        if (amount.compareTo(BigDecimal.ZERO) <= 0) return false;
        return amount.scale() <= 2;
    }
}
