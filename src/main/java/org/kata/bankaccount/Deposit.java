package org.kata.bankaccount;



import java.time.LocalDateTime;

public class Deposit extends BankTransaction{

    public Deposit(LocalDateTime date, int amount, int balance) {
        super(date, amount, balance);
        operationType = OperationType.DEPOSIT;
    }

    @Override
    public int apply() {
        balance += amount;
        return balance;
    }
}
