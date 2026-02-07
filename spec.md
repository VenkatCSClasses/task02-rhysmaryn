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

## withdraw
Removes money from the account balance.

- Amount must be greater than 0
- Amount can have at most 2 decimal places
- If amount is greater than balance, throw IllegalStateException

## transfer
Transfers money from one account to another.

- Target account cannot be null
- Amount must be greater than 0
- Amount can have at most 2 decimal places
- If insufficient funds, throw IllegalStateException

## isEmailValid
Checks whether an email is valid.

Returns true if:
- email is not null or blank
- email contains exactly one '@'
- there is at least one character before '@'
- domain contains a '.'
- domain does not start or end with '.'

## isAmountValid
Checks whether a monetary amount is valid.

Returns true if:
- amount is not null
- amount is greater than 0
- amount has at most 2 decimal places
