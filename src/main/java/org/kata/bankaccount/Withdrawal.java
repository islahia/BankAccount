package org.kata.bankaccount;

import java.time.LocalDateTime;

import static org.kata.bankaccount.OperationType.WITHDRAWAL;

public class Withdrawal extends BankTransaction {

    public Withdrawal(LocalDateTime date, int amount, int balance) {
        super(date, amount, balance);
        this.operationType = WITHDRAWAL;
    }

    @Override
    public int apply() {
        if (amount <= balance)
            balance -= amount;
        return balance;
    }
}
