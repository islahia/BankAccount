package org.kata.bankaccount;

import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class BankTransaction implements Serializable {
    @Getter
    protected final LocalDateTime date;
    @Getter
    protected final int amount;

    @Getter
    protected int balance;

    @Getter
    protected OperationType operationType;

    public BankTransaction(LocalDateTime date, int amount,
                           int balance) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    abstract public int apply();


}
