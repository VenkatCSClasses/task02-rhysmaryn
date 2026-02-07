# BankAccount Specification
This project implements a simple BankAccount class.

Each account has:
- an email
- a balance

The class supports:
- constructor
- getBalance
- getEmail
- deposit
- withdraw
- transfer
- isEmailValid
- isAmountValid

## Constructor
Creates a new BankAccount.

- Email must be valid
- Initial balance must not be null
- Initial balance must be 0 or greater
- Throw IllegalArgumentException if inputs are invalid
