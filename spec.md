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

## getBalance
Returns the current balance.

- Balance should never be negative

## getEmail
Returns the email associated with the account.

## deposit
Adds money to the account balance.

- Amount must be greater than 0
- Amount can have at most 2 decimal places
- Throw IllegalArgumentException if amount is invalid
